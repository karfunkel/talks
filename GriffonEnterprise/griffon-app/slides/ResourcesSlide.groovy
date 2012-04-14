import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Resources',
        sub: 'Plattform',
        title: 'Resourcenmanagement ist erweitertes I18n',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Resources.selectedIndex = 0
                    else
                        tab_Resources.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_Resources.selectedIndex = 1
                    else
                        tab_Resources.selectedIndex = 2
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
        tabbedPane(id: 'tab_Resources', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'resources', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('resources-Plugin', cssClass: 'L1')
                    label('Implementierung von i18n-support', cssClass: 'L2')
                    label('Unterstützt .properties und .groovy Dateien', cssClass: 'L2')
                    label('Übersetzung aller Resourcentypen (auch Bilder etc.)', cssClass: 'L2')
                    label('Unterstützt dynamisch erzeugte Resourcen', cssClass: 'L2')
                    label('Kunden-/Umgebungsspezifisches Resourcenhandling', cssClass: 'L2')
                    label('Builder zur leichteren Erstellung von Resourcen', cssClass: 'L2')
                    label('Optionale Injizierung von Resourcen in Klassen', cssClass: 'L2')
                }
            }]).view.root)
            rtextScrollPane(title: '.groovy') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''// messages.groovy
key {
    static = 'This is just a text'
    object = Locale.GERMAN
    closure = { args, defaultMessage, locale ->
        if(!args.value)
            return defaultMessage
        return NumberFormat.getInstance(locale).format(args.value)
    }
    closure2 = { 'The key #key has the value #value'.toLowerCase() }
    icon = icon('testImage.png')
    gradient = linearGradientPaint("10, 20, 100, 200, [0.0: WHITE, 0.5: #AAAAAA, 1.0: BLACK], REPEAT")
}
// messages_de.groovy
key.static = 'Dies ist ein Text'
// messages_customer_de.groovy
key.static = 'Dies ist ein anderer Text'

injections {
    location = 'http://www.google.de'
}'''
                )
            }
            rtextScrollPane(title: 'Benutzung .groovy') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''assert 'This is just a text' == rm.key.static
assert Locale.GERMAN == rm.key.object
assert rm.key.closure instanceof Closure
assert '1.000,123' = rm.getMessage('key.closure', [value: 1000.123], Locale.GERMAN)
assert 'the key X has the value 100' == rm.getMessage('key.closure2', [key: 'X', value: 100])
assert rm.key.icon instanceof Icon
assert rm.key.gradient.colors == [Color.WHITE, new Color(0xFFAAAAAA), Color.BLACK] as Object[]

assert 'Dies ist ein Text' == rm['de'].key.static
rm.customSuffixes = ['customer']
assert 'Dies ist ein anderer Text' == rm['de'].key.static

def obj = new MyObject()
rm.inject(obj)
assert 'http://www.google.de' == ob.location'''
                )
            }
        }
    }
}