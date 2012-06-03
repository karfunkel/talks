slide(id: 'Agenda', title: 'Agenda', sub: null) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, fill, grow]30',
            rowConstraints: '[center, fill, grow]')
    widget(buildMVCGroup('agenda', null, [backgroundColor: color(0xAAFFFFFF), content: {
        panel(content) {
            label('Java', cssClass: 'L1')
            label('java.util.ResourceBundle', cssClass: 'L2')
            label('Apache Commons Configuration', cssClass: 'L2')
            label('Swing Application Framework (JSR 296)', cssClass: 'L2')
            label('Groovy', cssClass: 'L1')
            label('groovy.util.ConfigSlurper', cssClass: 'L2')
            label('groovy.util.ConfigParser', cssClass: 'L2')
            label('Griffon', cssClass: 'L1')
            label('i18n-support plugin', cssClass: 'L2')
            label('resources plugin', cssClass: 'L2')
        }
    }]).view.root)
}