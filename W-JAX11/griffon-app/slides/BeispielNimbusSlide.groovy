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
import javax.swing.plaf.ColorUIResource
import javax.swing.plaf.FontUIResource
import javax.swing.JComponent
import fishygames.ui.UIHelper
import javax.swing.UIDefaults


def (m, v, c) = createMVCGroup('fishyGames', 'fishyGames5', [useUI: true])

UIDefaults overrides = new UIDefaults()
overrides."Label.textForeground" = ColorUIResource.WHITE
overrides."Label.font" = new FontUIResource('Dialog', Font.BOLD, 16)
UIHelper.overrideDelegates(overrides, v.window)

slide(id: 'bspNimbus',
        title: 'Nimbus Look and Feel kann angepasst werden',
        clientPropertySubIndex: 4,
        backgroundPainter: backgroundPainter,
        slideActions: [
                { revert ->
                    if (revert) {
                    } else {
                        v.window.show()
                    }
                    return false
                },
                { revert ->
                    edt {
                        if (revert) {
                            bspNimbusComplex.visible = false
                        } else {
                            bspNimbusComplex.visible = true
                        }
                    }
                }
        ]
) {
    migLayout(layoutConstraints: 'wrap 1', columnConstraints: '100[center, grow, fill]100', rowConstraints: '10[center]10')
    label('Einfache Optionen sind über Default-Keys zu setzen', cssClass: 'H4')
    rtextScrollPane(constraints: 'center') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''//griffon-app/lifecycle/Initialize.groovy
UIManager.lookAndFeelDefaults."Label.textForeground" = Color.WHITE
//UIManager.lookAndFeelDefaults."defaultFont" = new Font('Dialog', Font.BOLD, 16)
UIManager.lookAndFeelDefaults."Label.font" = new Font('Dialog', Font.BOLD, 16)''')
    }

    label('Alle Default-Keys von Nimbus sind hier zu finden:', cssClass: 'H4')
    label('http://jasperpotts.com/blogfiles/nimbusdefaults/nimbus.html', cssClass: 'H5o')

    panel(id: 'bspNimbusComplex', visible: false, constraints: 'grow') {
        migLayout(layoutConstraints: 'wrap 1', columnConstraints: '[center, grow, fill]', rowConstraints: '50[center][center]')
        label('Komplexeres kann über Painter realisiert werden', cssClass: 'H4')
        rtextScrollPane(constraints: 'center') {
            rsyntaxTextArea(editable: false,
                    syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''package com.sun.java.swing;

import java.awt.Graphics2D;

public interface Painter<T> {
    public void paint(Graphics2D g, T object, int width, int height);
}''')
        }
    }
}

