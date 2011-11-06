import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Designentwürfe können unkonventionell sein',
        master: 'Image',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '[center, fill]',
              rowConstraints: '[center, fill]')
    widget(new ImagePanel(), imagePath: 'prototypen/Prototype.png', constraints: 'grow')
}
