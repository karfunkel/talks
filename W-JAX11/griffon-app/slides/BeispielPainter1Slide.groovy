import com.bric.image.transition.vanilla.BlendTransition2D
import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'GfxBuilder macht Java2D einfacher',
        clientPropertySubIndex: 4,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D(),
        slideActions: [
                { revert ->
                    edt {
                        if (revert) {
                            painter1_p1.visible = false
                        } else {
                            painter1_p1.visible = true
                        }
                    }
                }
        ]
) {
    migLayout(layoutConstraints: 'wrap 1', columnConstraints: '100[center, grow, fill]100', rowConstraints: '10[grow, fill][grow, fill]')
    panel() {
        migLayout(layoutConstraints: 'flowy', columnConstraints: '[center, grow, fill]')
        label('griffon install-plugin gfx-builder', cssClass: 'H4')
        label('Auch ausserhalb von Griffon zu benutzen', cssClass: 'H4')
        label('http://griffon.codehaus.org/GfxBuilder', cssClass: 'H5o')
    }
    panel(id: 'painter1_p1', visible: false) {
        migLayout(layoutConstraints: 'flowy', columnConstraints: '[center, grow, fill]')
        label('Zeichnen im GfxCanvas-Element (JComponent)', cssClass: 'H4', constraints: 'bottom, grow')
        rtextScrollPane(constraints: 'center') {
            rsyntaxTextArea(editable: false,
                    syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor', text: '''// thickness = border-width
def b = [ x: thickness, y: thickness, w: width - 2 * thickness, h: height - 2 * thickness]
canvas(size: [w, h]) {
    group(bw: 0) {
        antialias true
        //Hintergrund
        rect(x: b.x, y: b.y, w: b.w, h: b.h, fill: color('white'), bw: 0)
        rect(x: b.x, y: b.y, w: b.w, h: b.h, fill: new HSVGradientPaint(b.x, b.y,
             color(0x33ff0000), b.w, b.h, color(0x33ff0000), false), bw: 0)
        //Rahmen
        def offset = thickness / 2
        rect(x: offset, y: offset, w: width - thickness - 0.5, h: height - thickness - 0.5,
             bc: new HSVGradientPaint(0, 0, color('red'), thickness * 15,
             thickness * 15, color('red'), true, true), bw: thickness )
    }
}''')
        }
    }
}

