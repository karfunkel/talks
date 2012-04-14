import javax.swing.SwingConstants

slide(id: 'Start', title: 'Start', master:'Intro') {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[grow, fill]')
    label('Griffon', cssClass: 'H1w', verticalAlignment: SwingConstants.BOTTOM, constraints: 'wrap')
    label('ein Blick durch die Enterprise-Brille', cssClass: 'H3w', verticalAlignment: SwingConstants.TOP)
}
