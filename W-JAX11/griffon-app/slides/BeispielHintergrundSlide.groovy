import com.bric.image.transition.vanilla.BlendTransition2D
import java.awt.Graphics
import java.awt.Insets
import java.awt.RenderingHints
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import javax.swing.JPanel
import javax.swing.JTabbedPane
import java.awt.event.WindowListener
import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.UIManager


slide(
        title: 'Ein Hintergrundbild für unsere Fenster',
        clientPropertySubIndex: 4,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill, wrap 1', columnConstraints: '100[center, grow, fill]100', rowConstraints: '10[center]10')
    label('JRootPane ist die Basis eines Window', cssClass: 'H4')
    rtextScrollPane(constraints: 'center') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''//griffon-app/lifecycle/Initialize.groovy
UIManager.defaults.RootPaneUI = "fishygames.ui.FishyRootPaneUI"''')
    }

    label('Gezeichnet wird aber deren contentPane ', cssClass: 'H4')
    rtextScrollPane(constraints: 'center') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''//package, imports ...
class FishyRootPaneUI extends BasicRootPaneUI {
    private static RootPaneUI componentUI = new FishyRootPaneUI()
    private static PanelUI contentPaneUI = new FishyContentPaneUI()

    static ComponentUI createUI(JComponent c) {
        return componentUI
    }

    void installUI(JComponent c) {
        super.installUI(c)
        if (c instanceof JRootPane) {
            c.contentPane.setUI(contentPaneUI)
        }
    }
}''')
    }
}

