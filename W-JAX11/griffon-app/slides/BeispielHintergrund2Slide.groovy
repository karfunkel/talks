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

UIManager.defaults.RootPaneUI = "fishygames.ui.FishyRootPaneUI"

def (m, v, c) = createMVCGroup('fishyGames', 'fishyGames2', [useUI: false])

slide(
        title: 'Die Einzelteile skalieren unterschiedlich',
        clientPropertySubIndex: 4,
        master: 'Image',
        backgroundPainter: backgroundPainter,
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
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''//package, imports ...
class FishyContentPaneUI extends PanelUI {
    private static PanelUI componentUI = new FishyContentPaneUI()

    static ComponentUI createUI(JComponent c) {
        return componentUI
    }

    void paint(Graphics g, JComponent c) {
        Graphics2D g2 = g
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BICUBIC)
        BufferedImage bg = ImageIO.read(ImageService.classLoader.getResource('Background.png'))
        BufferedImage header = ImageIO.read(ImageService.classLoader.getResource('Header.png'))
        BufferedImage bar = ImageIO.read(ImageService.classLoader.getResource('Bar.png'))
        // Background über den ganzen Bildschirm skalieren
        g2.drawImage(bg, 0, 0, c.width, c.height, c)
        // Bar ab y=81 horizontal skalieren
        g2.drawImage(bar, 0, 81, c.width, bar.height, c)
        // Header ab y=7 zentriert zeichnen, aber mindestens links 228px Platz lassen
        g2.drawImage(header, Math.max(228, (int) ((c.width - header.width) / 2)), 7, c)
    }
}''')
    }
}

