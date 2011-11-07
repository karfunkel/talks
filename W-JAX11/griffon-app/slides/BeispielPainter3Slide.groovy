import com.bric.image.transition.vanilla.BlendTransition2D
import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Zumdem müssen wir in ein Graphics-Object zeichnen',
        clientPropertySubIndex: 4,
        master: 'Image',
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'wrap 1', columnConstraints: '100[center, grow, fill]100', rowConstraints: '30[grow, fill]')
    rtextScrollPane(constraints: 'center') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''void paint(GfxNode node, Graphics2D g, JComponent c, BufferedImageOp op = null,
           AffineTransform transform = null, Composite composite = null) {
    if(op)
        node.filter = op
    def oldTransform = g.transform
    def oldComposite = g.composite
    if (composite)
        g.composite = composite
    if (transform)
        g.transform = transform
    GfxCanvas canvas = new GfxCanvas(node: node, opaque: false, size: c.size)
    canvas.paintComponent(g)
    if (transform)
        g.transform = oldTransform
    if (composite)
        g.composite = oldComposite
}''')
    }
}

