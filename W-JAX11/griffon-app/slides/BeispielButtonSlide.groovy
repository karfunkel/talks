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
        title: 'UI-Delegates können auch lokal verwendet werden',
        clientPropertySubIndex: 4,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill, wrap 1', columnConstraints: '100[center, grow, fill]100', rowConstraints: '10[top]')
    label('UI-Eigenschaft für alle JToggleButtons', cssClass: 'H4')
    rtextScrollPane(constraints: 'center, grow') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''application(id: 'window', title: 'FishyGames', ...) {
// ...
    def imageButtonUI = new FishyImageButtonUI()
    panel(id: 'buttonPanel', constraints: 'grow') {
        migLayout(layoutConstraints: 'wrap 1, gapy 0, fill', rowConstraints: '[fill, grow]',
            columnConstraints: '[fill, grow]')
        toggleButton(icon: imageIcon('/Play.png'), toolTipText: 'Highscore',
            selected: true, ui: imageButtonUI)
        toggleButton(icon: imageIcon('/Chat.png'), toolTipText: 'Chat', ui: imageButtonUI)
        toggleButton(icon: imageIcon('/Mail.png'), toolTipText: 'Nachrichten', ui: imageButtonUI)
        toggleButton(icon: imageIcon('/Profile.png'), toolTipText: 'Profil',
            enabled: false, ui: imageButtonUI)
        toggleButton(icon: imageIcon('/Feedback.png'),toolTipText: 'Feedback',
            enabled: false, selected: true, ui: imageButtonUI)
        toggleButton(icon: imageIcon('/Home.png'), toolTipText: 'Mein Bereich', ui: imageButtonUI)
    }
// ...
}''')
    }
}

