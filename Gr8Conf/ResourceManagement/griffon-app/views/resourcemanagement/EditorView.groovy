package resourcemanagement

import org.fife.ui.rsyntaxtextarea.SyntaxConstants

rtextScrollPane(id: 'root') {
    rsyntaxTextArea(editable: model.editable,
            syntaxEditingStyle: model.syntax,
            tabSize: model.tabSize,
            cssClass: model.cssClass,
            text: model.text
    )
}
