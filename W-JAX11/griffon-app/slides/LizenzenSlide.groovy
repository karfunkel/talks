import com.bric.image.transition.vanilla.BlendTransition2D

slide(
        title: 'Rechte werden gerne vergessen',
        clientPropertySubIndex: 2,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '100[center]100',
            rowConstraints: '10[center, fill]10')
    panel(opaque: false) {
        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '[left]', rowConstraints: '[center, fill]')
        label("Was muss lizenziert werden?", cssClass: 'L1')
        label("Bilder", cssClass: 'L2')
        label("Fonts", cssClass: 'L2')
        label("Was muss dafür getan werden?", cssClass: 'L1')
        label("Bezahlung", cssClass: 'L2')
        label("Namensnennung", cssClass: 'L2')
        label("Lizenzierungsmodell der Software !!!", cssClass: 'L2')
        label("", constraints: 'grow')
    }
}
