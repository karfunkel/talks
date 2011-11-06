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


def (m, v, c) = createMVCGroup('fishyGames', 'fishyGames4', [useUI: true])

slide(
        title: 'Buttons können mehrere Status haben',
        clientPropertySubIndex: 4,
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
    label('UI-Eigenschaft für alle JToggleButtons', cssClass: 'H4')
    rtextScrollPane(constraints: 'center') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''class FishyImageButtonUI extends BasicButtonUI {
    public static final int ENABLED = 0
    public static final int FOCUSED = 1
    public static final int MOUSE_OVER = 2
    public static final int PRESSED = 3
    public static final int SELECTED = 4

    private static ButtonUI componentUI = new FishyImageButtonUI()
    private ImageService imageService = new ImageService()

    static ComponentUI createUI(JComponent c) { return componentUI }

    protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
        Graphics2D g2 = g
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON)
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BICUBIC)

        AbstractButton b = (AbstractButton) c

        // Status des Buttons auslesen
        BitSet state = getState(b)

        // Bild des Buttons auslesen
        BufferedImage image = getImage(b)
        if (image) {
            // Image skalieren falls der Button kleiner ist als das Image
            int w = image.width
            int h = image.height
            if (b.width < w || b.height < h) {
                float ratio = Math.min(b.width / w, b.height / h)
                w *= ratio
                h *= ratio
            }

            // Fokus Zeichnen : 3 Pixel dickes Rechteck mit runden Ecken in Weiß, alpha zu 25 %
            if (state[FOCUSED]) {
                RoundRectangle2D r = new RoundRectangle2D.Float(1, 1, c.width-3, c.height-3, 10, 10)
                Stroke oldStroke = g2.stroke
                Paint oldPaint = g2.paint
                g2.setStroke(new BasicStroke(3f))
                g2.paint = new Color(0x40ffffff, true)
                g2.draw(r)
                g2.stroke = oldStroke
                g2.paint = oldPaint
            }
            // Image zentriert in den Button zeichnen
            g.drawImage(image, (int) (c.width / 2 - w / 2), (int) (c.height / 2 - h / 2), w, h, c)
        }
    }

    private BufferedImage getImage(AbstractButton b) {
        // Status des Buttons auslesen
        BitSet state = getState(b)
        // Image aus cache lesen
        BufferedImage image = b.getClientProperty("__IMAGE_$state")
        if (image)
            return image

        // Image vom gesetzten Icon erstellen, alternative Icons werden ignoriert
        if (!b.icon)
            return null

        // Icon in BufferedImage zeichnen und um 20 Pixel in beide Richtungen vergrößern
        BufferedImage source = imageService.enlarge(imageService.buffer(b.icon), 20, 20)

        // Status abhängiges Icon erstellen
        if (state[ENABLED]) {
            image = source
            if (state[PRESSED])
                image = imageService.doubleHighlight(image, Color.BLUE, Color.WHITE, 20, 10)
            else if (state[SELECTED])
                image = imageService.doubleHighlight(image, Color.ORANGE,
                                                            Color.ORANGE.brighter(), 20, 10)
            else
                image = imageService.highlight(source, Color.WHITE, 20)

            if (state[MOUSE_OVER])
                image = imageService.glow(image, 0.1f)
        } else {
            // Disabled Image ist das Orginal-Image in Graustufen
            if (state[SELECTED])
                image = imageService.doubleHighlight(imageService.grayscale(source),
                            Color.ORANGE, Color.ORANGE.brighter(), 20, 10)
            else
                image = imageService.highlight(imageService.grayscale(source), Color.WHITE, 20)
        }
        // Überschüssige transparente Bereiche entfernen (Auto Crop)
        image = imageService.crop(image)
        // Image cachen
        b.putClientProperty("__IMAGE_$state", image)
        return image
    }

    private BitSet getState(AbstractButton b) {
        ButtonModel model = b.model
        BitSet state = new BitSet()
        state.set(ENABLED, b.enabled)
        // Nur FOCUSED wenn Fokus gezeichnet werden soll und der Button nicht gedrückt wird
        state.set(FOCUSED, b.focusPainted && b.hasFocus() && !model.pressed)
        state.set(MOUSE_OVER, model.rollover)
        // Nur PRESSED wenn Button gedrückt und Maus über dem Button
        state.set(PRESSED, model.armed && model.pressed)
        state.set(SELECTED, model.selected)
        return state
    }

    Dimension getPreferredSize(JComponent c) {
        // Bevorzugte Größe ist die Image-Größe
        BufferedImage image = getImage((AbstractButton) c)
        image ? new Dimension(image.width, image.height) : new Dimension(20, 20)
    }

    Dimension getMinimumSize(JComponent c) {
        return new Dimension() // Button kann beliebig klein werden
    }

    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
        // Text wird ignoriert
    }

    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect,
            Rectangle textRect, Rectangle iconRect) {
        // wird in paintIcon gezeichnet
    }

    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        // wird in paintIcon gezeichnet
    }
}''')
    }
}

