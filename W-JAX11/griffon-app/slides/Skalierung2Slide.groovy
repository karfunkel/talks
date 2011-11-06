import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        id: 'Skalierung',
        title: 'Normale Skalierung oft nicht brauchbar',
        master: 'Image',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill, wrap 1',
            columnConstraints: '[center, fill]',
            rowConstraints: '[100!, center][center]')
    label('Normale Skalierung', id: 'slideLabel', cssClass: 'H1o')
    label('', id: 'slideImage', icon: imageIcon('/9SlicesScale_Scaling.png'), cssClass: 'image')
    label('', constraints: 'grow')
}
