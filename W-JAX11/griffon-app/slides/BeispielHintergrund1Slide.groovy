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
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Einzelteile lassen sich besser skalieren',
        master: 'Image',
        clientPropertySubIndex: 4,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '100[center, fill]100',
              rowConstraints: '10[top]10')
    widget(new ImagePanel(), imagePath: 'Background_Parts.png')
}


