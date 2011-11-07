import com.bric.image.transition.vanilla.BlendTransition2D

slide(
        title: 'Eine Oberfläche hat viele Facetten',
        clientPropertySubIndex: 0,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '100[center]100',
            rowConstraints: '10[center, fill]10')
    panel(opaque: false) {
        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '[left]', rowConstraints: '[center, fill]')
        label("Dynamisches Verhalten", cssClass: 'L1')
        label("Größenveränderung (Resizing)", cssClass: 'L2')
        label("Zustände von Komponenten", cssClass: 'L2')
        label("MouseOver, Selected, Disabled, ...", cssClass: 'L3')
        label("Default-Komponente", cssClass: 'L3')
        label("Devicebezogene Anforderungen", cssClass: 'L1')
        label("Bedienkonzepte", cssClass: 'L2')
        label("Tastatur, Touch, Gesten, ...", cssClass: 'L3')
        label("Größenverhältnisse", cssClass: 'L2')
        label("Rechtliches", cssClass: 'L1')
        label("Lizenzen", cssClass: 'L2')
        label("", constraints: 'grow')
    }
}

