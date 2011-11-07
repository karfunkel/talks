import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Die Winkel mit GIMP/Photoshop messen',
        master: 'Image',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '[center, fill][center, fill]',
              rowConstraints: '100[top]')
    widget(new ImagePanel(), imagePath: 'prototypen/Angles.png')
    widget(new ImagePanel(), imagePath: 'prototypen/ps-messen.jpg')
}
