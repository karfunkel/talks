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
        label("Visuelle Elemente", cssClass: 'L1')
        label("Anordnung / Layout", cssClass: 'L2')
        label("Abstände", cssClass: 'L3')
        label("Winkel", cssClass: 'L3')
        label("Bedienelemente", cssClass: 'L2')
        label("Komponenten", cssClass: 'L3')
        label("Bilder", cssClass: 'L3')
        label("Grafische Stilmittel", cssClass: 'L2')
        label("Farben und -verläufe", cssClass: 'L3')
        label("Zeichensätze", cssClass: 'L3')
        label("Effekte und Filter", cssClass: 'L3')
        label("", constraints: 'grow')
    }
}
