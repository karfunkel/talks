import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Painter sind pures Java2D',
        master: 'Image',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill, wrap 1',
              columnConstraints: '[left, fill]',
              rowConstraints: '[center][top]')
    label('Wir wollen folgendes Textfeld zeichnen', cssClass: 'H2w')
    widget(new ImagePanel(), imagePath: 'beispiel/TextField.png')
}
