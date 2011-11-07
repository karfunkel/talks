import com.bric.image.transition.vanilla.BlendTransition2D
import com.sun.java.swing.Painter
import fishygames.ui.FishyBorder
import fishygames.ui.FishyPainters
import fishygames.ui.UIHelper
import java.awt.Font
import javax.swing.UIDefaults
import javax.swing.plaf.ColorUIResource
import javax.swing.plaf.FontUIResource
import javax.swing.plaf.InsetsUIResource
import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import java.awt.Color
import javax.swing.UIManager

FishyPainters painters = new FishyPainters()

UIManager.lookAndFeelDefaults."Label.textForeground" = ColorUIResource.WHITE
UIManager.lookAndFeelDefaults."Label.font" = new FontUIResource('Dialog', Font.BOLD, 16)
UIManager.lookAndFeelDefaults."TextField[Enabled].borderPainter" = painters.&paintTextFieldBorder.rcurry(false) as Painter
UIManager.lookAndFeelDefaults."TextField[Enabled].backgroundPainter" = painters.&paintTextFieldBackground as Painter
UIManager.lookAndFeelDefaults."TextField[Focused].borderPainter" = painters.&paintTextFieldBorder.rcurry(true) as Painter
UIManager.lookAndFeelDefaults."TextField[Disabled].borderPainter" = painters.&paintTextFieldDisabledBackground as Painter
UIManager.lookAndFeelDefaults."TextField[Disabled].backgroundPainter" = painters.&paintTextFieldDisabledBorder as Painter
UIManager.lookAndFeelDefaults."TextField[Selected].backgroundPainter" = painters.&paintTextFieldBackground as Painter
UIManager.lookAndFeelDefaults."TextField[Selected].borderPainter" = painters.&paintTextFieldBorder.rcurry(false) as Painter
UIManager.lookAndFeelDefaults."TextField[Selected+Focused].borderPainter" = painters.&paintTextFieldBorder.rcurry(true) as Painter

UIManager.lookAndFeelDefaults."ToolTip[Enabled].borderPainter" = painters.&paintToolTipBorder as Painter
UIManager.lookAndFeelDefaults."ToolTip[Enabled].backgroundPainter" = painters.&paintToolTipBackground as Painter
UIManager.lookAndFeelDefaults."ToolTip[Disabled].borderPainter" = painters.&paintToolTipDisabledBorder as Painter
UIManager.lookAndFeelDefaults."ToolTip[Disabled].backgroundPainter" = painters.&paintToolTipDisabledBackground as Painter
UIManager.lookAndFeelDefaults."ToolTip.contentMargins" = new InsetsUIResource(2, 4, 2, 4)
UIManager.lookAndFeelDefaults."ToolTip.font" = new FontUIResource('Dialog', Font.BOLD, 10)

UIManager.lookAndFeelDefaults."List[Enabled].backgroundPainter" = painters.&paintListBackground as Painter
UIManager.lookAndFeelDefaults."List[Disabled].backgroundPainter" = painters.&paintListDisabledBackground as Painter
UIManager.lookAndFeelDefaults."List[Disabled+Selected].textBackground" = new ColorUIResource(new Color(0x33888888, true))
UIManager.lookAndFeelDefaults."List[Disabled].textForeground" = ColorUIResource.BLACK
UIManager.lookAndFeelDefaults."List[Selected].textBackground" = new ColorUIResource(new Color(0x33000000, true))
UIManager.lookAndFeelDefaults."List[Selected].textForeground" = ColorUIResource.BLACK
UIManager.lookAndFeelDefaults."List.dropLineColor" = new ColorUIResource(new Color(0x33000000, true))
UIManager.lookAndFeelDefaults."List.focusCellHighlightBorder" = new FishyBorder(1)
UIManager.lookAndFeelDefaults."ScrollPane[Enabled].borderPainter" = painters.&paintScrollPaneBorder as Painter
UIManager.lookAndFeelDefaults."ScrollPane[Disabled].borderPainter" = painters.&paintScrollPaneDisabledBorder as Painter

def (m, v, c) = createMVCGroup('fishyGames', 'fishyGames6', [useUI: true])

UIDefaults overrides = new UIDefaults()
overrides."Label.textForeground" = ColorUIResource.WHITE
overrides."Label.font" = new FontUIResource('Dialog', Font.BOLD, 16)
overrides."TextField[Enabled].borderPainter" = painters.&paintTextFieldBorder.rcurry(false) as Painter
overrides."TextField[Enabled].backgroundPainter" = painters.&paintTextFieldBackground as Painter
overrides."TextField[Focused].borderPainter" = painters.&paintTextFieldBorder.rcurry(true) as Painter
overrides."TextField[Disabled].borderPainter" = painters.&paintTextFieldDisabledBackground as Painter
overrides."TextField[Disabled].backgroundPainter" = painters.&paintTextFieldDisabledBorder as Painter
overrides."TextField[Selected].backgroundPainter" = painters.&paintTextFieldBackground as Painter
overrides."TextField[Selected].borderPainter" = painters.&paintTextFieldBorder.rcurry(false) as Painter
overrides."TextField[Selected+Focused].borderPainter" = painters.&paintTextFieldBorder.rcurry(true) as Painter

