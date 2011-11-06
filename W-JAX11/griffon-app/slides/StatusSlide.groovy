import com.bric.image.transition.vanilla.BlendTransition2D

slide(
        title: 'Komponenten haben mehrere Status',
        clientPropertySubIndex: 2,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill,',
              columnConstraints: '100[center]100',
              rowConstraints: '10[center, fill]10')
    panel(opaque: false) {
        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '[left]', rowConstraints: '[center, fill]')
        label("Welche Status gibt es?", cssClass: 'L1')
    label("Enabled, Disabled, MouseOver", cssClass: 'L2')
    label("Pressed, Selected, Focused", cssClass: 'L2')
    label("Default-Komponente", cssClass: 'L2')
    label("Welche Kombinationen sind möglich?", cssClass: 'L1')
    label("Wie sieht ein Status aus?", cssClass: 'L1')
    label("Kann ein Status erkannt werden?", cssClass: 'L2')
    label("Ist er über die Komponeten konsistent?", cssClass: 'L2')
    label("", constraints: 'grow')   }
}
