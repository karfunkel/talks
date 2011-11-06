import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Kleine Helferlein kosten nichts - Farbpipette',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '100[fill][center][center][center][fill]100',
              rowConstraints: '10[100!, center][100!, center][center, fill]50')
    label('', constraints: 'grow, spany 3')
    label('Linux', cssClass: 'H2o')
    label('Windows', cssClass: 'H2o')
    label('Mac OSX', cssClass: 'H2o')
    label('', constraints: 'grow, spany 3, wrap')
    label('Gpick', cssClass: 'H3')
    label('Colormania', cssClass: 'H3')
    label('Color Picker', cssClass: 'H3', constraints: 'wrap')
    widget(new ImagePanel(), imagePath: 'logos/gpick.png', constraints: 'grow, spanx 3')
}
