slide(id: 'UIToolkits',
        title: 'Alle gängigen UI Toolkits werden unterstützt',
        sub: 'Migration'
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, fill, grow]30',
            rowConstraints: '[center, fill, grow]')
    widget(buildMVCGroup('agenda', null, [backgroundColor: color(0xDDFFFFFF), content: {
        panel(content) {
            label('Alle UI Toolkits sind Plugins', cssClass: 'L1')
            label('Swing', cssClass: 'L2')
            label('SWT', cssClass: 'L2')
            label('JavaFX', cssClass: 'L2')
            label('GroovyFX', cssClass: 'L3')
        }
    }]).view.root)
}
