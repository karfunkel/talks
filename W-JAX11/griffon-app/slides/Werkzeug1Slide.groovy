import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Grafiksoftware ist für jeden verfügbar',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill, wrap 2',
              columnConstraints: '100[center, fill][center, fill]100',
              rowConstraints: '10[center, fill][center, fill]10')
    widget(new ImagePanel(), imagePath: 'logos/gimp.png', constraints: 'grow')
    widget(new ImagePanel(), imagePath: 'logos/inkscape.png', constraints: 'grow')
    widget(new ImagePanel(), imagePath: 'logos/photoshop.png', constraints: 'grow')
    widget(new ImagePanel(), imagePath: 'logos/illustrator.png', constraints: 'grow')
}
