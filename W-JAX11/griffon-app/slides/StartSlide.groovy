slide(
        master: 'Intro',
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '100[center]100',
              rowConstraints: '30[center]80[center]')
    label('Von der Designergrafik', cssClass: 'H1w', constraints: 'al left, wrap')
    label('zur Oberfläche', cssClass: 'H1w', constraints: 'al right')
}
