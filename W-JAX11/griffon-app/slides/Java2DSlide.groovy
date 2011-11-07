import com.bric.image.transition.vanilla.BlendTransition2D

slide(
        title: 'Java2D ist eine unbekannte Perle',
        clientPropertySubIndex: 3,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '100[center]100',
            rowConstraints: '10[center, fill]10')
    panel(opaque: false) {
        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '[left]', rowConstraints: '[center, fill]')
        label("Java2D hat alle wichtigen Elemente", cssClass: 'L1')
        label("Formen (Shape) und Pfade (Path)", cssClass: 'L2')
        label("Strichtypen (Stroke)", cssClass: 'L2')
        label("Farben, Verläufe und Füllmuster (Paint)", cssClass: 'L2')
        label("Auswahl (Clipping)", cssClass: 'L2')
        label("Transformationen", cssClass: 'L2')
        label("Text und Glyphen-Operationen", cssClass: 'L2')
        label("Effekt-Filter (BufferedImageOp)", cssClass: 'L2')
        label("Farbmischfilter (Composite)", cssClass: 'L2')
        label("Verschiedene Farbräume", cssClass: 'L2')
        label("Unterstützung für Devices", cssClass: 'L2')
        label("Drucken", cssClass: 'L2')
        label("", constraints: 'grow')
    }
}
