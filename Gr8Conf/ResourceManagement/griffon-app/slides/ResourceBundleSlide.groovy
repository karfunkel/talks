import griffon.slideware.SlideUtils
import org.fife.ui.rsyntaxtextarea.SyntaxConstants

slide(id: 'root',
        title: 'java.util.ResourceBundle',
        sub: 'ResourceBundle') {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    widget(buildMVCGroup('tabSlide', null, [backgroundColor: color(0xAAFFFFFF), content: {
        tabbedPane(pane) {
            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/i18n.properties').text
            ]).view.root, title: 'i18n.properties')

            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/i18n_de.properties').text
            ]).view.root, title: 'i18n_de.properties')

            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_JAVA,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/ResourceBundle.groovy').text
            ]).view.root, title: 'Usage')

            panel(title: 'Pro and Contra', opaque: false) {
                migLayout(layoutConstraints: 'fill, flowy')
                label('Pro', cssClass: 'L1')
                label('Java Standard', cssClass: 'L2')
                label('Commonly used', cssClass: 'L3')
                label('Broad tool support', cssClass: 'L2')
                label('Contra', cssClass: 'L1')
                label('No types, just Strings', cssClass: 'L2')
                label('Leads to Proprietary solutions', cssClass: 'L3')
                label('Only Locale-based variation', cssClass: 'L2')
                label('Multiple ResourceBundles needed', cssClass: 'L3')
                label('Only .properties files and classes', cssClass: 'L2')
            }
        }
    }]
    ).view.root)
}
SlideUtils.createDefaultSlideAction(pane, root)
return root
