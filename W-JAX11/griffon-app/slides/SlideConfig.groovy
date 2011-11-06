import griffon.builder.gfx.GfxNode
import griffon.builder.gfx.GfxContext

import java.awt.geom.AffineTransform
import java.awt.image.BufferedImageOp
import javax.imageio.ImageIO
import javax.swing.JComponent
import java.awt.*
import griffon.builder.css.CSSDecorator
import java.awt.event.ComponentListener

loadImage = { image ->
    if (image instanceof String)
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

backgroundConfig = [
        paint: null,
        image: null,
        node: null,
        composite: null,
        op: null,
        transform: null
]

backgroundPainter = { JComponent p, Graphics2D g ->
    Rectangle bounds = p.bounds
    g.clearRect(bounds.x as int, bounds.y as int, bounds.width as int, bounds.height as int)
    if (backgroundConfig.paint instanceof Paint) {
        g.setPaint(backgroundConfig.paint)
        g.fillRect(bounds.x as int, bounds.y as int, bounds.width as int, bounds.height as int)
    }
    Image image
    if (backgroundConfig.node) {
        def node
        if (backgroundConfig.node instanceof GfxNode)
            node = backgroundConfig.node
        else if (backgroundConfig.node instanceof Closure)
            node = backgroundConfig.node.call(p)
        GfxContext context = new GfxContext()
        image = createCompatibleImage(bounds.width, bounds.height)
        context.g = image.graphics
        context.g.clip = g.clip
        context.component = p
        context.eventTargets = []
        context.groupSettings = [:]
        node.apply(context)
        context.g.dispose()
    } else if (backgroundConfig.image) {
        image = loadImage(backgroundConfig.image)
    }
    if (image) {
        def oldTransform = g.transform
        def oldComposite = g.composite
        if (backgroundConfig.composite instanceof Composite)
            g.composite = backgroundConfig.composite
        if (backgroundConfig.transform instanceof AffineTransform)
            g.transform = backgroundConfig.transform
        if (backgroundConfig.op instanceof BufferedImageOp)
            g.drawImage(image, backgroundConfig.op, 0, 0)
        else
            g.drawImage(image, 0, 0, p)
        if (backgroundConfig.transform)
            g.transform = oldTransform
        if (backgroundConfig.composite)
            g.composite = oldComposite
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
    applyCss("${templateBase}style", component)
    applyCss('style', component)
}

def stream
try {
    def cl = getClass().classLoader
    templateBase = "templates/${app.config.presentation.template}/"
    def resource = "${templateBase}template.groovy"
    stream = cl.getResourceAsStream(resource)
    def cls = new GroovyClassLoader(cl).parseClass(stream, resource)
    build(cls)
} catch (Exception e) {
    // ignore
} finally {
    if (stream)
        stream.close()
}

