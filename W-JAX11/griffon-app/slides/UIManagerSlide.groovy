import com.bric.image.transition.vanilla.BlendTransition2D
import org.fife.ui.rsyntaxtextarea.SyntaxConstants

slide(
        title: 'UIManager = Mittler zwischen Komponente und L&F',
        clientPropertySubIndex: 3,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '100[center]100',
            rowConstraints: '10[center, fill]10')
    panel(opaque: false) {
        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '[left, fill]', rowConstraints: '[center, fill]')
        label("UIManager-Interface", cssClass: 'L1')
        rtextScrollPane(constraints: 'center, grow') {
            rsyntaxTextArea(editable: false,
                    syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''// get/set current L&F
public static LookAndFeel getLookAndFeel()
public static void setLookAndFeel(LookAndFeel newLookAndFeel)
public static void setLookAndFeel(String className)

// get UI for a Component
public static ComponentUI getUI(JComponent c)

// changing L&F after instantiation
try {
   UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
   SwingUtilities.updateComponentTreeUI(myframe);
   myframe.validate();
} catch (UnsupportedLookAndFeelException e) { ... }

// get UIDefaults
public static UIDefaults getDefaults()
public static Object get(Object key)
public static Object get(Object key, Locale l)
''')
        }
        label("", constraints: 'grow')
    }
}
