import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        id: 'NeunFeldSkalierung',
        title: 'Skalierung über neun Felder kann helfen',
        master: 'Image',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill, wrap 1',
            columnConstraints: '[center, fill]',
            rowConstraints: '[100!, center][center]')
    label('Skalierung über neun Felder', cssClass: 'H1o')
    label('', icon: imageIcon('/9SlicesScale_9Scaling.png'), cssClass: 'image')
    label('', constraints: 'grow')
}
