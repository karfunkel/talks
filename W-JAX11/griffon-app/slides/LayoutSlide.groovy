import com.bric.image.transition.vanilla.MotionBlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Das Layout teilt die Grafik in Bereiche',
        master: 'Image',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter,
        transition: new MotionBlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '[center, fill]',
              rowConstraints: '[center, fill]')
    widget(new ImagePanel(), imagePath: 'prototypen/Layout.png', constraints: 'grow')
}
