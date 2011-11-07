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

def (m, v, c) = createMVCGroup('fishyGames', 'fishyGames1', [useUI: false])

slide(
        title: 'Beispiel ohne L&F',
        clientPropertySubIndex: 4,
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
    migLayout(layoutConstraints: 'fill', columnConstraints: '100[center, grow, fill]100', rowConstraints: '10[center]10')
    rtextScrollPane(constraints: 'center') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''application(id: 'window', title: 'FishyGames', ...) {
    migLayout(layoutConstraints: '', rowConstraints: '[162!]0[grow, fill]12',
                 columnConstraints: '12[200!]10[grow, fill]12')

    label(icon: imageIcon(constraints: 'top, align center',
        image: controller.imageService.highlight('Logo.png', color('white'), 20, 10, 10)))
    label('', constraints: 'grow, wrap')
    panel(id: 'buttonPanel', constraints: 'grow') {
        migLayout(layoutConstraints: 'wrap 1, gapy 0, fill', rowConstraints: '[fill, grow]',
            columnConstraints: '[fill, grow]')
        toggleButton(icon: imageIcon('/Play.png'), toolTipText: 'Highscore', selected: true)
        toggleButton(icon: imageIcon('/Chat.png'), toolTipText: 'Chat')
        toggleButton(icon: imageIcon('/Mail.png'), toolTipText: 'Nachrichten')
        toggleButton(icon: imageIcon('/Profile.png'), toolTipText: 'Profil', enabled: false)
        toggleButton(icon: imageIcon('/Feedback.png'),toolTipText: 'Feedback',
            enabled: false,selected: true)
        toggleButton(icon: imageIcon('/Home.png'), toolTipText: 'Mein Bereich')
    }
    panel(constraints: 'grow') {
        migLayout(rowConstraints: '[][fill, grow]', columnConstraints: '[grow][200]')
        def x = label('Suche:', constraints: 'right')
        textField(constraints: 'left, grow, wrap')
        scrollPane(constraints: 'spanx 2, grow') {
            list(id: 'mylist')
            mylist.listData = controller.createList(20)
        }
    }
}''')
    }
}

