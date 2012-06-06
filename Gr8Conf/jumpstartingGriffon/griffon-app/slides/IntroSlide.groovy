import javax.swing.SwingConstants

slide(id: 'Start', title: 'Start', master:'Gr8conf_Intro') {
    migLayout(layoutConstraints: 'fill, wrap 1',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '50[][][grow][][grow][grow][]')
    label('Jumpstarting Griffon', cssClass: 'H0', verticalAlignment: SwingConstants.BOTTOM)

    label('Andres Almiray', cssClass: 'H2', verticalAlignment: SwingConstants.BOTTOM)
    label('Canoo Engineering AG', cssClass: 'H3', verticalAlignment: SwingConstants.TOP)
    label('Alexander (Sascha) Klein', cssClass: 'H2', verticalAlignment: SwingConstants.BOTTOM)
    label('BeOne Stuttgart GmbH', cssClass: 'H3', verticalAlignment: SwingConstants.TOP)

    label(icon: imageIcon("$templateBase/gr8conf_big.png"), horizontalAlignment: SwingConstants.CENTER)
}
