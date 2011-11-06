import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        master: 'Intro',
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '100[center, fill]100',
              rowConstraints: '10[center, fill]10')
    widget(new ImagePanel(), imagePath: 'Dominion.png', constraints: 'grow')
}
