import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'MetaComponents',
        sub: 'Architektur',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_MetaComponents.selectedIndex = 0
                    else
                        tab_MetaComponents.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_MetaComponents.selectedIndex = 1
                    else
                        tab_MetaComponents.selectedIndex = 2
                },
                { revert ->
                    if (revert)
                        tab_MetaComponents.selectedIndex = 2
                    else
                        tab_MetaComponents.selectedIndex = 3
                },
                { revert ->
                    if (revert)
                        tab_MetaComponents.selectedIndex = 3
                    else
                        tab_MetaComponents.selectedIndex = 4
                },
                { revert ->
                    if (revert)
                        tab_MetaComponents.selectedIndex = 4
                    else
                        tab_MetaComponents.selectedIndex = 5
                }
        ],
        title: 'MVCGroups sind als Meta-Komponenten verwendbar'
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel(background: color(0xDDFFFFFF), constraints: 'grow') {
        migLayout(layoutConstraints: 'fill, flowy',
                columnConstraints: '[center]',
                rowConstraints: '10[center]10')
        tabbedPane(id: 'tab_MetaComponents', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            panel(title: 'Ergebnis', background: color(0x00)) {
                migLayout(layoutConstraints: 'flowy',
                        columnConstraints: '[left, grow, fill]',
                        rowConstraints: '[center]')
                widget(buildMVCGroup('media', null, [
                        author: 'Alexander Klein',
                        date: new Date(),
                        text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur nunc velit, molestie at facilisis nec, accumsan eget nibh. Aenean eu tortor vitae ligula auctor porttitor at ullamcorper mi. Ut ipsum augue, sodales eu accumsan pellentesque, pellentesque non libero. Praesent iaculis arcu at purus volutpat molestie vulputate mi pellentesque. Vestibulum id nulla nulla.',
                ]).view.root)
                widget(buildMVCGroup('media', null, [
                        icon: 'AlexanderKlein2.jpg',
                        author: 'Alexander Klein',
                        date: new Date(),
                        format: 'yyyy-MM-dd',
                        text: 'Nunc ante nibh, rutrum id congue dictum, viverra eget arcu. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut vestibulum nibh ac leo scelerisque vestibulum. Donec tristique erat in quam fringilla commodo. Pellentesque urna turpis, facilisis eget gravida vel, rutrum eget sem. Quisque sit amet convallis odio.',
                ]).view.root)
                label('', constraints: 'grow')
            }
            rtextScrollPane(title: 'Application.groovy') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''mvcGroups {
    'media' {
        model      = 'griffonenterprise.DialogModel'
        controller = 'griffonenterprise.DialogController'
        view       = 'griffonenterprise.DialogView'
        config {
            component = true
            format = 'dd.MM.yyyy'
        }
    }
}'''
                )
            }
            rtextScrollPane(title: 'View') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''package griffonenterprise

panel(id: 'root') {
    lineBorder(color:Color.BLACK, thickness:1, parent:true)
    migLayout(layoutConstraints: 'fill', columnConstraints: '[left]20[left]', rowConstraints: '[][]')
    label(icon: bind { imageIcon("/$model.icon") }, constraints: 'spany 2')
    label(text: bind {"$model.author >> ${model.date?.format(model.format)}"}, constraints: 'wrap')
    label(text: bind {"<html>$model.text</html>"}, constraints: 'grow')
}'''
                )
            }
            rtextScrollPane(title: 'Model') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''package griffonenterprise

class DialogModel {
    @Bindable String icon
    @Bindable String author
    @Bindable String text
    @Bindable Date date
    @Bindable String format
}'''
                )
            }
            rtextScrollPane(title: 'Controller') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''package griffonenterprise

class DialogController {
    // these will be injected by Griffon
    DialogModel model
    DialogView view

    void mvcGroupInit(Map args) {
        MVCGroupConfiguration configuration = args.configuration
        model.icon = args.icon ?: configuration?.config.icon ?: 'default.png'
        model.author = args.author ?: configuration?.config.author
        model.date = args.date ?: configuration?.config.date
        model.format = args.format ?: configuration?.config.format
        model.text = args.text ?: configuration?.config.text
    }
}'''
                )
            }
            rtextScrollPane(title: 'Code') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''widget(buildMVCGroup('media', null, [
        author: 'Alexander Klein',
        date: new Date(),
        text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur nunc velit, molestie at facilisis nec, accumsan eget nibh. Aenean eu tortor vitae ligula auctor porttitor at ullamcorper mi. Ut ipsum augue, sodales eu accumsan pellentesque, pellentesque non libero. Praesent iaculis arcu at purus volutpat molestie vulputate mi pellentesque. Vestibulum id nulla nulla.',
]).view.root)

widget(buildMVCGroup('media', null, [
        icon: 'AlexanderKlein2.jpg',
        author: 'Alexander Klein',
        date: new Date(),
        format: 'yyyy-MM-dd',
        text: 'Nunc ante nibh, rutrum id congue dictum, viverra eget arcu. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut vestibulum nibh ac leo scelerisque vestibulum. Donec tristique erat in quam fringilla commodo. Pellentesque urna turpis, facilisis eget gravida vel, rutrum eget sem. Quisque sit amet convallis odio.',
]).view.root)'''
                )
            }
        }
    }
}