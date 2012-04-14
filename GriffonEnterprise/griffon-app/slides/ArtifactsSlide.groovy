import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Artifacts',
        sub: 'Architektur',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Artifacts.selectedIndex = 0
                    else
                        tab_Artifacts.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_Artifacts.selectedIndex = 1
                    else
                        tab_Artifacts.selectedIndex = 2
                },
                { revert ->
                    if (revert)
                        tab_Artifacts.selectedIndex = 2
                    else
                        tab_Artifacts.selectedIndex = 3
                }
        ],
        title: 'Für Artefakte kann man Templates erstellen'
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel(background: color(0xDDFFFFFF), constraints: 'grow') {
        migLayout(layoutConstraints: 'fill, flowy',
                columnConstraints: '[center]',
                rowConstraints: '10[center]10')
        tabbedPane(id: 'tab_Artifacts', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'Templates', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('Mit create-mvc Vorlagen verwenden', cssClass: 'L1')
                    rtextScrollPane(cssClass: 'L2') {
                        rsyntaxTextArea(editable: false,
                                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL, tabSize: 4, cssClass: 'codeEditor',
                                text: '''% griffon create-mvc -model <template> -view <template> -controller <template> <name>'''
                        )
                    }
                    label('Einfache Textdateien mit Platzhaltern', cssClass: 'L1')
                    label('Müssen unter src/templates/artifacts liegen', cssClass: 'L2')
                }
            }]).view.root)
            rtextScrollPane(title: 'MessageView') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''@artifact.package@import javax.swing.JOptionPane
optionPane( id: 'pane',
            messageType: JOptionPane.INFORMATION_MESSAGE,
            optionType: JOptionPane.DEFAULT_OPTION,
            icon: nuvolaIcon('core', category: 'apps', size: 64),
            message: bind {model.message}
          )'''
                )
            }
            rtextScrollPane(title: 'MessageModel') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''@artifact.package@import groovy.beans.Bindable
class @artifact.name@ {
    @Bindable String message = ''
    @Bindable String title = 'Error'
}'''
                )
            }
            rtextScrollPane(title: 'MessageController') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''@artifact.package@ import java.awt.Window
class @artifact.name@ {
    def model
    def view
    def show = { Window window = null ->
        view.pane.createDialog( window ?: Window.windows.find{it.focused}, model.title).show()
    }
}'''
                )
            }
        }
    }
}