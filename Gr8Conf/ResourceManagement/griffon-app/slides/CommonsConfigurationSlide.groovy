import griffon.slideware.SlideUtils
import org.fife.ui.rsyntaxtextarea.SyntaxConstants

slide(id: 'root',
        title: 'Apache commons configuration',
        sub: 'Commons Configuration') {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    widget(buildMVCGroup('tabSlide', null, [backgroundColor: color(0xAAFFFFFF), content: {
        tabbedPane(pane) {
            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_XML,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/config.xml').text
            ]).view.root, title: 'config.xml')

            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_JAVA,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/Configuration.groovy').text
            ]).view.root, title: 'Usage')

            panel(title: 'Pro and Contra', opaque: false) {
                migLayout(layoutConstraints: 'fill, flowy')
                label('Pro', cssClass: 'L1')
                label('Type support', cssClass: 'L2')
                label('Support for multiple formats', cssClass: 'L2')
                label('Custom formats possible', cssClass: 'L2')
                label('Reference and variable support', cssClass: 'L2')
                label('Contra', cssClass: 'L1')
                label('No native Locale support', cssClass: 'L2')
                label('Manual language switching at runtime is difficult', cssClass: 'L3')
                label('Only basic types supported', cssClass: 'L2')
                label('Many dependencies', cssClass: 'L2')
            }
        }
    }]
    ).view.root)
}
SlideUtils.createDefaultSlideAction(pane, root)
return root
