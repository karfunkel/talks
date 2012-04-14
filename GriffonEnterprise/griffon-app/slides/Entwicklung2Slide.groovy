slide(id: 'Entwicklung2', title: 'Entwicklung', sub: 'Architektur') {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '30[center, fill, grow]30',
              rowConstraints: '[center, fill, grow]')
    widget(buildMVCGroup('agenda', null, [gap: 20, backgroundColor: color(0xDDFFFFFF), content: {
        panel(content) {
            label('Entwicklung einer Anwendung', cssClass: 'L1o')
            label('Features der Plattform', cssClass: 'L2')
            label('Features für Architekturen', cssClass: 'L2o')
            label('Migration von bestehendem Code', cssClass: 'L1')
            label('Integration in die Unternehmenslandschaft', cssClass: 'L1')
            label('Einarbeitung und Support', cssClass: 'L1')
        }
    }]).view.root)
}
