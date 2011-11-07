import com.bric.image.transition.vanilla.BlendTransition2D

slide(
        title: 'Fonts sind eventuell nicht überall installiert',
        clientPropertySubIndex: 2,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '100[center]100',
            rowConstraints: '10[center, fill]10')
    panel(opaque: false) {
        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '[left]', rowConstraints: '[center, fill]')
        label("Müssen Fonts mitgeliefert werden?", cssClass: 'L1')
        label("Sollen sie installiert werden?", cssClass: 'L2')
        label("Fonts können auch local geladen werden", cssClass: 'L2')
        label("Unterstützen die Fonts alle Zeichen?", cssClass: 'L1')
        label("China, Japan, Israel usw.", cssClass: 'L2')
        label("Eventuell alternative oder andere Fonts", cssClass: 'L2')
        label("", constraints: 'grow')
    }
}
