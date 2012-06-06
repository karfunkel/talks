import javax.swing.SwingConstants

slide(id: 'Start', title: 'Start', master:'Gr8conf_Intro') {
    migLayout(layoutConstraints: 'fill, wrap 1',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '100[top]10%[top]')
    label('Repository location', cssClass: 'H0')

    label('https://github.com/aalmiray/gr8conf', cssClass: 'H2')
}
