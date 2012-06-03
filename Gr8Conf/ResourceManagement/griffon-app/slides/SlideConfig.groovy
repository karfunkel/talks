import griffon.builder.css.CSSDecorator
import griffon.builder.gfx.GfxContext
import griffon.builder.gfx.GfxNode
import java.awt.geom.AffineTransform
import java.awt.image.BufferedImageOp
import javax.imageio.ImageIO
import javax.swing.JComponent
import java.awt.*

getMasterPart = { slide, name, args = [] ->
    def master = this."master_${slide.master ?: 'Default'}"
    if(!master)
        return null
    def part = master."$name"
    if(part instanceof Closure)
        return part.call(*([slide] + args))
    else
        return part
}

withMaster = {slide, String name, Class type = null, Closure closure ->
    def part = getMasterPart(slide, name)
    if(part == null)
        return null
    if(type != null && !type.isAssignableFrom(part.getClass()))
        return null
    closure.call(part)
}

loadImage = { image ->
    if (image instanceof GString)
        return ImageIO.read(Thread.currentThread().contextClassLoader.getResource(image.toString()))
    else if (image instanceof String)
        return ImageIO.read(Thread.currentThread().contextClassLoader.getResource(image))
    else if (image instanceof URL)
        return ImageIO.read(image)
    else if (image instanceof File)
        return ImageIO.read(image)
    else if (image instanceof InputStream)
        return ImageIO.read(image)
    else if (image instanceof Image)
        return image
    else
        return null
}

createCompatibleImage = {def width, def height ->
    GraphicsConfiguration gc = GraphicsEnvironment.localGraphicsEnvironment.defaultScreenDevice.defaultConfiguration
    gc.createCompatibleImage(width as int, height as int, Transparency.TRANSLUCENT as int)
}

backgroundPainter = { JComponent p, Graphics2D g ->
    Rectangle bounds = p.bounds
    g.clearRect(bounds.x as int, bounds.y as int, bounds.width as int, bounds.height as int)
    withMaster(p, 'paint', Paint) { Paint paint ->
        g.paint = paint
        g.fillRect(bounds.x as int, bounds.y as int, bounds.width as int, bounds.height as int)
    }
    Image image
    withMaster(p, 'node', GfxNode) { GfxNode node ->
        GfxContext context = new GfxContext()
        image = createCompatibleImage(bounds.width, bounds.height)
        context.g = image.graphics
        context.g.clip = g.clip
        context.component = p
        context.eventTargets = []
        context.groupSettings = [:]
        node.apply(context)
        context.g.dispose()
    }
    if(image == null) {
        withMaster(p, 'image') { def img ->
            if(img instanceof Image)
                image = img
            else
                image = loadImage(img)
        }
    }
    if (image) {
        def oldTransform = g.transform
        def oldComposite = g.composite
        try{
            withMaster(p, 'composite', Composite) { Composite composite ->
                g.composite = composite
            }
            withMaster(p, 'transform', AffineTransform) { AffineTransform transform ->
                g.transform = transform
            }
            def op = getMasterPart(p, 'op')
            if (op instanceof BufferedImageOp)
                g.drawImage(image, op, 0, 0)
            else
                g.drawImage(image, 0, 0, p)
        } finally {
            g.transform = oldTransform
            g.composite = oldComposite
        }
    }
}

applyCss = { String css, component ->
    if (!css.toLowerCase().endsWith(".css"))
        css = css + ".css";
    if (getClass().classLoader.getResource(css))
        CSSDecorator.decorate(css, component)
}

templateBase = ''

decorateCss = { component ->
    applyCss("$templateBase/style", component)
    applyCss('style', component)
}

def stream
try {
    def cl = getClass().classLoader
    templateBase = "templates/${app.config.presentation.template}"
    def resource = "$templateBase/template.groovy"
    stream = cl.getResourceAsStream(resource)
    def cls = new GroovyClassLoader(cl).parseClass(stream, resource)
    builder.build(cls)
} finally {
    if (stream)
        stream.close()
}

createHeader = { slide, page ->
    getMasterPart(slide, 'header', [page])
}

createFooter = { slide, page ->
    getMasterPart(slide, 'footer', [page])
}

