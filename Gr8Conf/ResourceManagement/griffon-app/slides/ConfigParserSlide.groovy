import griffon.slideware.SlideUtils
import org.fife.ui.rsyntaxtextarea.SyntaxConstants

slide(id: 'root',
        title: 'groovy.util.ConfigParser (work in progress)',
        sub: 'ConfigParser') {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    widget(buildMVCGroup('tabSlide', null, [backgroundColor: color(0xAAFFFFFF), content: {
        tabbedPane(pane) {
            panel(title: 'ConfigSlurper++', opaque: false) {
                migLayout(layoutConstraints: 'fill, flowy')
                label('Complete rewrite', cssClass: 'L1')
                label('No 100% replacement', cssClass: 'L1')
                label('Syntax change in reading keys with value AND children', cssClass: 'L2')
                label('Result of keys with value AND children are wrapped', cssClass: 'L3')
                label('Enhancements', cssClass: 'L1')
                label('No creation of empty keys', cssClass: 'L2')
                label('A new node will not be linked before it has a value', cssClass: 'L3')
                label('Delegate-Support with resolveStrategy', cssClass: 'L2')
                label('Closures in Binding won\'t need .call()', cssClass: 'L2')
                label('ConfigNodes will be observable / bindable', cssClass: 'L2')
                label('But: Same writing limitations like ConfigSlurper', cssClass: 'L1')
                label('Find it at: https://github.com/karfunkel/ConfigParser', cssClass: 'L1s')
            }
            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/ConfigParser_hybrids.groovy').text
            ]).view.root, title: 'Hybrid keys')
            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/ConfigParser_hybrids2.groovy').text
            ]).view.root, title: 'Again Hybrid keys')
            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/ConfigParser_Java.groovy').text
            ]).view.root, title: 'Java Usage')
            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/ConfigParser_Conditional.groovy').text
            ]).view.root, title: 'Multiple conditional blocks',)
            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/ConfigParser_Lazy.groovy').text
            ]).view.root, title: 'Dynamic Values')
        }
    }]
    ).view.root)
}
SlideUtils.createDefaultSlideAction(pane, root)
return root
