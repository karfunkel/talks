package griffonenterprise

panel(id: 'root', background: color(model.backgroundColor)) {
    migLayout(columnConstraints: '0[center, grow]0', rowConstraints: '0[center, grow]0')
    if (model.content != null) {
        panel(id: 'content', background: color(0x00)) {
            if (model.borderThickness > 0)
                lineBorder(color: model.borderColor, thickness: model.borderThickness, parent: true)
            migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '0[left]0', rowConstraints: "0[center]${model.gap}[center]0".toString())
            model.content.content = content
            build(model.content)
        }
    }
}