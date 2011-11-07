import com.bric.image.transition.vanilla.BlendTransition2D
import org.fife.ui.rsyntaxtextarea.SyntaxConstants

slide(
        title: 'Das Look&Feel ist eine Sammlung von UI Delegates',
        clientPropertySubIndex: 3,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '100[center]100',
            rowConstraints: '10[center, fill]10')
    panel(opaque: false) {
        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '[left, fill]', rowConstraints: '[center, fill]')
        label("Verknüpfung Komponente <-> UI-Delegate", cssClass: 'L1')
        label("Entferne das 'J' einer Komponente und hänge 'UI' an", cssClass: 'L2')
        label("L&F liefert u.a. eine Table mit Attributen", cssClass: 'L2')
        label("Farben, Insets, Fonts", cssClass: 'L3')
        label("Zuordnung UI-Delegate Key zu konkreter Klasse", cssClass: 'L3')
        rtextScrollPane(constraints: 'center, grow') {
            rsyntaxTextArea(id: 'groovyEditor', editable: false,
                    syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''// get/set UI Delegate
public ScrollBarUI getUI()
public void setUI(ScrollBarUI ui)

// reset the Default-UI-Delegate
public void updateUI()

// get UI-Delegate-Key to lookup in UIDefaults-Table
public String getUIClassID() { return ScrollBarUI; }
''')
        }
        label("", constraints: 'grow')
    }
}
