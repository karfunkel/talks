import com.bric.image.transition.vanilla.BlendTransition2D
import org.fife.ui.rsyntaxtextarea.SyntaxConstants

slide(
        title: 'Manche L&F sind anpassbar',
        clientPropertySubIndex: 3,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '100[center]100',
            rowConstraints: '10[center, fill]10')
    panel(opaque: false) {
        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '[left]', rowConstraints: '[center, fill]')
        label("Nimbus Look and Feel", cssClass: 'L1')
        label("Synth Look and Feel", cssClass: 'L1')
        label("Skin Look and Feel", cssClass: 'L1')
        label("Substance Look and Fee", cssClass: 'L1')
        label("A03 Look and Fee", cssClass: 'L1')
        label("", cssClass: 'L1')
        label("http://www.javootoo.com", cssClass: 'L2')
        label("", constraints: 'grow')
    }
}
