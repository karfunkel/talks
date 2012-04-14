slide(id: 'Fazit',
        title: 'Griffon ist reif für Enterprise',
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, fill, grow]30',
            rowConstraints: '[center, fill, grow]')
    widget(buildMVCGroup('agenda', null, [backgroundColor: color(0xDDFFFFFF), content: {
        panel(content) {

        }
    }]).view.root)
}
