import griffon.slideware.SlideUtils
import org.fife.ui.rsyntaxtextarea.SyntaxConstants

slide(id: 'root',
        title: 'I18n-Support plugin',
        sub: 'I18n-Support') {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    widget(buildMVCGroup('tabSlide', null, [backgroundColor: color(0xAAFFFFFF), content: {
        tabbedPane(pane) {
            panel(title: 'griffon-app/i18n', opaque: false) {
                migLayout(layoutConstraints: 'fill, flowy')
                label('Base-implementation based on ResourceBundle', cssClass: 'L1')
                label('griffon-app/i18n/messages.properties will be used', cssClass: 'L1')
                label('Config.groovy: i18n.basename = \'messages\'', cssClass: 'L2')
                label('Usage with injected getMessage()', cssClass: 'L1')
                widget(buildMVCGroup('editor', null, [
                        syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                        cssClass: 'codeEditor',
                        text: I18nSupportSlide.getResource('data/getMessage.groovy').text
                ]).view.root)
            }

            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/getMessage2.groovy').text
            ]).view.root, title: 'Variable replacement')

            panel(title: 'Pro and Contra', opaque: false) {
                migLayout(layoutConstraints: 'fill, flowy')
                label('Pro', cssClass: 'L1')
                label('getMessage() injected almost everywhere', cssClass: 'L2')
                label('Automatically instantiated', cssClass: 'L2')
                label('Default values', cssClass: 'L2')
                label('Variable replacements', cssClass: 'L2')
                label('Contra', cssClass: 'L1')
                label('Same limitations as ResourceBundles', cssClass: 'L2')
            }
        }
    }]
    ).view.root)
}
SlideUtils.createDefaultSlideAction(pane, root)
return root
