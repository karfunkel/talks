import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Farbverläufe sollte man nachprobieren',
        master: 'Image',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill, wrap 1',
              columnConstraints: '[left, fill]',
              rowConstraints: '[center][center, fill]')
    label("Farbverläufe immer nachstellen", cssClass: 'H2w')
    widget(new ImagePanel(), imagePath: 'prototypen/Pipette2.png', constraints: 'grow')
}
