import com.bric.image.transition.vanilla.BlendTransition2D
import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Im Painter benötigen wir beides getrennt',
        clientPropertySubIndex: 4,
        master: 'Image',
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'wrap 1', columnConstraints: '100[center, grow, fill]100', rowConstraints: '30[grow, fill]')
    rtextScrollPane(constraints: 'center') {
        rsyntaxTextArea(editable: false,
                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''GfxNode createBackgroundNode(JComponent c, int width, int height, int thickness) {
    def b = [ x: thickness, y: thickness, w: width - 2 * thickness, h: height - 2 * thickness]
    return group(bw: 0) {
        antialias true
        rect(x: b.x, y: b.y, w: b.w, h: b.h, fill: color('white'), bw: 0)
        rect(x: b.x, y: b.y, w: b.w, h: b.h, fill: new HSVGradientPaint(b.x, b.y,
             color(0x33ff0000), b.w, b.h, color(0x33ff0000), false), bw: 0)
    }
}

GfxNode createBorderNode(JComponent c, int width, int height, int thickness) {
    def offset = thickness / 2
    return group(bw: 0) {
        antialias true
        rect(x: offset, y: offset, w: width - thickness - 0.5, h: height - thickness - 0.5,
             bc: new HSVGradientPaint(0, 0, color('red'), thickness * 15,
             thickness * 15, color('red'), true, true), bw: thickness )
    }
}''')
    }
}

