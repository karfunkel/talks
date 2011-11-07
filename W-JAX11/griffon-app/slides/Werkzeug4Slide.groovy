import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Kleine Helferlein kosten nichts - Fontbetrachter',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '100[fill][center][fill]100',
              rowConstraints: '10[100!, center][100!, center][center, fill]50')
    label('', constraints: 'grow, spany 3')
    label('Java', cssClass: 'H2o')
    label('', constraints: 'grow, spany 3, wrap')
    label('Opcion Font Viewer', cssClass: 'H3', constraints: 'wrap')
    widget(new ImagePanel(), imagePath: 'logos/opcion.jpg', constraints: 'grow')
}
