import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'I18n',
        sub: 'Plattform',
        title: 'Globalisierung braucht Internationalisierung',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_I18n.selectedIndex = 0
                    else
                        tab_I18n.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_I18n.selectedIndex = 1
                    else
                        tab_I18n.selectedIndex = 2
                }
        ]
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel(background: color(0xDDFFFFFF)) {
        migLayout(layoutConstraints: 'fill, flowy',
                columnConstraints: '[center]',
                rowConstraints: '10[center]10')
        tabbedPane(id: 'tab_I18n', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'i18n', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('i18n-support', cssClass: 'L1')
                    label('Grundlegende Implementierung basierend auf java.util.ResourceBundle', cssClass: 'L3')
                    label('Unterstützt Default-Werte und Platzhalter für dynamische Werte', cssClass: 'L3')
                    label('i18n', cssClass: 'L1')
                    label('Implementierung basierend auf Spring\'s MessageSource', cssClass: 'L3')
                    label('i18n-gettext', cssClass: 'L1')
                    label('Implementierung im GNU Gettext Style', cssClass: 'L3')
                }
            }]).view.root)
            rtextScrollPane(title: '.properties') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE, tabSize: 4, cssClass: 'codeEditor',
                        text: '''// message.properties
key.static = This is just a text
key.dynamic.byIndex = The key {0} has the value {1}
key.dynamic.byKey = The key {key} has the value {value}
key.dynamic.fancy.impl = #key = #{value*10}

// message_de.properties
key.static = Dies ist nur ein Text'''
                )
            }
            rtextScrollPane(title: 'Benutzung .properties') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''assert 'This is just a text' == getMessage('key.static')

assert 'Test' == getMessage('key.not.existing', 'Test')

assert 'Dies ist nur ein Text' == getMessage('key.static', Locale.GERMAN)

assert 'The key X has the value 100' == getMessage('key.dynamic.byIndex', ['X', 100])

assert 'The key X has the value 100' == getMessage('key.dynamic.byKey', [key: 'X', value: 100])

assert 'X = 1000' == getMessage('key.dynamic.fancy.impl', [key: 'X', value: 100])'''
                )
            }
        }
    }
}