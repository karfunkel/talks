import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Swing-MVC ist eher Presentation Model',
        master: 'Image',
        clientPropertySubIndex: 3,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill, wrap 1',
              columnConstraints: '[left, fill]',
              rowConstraints: '[center][center, fill]')
    label("Swing-Architektur", cssClass: 'H2w')
    widget(new ImagePanel(), imagePath: 'MVC.png', constraints: 'grow')
    label("http://java.sun.com/products/jfc/tsc/articles/architecture", cssClass: 'H4w')
}
