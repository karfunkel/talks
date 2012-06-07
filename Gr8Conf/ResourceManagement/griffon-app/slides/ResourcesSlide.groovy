import griffon.slideware.SlideUtils
import org.fife.ui.rsyntaxtextarea.SyntaxConstants

slide(id: 'root',
        title: 'Resources plugin',
        sub: 'Resources') {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    widget(buildMVCGroup('tabSlide', null, [backgroundColor: color(0xAAFFFFFF), content: {
        tabbedPane(pane) {
            panel(title: 'i18n-support implementation', opaque: false) {
                migLayout(layoutConstraints: 'fill, flowy')
                label('Implementation of i18n-support with all features', cssClass: 'L1')
                label('ConfigSlurper used for implementation', cssClass: 'L1')
                label('ConfigParser coming soon', cssClass: 'L2')
                label('Accessable with getMessage() and more \'groovy\':', cssClass: 'L1')
                label('messageSource, i18n, resourceManager, rm', cssClass: 'L2')
                widget(buildMVCGroup('editor', null, [
                        syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                        cssClass: 'codeEditor',
                        text: I18nSupportSlide.getResource('data/resourceManager.groovy').text
                ]).view.root, constraints: 'grow')
            }
            panel(title: 'Customization', opaque: false) {
                migLayout(layoutConstraints: 'fill, flowy')
                label('Class-based resources possible', cssClass: 'L1')
                label('Looks for MyClassResources.* in the SAME package as the class', cssClass: 'L2')
                label('Suffix is configurable', cssClass: 'L3')
                label('access with \'rm[MyClass].key\'', cssClass: 'L2')
                label('Enabled for all artifacts by default (no need of rm[Class])', cssClass: 'L2')
                label('Custom variants possible', cssClass: 'L1')
                label('rm.customSuffixes = [\'windows\', \'x64\']', cssClass: 'L2')
                label('messages_windows_de.groovy / messages_x64.groovy', cssClass: 'L3')
                label('Resolving:', cssClass: 'L1')
                label('class_custom_locale -> class_locale -> class', cssClass: 'L2')
                label('bundle_custom_locale -> bundle_locale -> bundle', cssClass: 'L2')
                label('Always .groovy/.class before .properties', cssClass: 'L2')
            }
            panel(title: 'BuilderSupport', opaque: false) {
                migLayout(layoutConstraints: 'fill, flowy')
                label('All configured builder nodes can be accessed', cssClass: 'L1')
                label('Enables customized/localized code and views', cssClass: 'L2')
                label('ResourceBuilder helps in defining resources:', cssClass: 'L1')
                widget(buildMVCGroup('editor', null, [
                        syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                        cssClass: 'codeEditor',
                        text: ResourceBundleSlide.getResource('data/resourceManager2.groovy').text
                ]).view.root, constraints: 'grow')
            }
            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/resourceManager3.groovy').text
            ]).view.root, title: 'Injection')
            widget(buildMVCGroup('editor', null, [
                    syntax: SyntaxConstants.SYNTAX_STYLE_GROOVY,
                    cssClass: 'codeEditor',
                    text: ResourceBundleSlide.getResource('data/resourceManager4.groovy').text
            ]).view.root, title: 'Injection continued')
            panel(title: 'Future', opaque: false) {
                migLayout(layoutConstraints: 'fill, flowy')
                label('ResourceManager will merge into Griffon Core', cssClass: 'L1')
                label('Application.groovy will be customizable', cssClass: 'L2')
                label('Locale- or customer-dependent MVC-groups / -artifacts / -configuration', cssClass: 'L3')
                label('Config.groovy will be customizable', cssClass: 'L2')
                label('Your own configuration will be customizable too', cssClass: 'L3')
                label('I18n is a core feature at last', cssClass: 'L2')
            }
        }
    }]
    ).view.root)
}
SlideUtils.createDefaultSlideAction(pane, root)
return root