overrides."ToolTip[Enabled].borderPainter" = painters.&paintToolTipBorder as Painter
overrides."ToolTip[Enabled].backgroundPainter" = painters.&paintToolTipBackground as Painter
overrides."ToolTip[Disabled].borderPainter" = painters.&paintToolTipDisabledBorder as Painter
overrides."ToolTip[Disabled].backgroundPainter" = painters.&paintToolTipDisabledBackground as Painter
overrides."ToolTip.contentMargins" = new InsetsUIResource(2, 4, 2, 4)
overrides."ToolTip.font" = new FontUIResource('Dialog', Font.BOLD, 10)

overrides."List[Enabled].backgroundPainter" = painters.&paintListBackground as Painter
overrides."List[Disabled].backgroundPainter" = painters.&paintListDisabledBackground as Painter
overrides."List[Disabled+Selected].textBackground" = new ColorUIResource(new Color(0x33888888, true))
overrides."List[Disabled].textForeground" = ColorUIResource.BLACK
overrides."List[Selected].textBackground" = new ColorUIResource(new Color(0x33000000, true))
overrides."List[Selected].textForeground" = ColorUIResource.BLACK
overrides."List.dropLineColor" = new ColorUIResource(new Color(0x33000000, true))
overrides."List.focusCellHighlightBorder" = new FishyBorder(1)
overrides."ScrollPane[Enabled].borderPainter" = painters.&paintScrollPaneBorder as Painter
overrides."ScrollPane[Disabled].borderPainter" = painters.&paintScrollPaneDisabledBorder as Painter

UIHelper.overrideDelegates(overrides, v.window)


slide(
        title: 'Zuletzt müssen die Painter registriert werden',
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
    migLayout(layoutConstraints: 'wrap 1', columnConstraints: '100[center, grow, fill]100', rowConstraints: '30[grow, fill]')
    rtextScrollPane(constraints: 'center') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''FishyPainters painters = new FishyPainters()
def lafd = UIManager.lookAndFeelDefaults
lafd."TextField[Enabled].borderPainter" = painters.&paintTextFieldBorder.rcurry(false) as Painter
lafd."TextField[Enabled].backgroundPainter" = painters.&paintTextFieldBackground as Painter
lafd."TextField[Focused].borderPainter" = painters.&paintTextFieldBorder.rcurry(true) as Painter
lafd."TextField[Disabled].borderPainter" = painters.&paintTextFieldDisabledBackground as Painter
lafd."TextField[Disabled].backgroundPainter" = painters.&paintTextFieldDisabledBorder as Painter
lafd."TextField[Selected].backgroundPainter" = painters.&paintTextFieldBackground as Painter
lafd."TextField[Selected].borderPainter" = painters.&paintTextFieldBorder.rcurry(false) as Painter
lafd."TextField[Selected+Focused].borderPainter" = painters.&paintTextFieldBorder.rcurry(true) as Painter

lafd."ToolTip[Enabled].borderPainter" = painters.&paintToolTipBorder as Painter
lafd."ToolTip[Enabled].backgroundPainter" = painters.&paintToolTipBackground as Painter
lafd."ToolTip[Disabled].borderPainter" = painters.&paintToolTipDisabledBorder as Painter
lafd."ToolTip[Disabled].backgroundPainter" = painters.&paintToolTipDisabledBackground as Painter
lafd."ToolTip.contentMargins" = new Insets(2, 4, 2, 4)
lafd."ToolTip.font" = new Font('Dialog', Font.BOLD, 10)

lafd."List[Enabled].backgroundPainter" = painters.&paintListBackground as Painter
lafd."List[Disabled].backgroundPainter" = painters.&paintListDisabledBackground as Painter
lafd."List[Disabled+Selected].textBackground" = new Color(0x33888888, true)
lafd."List[Disabled].textForeground" = Color.BLACK
lafd."List[Selected].textBackground" = new Color(0x33000000, true)
lafd."List[Selected].textForeground" = Color.BLACK
lafd."List.dropLineColor" = new Color(0x33000000, true)
lafd."List.focusCellHighlightBorder" = new FishyBorder(1)

lafd."ScrollPane[Enabled].borderPainter" = painters.&paintScrollPaneBorder as Painter
lafd."ScrollPane[Disabled].borderPainter" = painters.&paintScrollPaneDisabledBorder as Painter
''')
    }
}

