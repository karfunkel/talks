import com.bric.image.transition.vanilla.BlendTransition2D
import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Unsere Painter bekommen je eine Methode',
        clientPropertySubIndex: 4,
        master: 'Image',
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'wrap 1', columnConstraints: '100[center, grow, fill]100', rowConstraints: '30[grow, fill]')
    rtextScrollPane(constraints: 'center') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''// package, imports ...
class FishyPainters {
    void paint(GfxNode node, Graphics2D g, JComponent c, BufferedImageOp op = null,
               AffineTransform transform = null, Composite composite = null) { ... }
    GfxNode createBackgroundNode(JComponent c, int width, int height, int thickness) { ... }
    GfxNode createBorderNode(JComponent c, int width, int height, int thickness) { ... }

    void paintTextFieldBackground(Graphics2D g, JComponent c, int width, int height) {
        paint(createBackgroundNode(c, width, height, 2), g, c)
    }

    void paintTextFieldBorder(Graphics2D g, JComponent c, int width, int height, boolean focused) {
        if (focused)
            paint(createBorderNode(c, width, height, 2), g, c, new HSBAdjustFilter(sFactor: -0.5f))
        else
            paint(createBorderNode(c, width, height, 2), g, c)
    }

    void paintTextFieldDisabledBackground(Graphics2D g, JComponent c, int width, int height) {
        paint(createBorderNode(c, width, height, 2), g, c, new GrayscaleFilter())
    }

    void paintTextFieldDisabledBorder(Graphics2D g, JComponent c, int width, int height) {
        paint(createBorderNode(c, width, height, 2), g, c, new GrayscaleFilter())
    }
    // ...
}''')
    }
}

