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

slide(
        title: 'Ausgangspunkt Nimbus Look and Feel',
        master: 'Image',
        clientPropertySubIndex: 4,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill', columnConstraints: '100[center, grow, fill]100', rowConstraints: '10[center]10')
    rtextScrollPane(constraints: 'center') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''// Pure Java
import javax.swing.UIManager;

try {
    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
} catch (Exception e) {
 // ignore or log
}

// griffon-app/lifecycle/Initialize.groovy
SwingBuilder.lookAndFeel('nimbus')
''')
    }
}

