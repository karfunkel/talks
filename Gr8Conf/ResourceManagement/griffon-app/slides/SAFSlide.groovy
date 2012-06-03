import griffon.slideware.SlideUtils
import org.fife.ui.rsyntaxtextarea.SyntaxConstants

slide(id: 'root',
        title: 'Swing Application Framework ResourceMap',
        sub: 'Swing Application Framework') {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    widget(buildMVCGroup('tabSlide', null, [backgroundColor: color(0xAAFFFFFF), content: {
        tabbedPane(pane) {
            panel(title: 'SAF', opaque: false) {
                migLayout(layoutConstraints: 'fill, flowy')
                label('JSR 296 on hold since 2009', cssClass: 'L1')
                label('Better Swing Aplication Framework http://kenai.com/projects/bsaf', cssClass: 'L2')
                label('ResourceMap excert', cssClass: 'L1')
                label('TreasureMap https://github.com/dteoh/treasuremap', cssClass: 'L2')
                label('Architecture', cssClass: 'L1')
                label('Uses ResourceBundles internally', cssClass: 'L2')
                label('Spread location of ResourceBundle files', cssClass: 'L2')
                label('One global ResourceBundle', cssClass: 'L3')
                label('One optional ResourceBundle for each Class', cssClass: 'L3')
                label('Located in a \'resources\' subpackage in parallell to the Class', cssClass: 'L3')
            }

            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_JAVA,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/ResourceMap.groovy').text
            ]).view.root, title: 'Creating a ResourceMap')

            panel(title: 'Pro and Contra', opaque: false) {
                migLayout(layoutConstraints: 'fill, flowy')
                label('Pro', cssClass: 'L1')
                label('Locales supported', cssClass: 'L2')
                label('Type support', cssClass: 'L2')
                label('via ResourceConverters extendable', cssClass: 'L3')
                label('Supports multiple bundles within class hierarchy', cssClass: 'L2')
                label('many, but smaller bundles', cssClass: 'L3')
                label('Variable injection', cssClass: 'L2')
                label('Resource injection', cssClass: 'L2')
                label('Contra', cssClass: 'L1')
                label('Bundle-location fixed', cssClass: 'L2')
                label('Only Locale-based variation', cssClass: 'L2')
                label('(Almost) dead project', cssClass: 'L2')
            }
        }
    }]
    ).view.root)
}
SlideUtils.createDefaultSlideAction(pane, root)
return root
