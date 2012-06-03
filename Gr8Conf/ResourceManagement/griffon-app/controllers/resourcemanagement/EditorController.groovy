package resourcemanagement

import org.fife.ui.rsyntaxtextarea.SyntaxConstants

class EditorController {
    // these will be injected by Griffon
    def model
    def view

    void mvcGroupInit(Map args) {
        MVCGroupConfiguration configuration = args.configuration
        model.editable = args.editable ?: configuration?.config.editable ?: false
        model.text = args.text ?: configuration?.config.text ?: ''
        model.tabSize = args.tabSize ?: configuration?.config.tabSize ?: 4
        model.cssClass = args.cssClass ?: configuration?.config.cssClass ?: 'codeEditor'
        model.syntax = args.syntax ?: configuration?.config.syntax ?: SyntaxConstants.SYNTAX_STYLE_GROOVY
        if (!model.syntax.startsWith('text/'))
            model.syntax = 'text/' + model.syntax
    }
}
