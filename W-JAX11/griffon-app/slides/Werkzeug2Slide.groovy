import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Kleine Helferlein kosten nichts - Lineal',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '100[fill][center][center][center][fill]100',
              rowConstraints: '10[100!, center][100!, center][center, fill]50')
    label('', constraints: 'grow, spany 3')
    label('Linux', cssClass: 'H2o')
    label('Windows', cssClass: 'H2o')
    label('Mac OSX', cssClass: 'H2o')
    label('', constraints: 'grow, spany 3, wrap')
    label('KRuler', cssClass: 'H3')
    label('Cool Ruler', cssClass: 'H3')
    label('Free Ruler', cssClass: 'H3', constraints: 'wrap')
    widget(new ImagePanel(), imagePath: 'logos/kruler.png', constraints: 'grow, spanx 3')
}
