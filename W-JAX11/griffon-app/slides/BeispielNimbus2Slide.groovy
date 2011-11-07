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
import java.awt.Font
import java.awt.Color

slide(
        title: 'Nimbus Default-Keys sind hierarchisch, ähnlich CSS',
        clientPropertySubIndex: 4,
        backgroundPainter: backgroundPainter,
        slideActions: [
                    { revert ->
                    edt {
                        if (revert) {
                            bspNimbus2Complex.visible = false
                        } else {
                            bspNimbus2Complex.visible = true
                        }
                    }
                }
        ]
) {
    migLayout(layoutConstraints: 'wrap 1', columnConstraints: '100[center, grow, fill]100', rowConstraints: '30[top]10')
    rtextScrollPane(constraints: 'top') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''foreground = Color.BLACK
Label.foreground = Color.BLUE
Label[Disabled].foreground = Color.GRAY
"LabelName"[Disabled].foreground = Color.WHITE
ComboBox:"ComboBox.listRenderer".background''')
    }
    label('Mehr Details zu finden unter:', cssClass: 'H4')
    label('http://www.jasperpotts.com/blog/2008/08/nimbus-uimanager-uidefaults', cssClass: 'H5o')
    label('', cssClass: 'H4')
    panel(id: 'bspNimbus2Complex', visible: false, constraints: 'grow') {
        migLayout(layoutConstraints: 'wrap 1', columnConstraints: '[center, grow, fill]', rowConstraints: '20[center][center]')
        label('Nimbus-Anpassungen können auch lokal verwendet werden:', cssClass: 'H4')
        rtextScrollPane(constraints: 'center') {
            rsyntaxTextArea(editable: false,
                    syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''JProgressBar bar = new JProgressBar();
UIDefaults overrides = new UIDefaults();
overrides.put("ProgressBar.cycleTime", 330);
...
bar.putClientProperty("Nimbus.Overrides", overrides);
bar.putClientProperty("Nimbus.Overrides.InheritDefaults", false);''')
        }
    }
}

