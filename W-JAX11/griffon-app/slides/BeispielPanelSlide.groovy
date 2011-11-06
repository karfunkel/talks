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

UIManager.defaults.PanelUI = "fishygames.ui.FishyPanelUI"

def (m, v, c) = createMVCGroup('fishyGames', 'fishyGames3', [useUI: false])

slide(
        title: 'Transparente Panels um den Hintergrund zu sehen',
        clientPropertySubIndex: 4,
        master: 'Image',
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D(),
        slideActions: [
                { revert ->
                    if (revert) {
                    } else {
                        v.window.show()
                    }
                    return false
                }
        ]
) {
    migLayout(layoutConstraints: 'fill, wrap 1', columnConstraints: '100[center, grow, fill]100', rowConstraints: '10[center]10')
    rtextScrollPane(constraints: 'center') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''//griffon-app/lifecycle/Initialize.groovy
UIManager.defaults.PanelUI = "fishygames.ui.FishyPanelUI"''')
    }

    rtextScrollPane(constraints: 'center') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''//package, imports ...
class FishyPanelUI extends BasicPanelUI {
    private static PanelUI componentUI = new FishyPanelUI()

    static ComponentUI createUI(JComponent c) {
        return componentUI
    }

    @Override
    void installDefaults(JPanel p) {
        super.installDefaults(p)
        LookAndFeel.installProperty(p, "opaque", false);
    }
}''')
    }
}

