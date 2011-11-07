import com.bric.image.transition.vanilla.BlendTransition2D
import java.awt.Graphics
import java.awt.Insets
import java.awt.RenderingHints
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import javax.swing.JPanel
import javax.swing.JTabbedPane

def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor_NineFieldScale1')
m.editable = false
m.code = '''// imports ...
Insets s = new Insets(36, 33, 36, 35)
BufferedImage source = ImageIO.read(
    Thread.currentThread().contextClassLoader.getResource('SourceImage.png')
)
def imagePanel = new JPanel() {
    protected void paintComponent(Graphics g) {
        g.setRenderingHint(
            RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BICUBIC
        )
        // top-left
        g.drawImage(source,
                0, 0, s.left, s.top,
                0, 0, s.left, s.top,
                null)
        // top
        g.drawImage(source,
                s.left, 0, width - s.right, s.top,
                s.left, 0, source.width - s.right, s.top,
                null)
        // top-right
        g.drawImage(source,
                width - s.right, 0, width, s.top,
                source.width - s.right, 0, source.width, s.top,
                null)
        // left
        g.drawImage(source,
                0, s.top, s.left, height - s.bottom,
                0, s.top, s.left, source.height - s.bottom,
                null)
        // center
        g.drawImage(source,
                s.left, s.top, width - s.right, height - s.bottom,
                s.left, s.top, source.width - s.right, source.height - s.bottom,
                null)
        // right
        g.drawImage(source,
                width - s.right, s.top, width, height - s.bottom,
                source.width - s.right, s.top, source.width, source.height - s.bottom,
                null)
        // bottom-left
        g.drawImage(source,
                0, height - s.bottom, s.left, height,
                0, source.height - s.bottom, s.left, source.height,
                null)
        // bottom
        g.drawImage(source,
                s.left, height - s.bottom, width - s.right, height,
                s.left, source.height - s.bottom, source.width - s.right, source.height,
                null)
        // bottom-right
        g.drawImage(source,
                width - s.right, height - s.bottom, width, height,
                source.width - s.right, source.height - s.bottom, source.width, source.height,
                null)
    }
}
widget(imagePanel, preferredSize: [500, 100])
'''

slide(
        title: 'Skalierung über neun Felder in Java2D',
        master: 'Image',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter,
        slideActions : [
                { revert ->
                    if (revert) {
                        tab_NineFieldScale1.selectedIndex = 0
                    } else {
                        tab_NineFieldScale1.selectedIndex = 1
                    }
                }
        ]
) {
    migLayout(layoutConstraints: 'fill', columnConstraints: '100[center]100')
    tabbedPane(id:'tab_NineFieldScale1', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'grow') {
        widget(title: 'Source', v.groovyEditorContainer)
        panel(title: 'Result') {
            migLayout(columnConstraints: '[center, grow]', rowConstraints: '[center, grow]')
            Insets s = new Insets(36, 33, 36, 35)
            BufferedImage source = ImageIO.read(Thread.currentThread().contextClassLoader.getResource('SourceImage.png'))
            def imagePanel = new JPanel() {
                protected void paintComponent(Graphics g) {
                    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC)
                    // top-left
                    g.drawImage(source,
                            0, 0, s.left, s.top,
                            0, 0, s.left, s.top,
                            null)
                    // top
                    g.drawImage(source,
                            s.left, 0, width - s.right, s.top,
                            s.left, 0, source.width - s.right, s.top,
                            null)
                    // top-right
                    g.drawImage(source,
                            width - s.right, 0, width, s.top,
                            source.width - s.right, 0, source.width, s.top,
                            null)
                    // left
                    g.drawImage(source,
                            0, s.top, s.left, height - s.bottom,
                            0, s.top, s.left, source.height - s.bottom,
                            null)
                    // center
                    g.drawImage(source,
                            s.left, s.top, width - s.right, height - s.bottom,
                            s.left, s.top, source.width - s.right, source.height - s.bottom,
                            null)
                    // right
                    g.drawImage(source,
                            width - s.right, s.top, width, height - s.bottom,
                            source.width - s.right, s.top, source.width, source.height - s.bottom,
                            null)
                    // bottom-left
                    g.drawImage(source,
                            0, height - s.bottom, s.left, height,
                            0, source.height - s.bottom, s.left, source.height,
                            null)
                    // bottom
                    g.drawImage(source,
                            s.left, height - s.bottom, width - s.right, height,
                            s.left, source.height - s.bottom, source.width - s.right, source.height,
                            null)
                    // bottom-right
                    g.drawImage(source,
                            width - s.right, height - s.bottom, width, height,
                            source.width - s.right, source.height - s.bottom, source.width, source.height,
                            null)
                }
            }
            widget(imagePanel, preferredSize: [500, 100])
        }
    }
}

