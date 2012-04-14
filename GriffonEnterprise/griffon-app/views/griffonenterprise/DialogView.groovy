package griffonenterprise

panel(id: 'root') {
    lineBorder(color:Color.BLACK, thickness:1, parent:true)
    migLayout(layoutConstraints: 'fill', columnConstraints: '[left]20[left]', rowConstraints: '[][]')
    label(icon: bind { imageIcon("/$model.icon") }, constraints: 'spany 2')
    label(text: bind {"$model.author >> ${model.date?.format(model.format)}"}, constraints: 'wrap')
    label(text: bind {"<html>$model.text</html>"}, constraints: 'grow')
}
