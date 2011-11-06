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
    label('Orginal', cssClass: 'H1o')
    label('', id: 'slideImage_9', icon: imageIcon('/9SlicesScale.png'), cssClass: 'image')
    label('', constraints: 'grow')
}

