import griffon.slideware.SlideUtils
import org.fife.ui.rsyntaxtextarea.SyntaxConstants

slide(id: 'root',
        title: 'groovy.util.ConfigSlurper',
        sub: 'ConfigSlurper') {
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
                    syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/i18n.groovy').text
            ]).view.root, title: 'i18n.groovy')

            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/ConfigSlurper.groovy').text
            ]).view.root, title: 'Usage')

            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/ConfigSlurper2.groovy').text
            ]).view.root, title: 'Options')

            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/ConfigSlurper4.groovy').text
            ]).view.root, title: 'More Options')

            panel(title: 'Limitations', opaque: false) {
                migLayout(layoutConstraints: 'fill, flowy')
                label('Closures in binding have to be called with call', cssClass: 'L2')
                label('No delegate for parsing', cssClass: 'L2')
                label('Usage from Java only via .getProperty()', cssClass: 'L2')
                label('Unintuitive syntax for keys with value AND children', cssClass: 'L2')
                widget(buildMVCGroup('editor', null, [
                        syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                        cssClass: 'codeEditor',
                        text: ResourceBundleSlide.getResource('data/ConfigSlurper3.groovy').text
                ]).view.root)
            }

            panel(title: 'Pro and Contra', opaque: false) {
                migLayout(layoutConstraints: 'fill, flowy')
                label('Pro', cssClass: 'L1')
                label('Groovy and .properties possible', cssClass: 'L2')
                label('Using groovy is powerfull', cssClass: 'L2')
                label('Full type support', cssClass: 'L3')
                label('Pre-compilable', cssClass: 'L2')
                label('Conditional blocks (environments)', cssClass: 'L2')
                label('Binding to fill values', cssClass: 'L2')
                label('Contra', cssClass: 'L1')
                label('Closures in Binding need .call()', cssClass: 'L2')
                label('Limitations for Key usage', cssClass: 'L2')
                label('Checking for key existance creates a new, empty entry', cssClass: 'L2')
                label('Writing suppoprt is limited', cssClass: 'L2')
            }
        }
    }]
    ).view.root)
}
SlideUtils.createDefaultSlideAction(pane, root)
return root
