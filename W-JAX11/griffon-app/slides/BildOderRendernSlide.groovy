import com.bric.image.transition.vanilla.BlendTransition2D

slide(
        title: 'Bilder sind einfacher, Rendern meistens schöner',
        clientPropertySubIndex: 0,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '100[center]100',
            rowConstraints: '10[center, fill]10')
    panel(opaque: false) {
        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '[left]', rowConstraints: '[center, fill]')
        label("Erkennen und entscheiden:", cssClass: 'L1')
        label("Bilder sind i.d.R. vorhanden/freistellbar", cssClass: 'L2')
        label("Muss es skalieren?", cssClass: 'L3')
        label("Wie skaliere ich am besten?", cssClass: 'L3')
        label("Vektorgrafiken", cssClass: 'L2')
        label("Skalieren gut - Unterstützung für SVG (Batik)", cssClass: 'L3')
        label("Photoshop exportiert oft 'schlecht' in SVG", cssClass: 'L3')
        label("Rendern oft aufwändiger", cssClass: 'L2')
        label("Java2D sehr mächtig", cssClass: 'L3')
        label("", constraints: 'grow')
    }
}
