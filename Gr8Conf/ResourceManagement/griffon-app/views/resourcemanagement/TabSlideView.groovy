package resourcemanagement

panel(id: 'root', background: new Color(255, 255, 255, 170)) {
    migLayout(columnConstraints: '0[center, grow]0', rowConstraints: '0[center, grow]0')
    if (model.content != null) {
        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: "${model.gap}[center]${model.gap}".toString(), rowConstraints: "${model.gap}[center]${model.gap}".toString())
        tabbedPane(id: 'pane', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'grow')
        if (model.content != null) {
            model.content.pane = pane
            build(model.content)
        }
    }
}

