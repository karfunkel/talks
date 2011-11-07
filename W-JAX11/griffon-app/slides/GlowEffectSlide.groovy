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
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Highlight- oder Glow-Effekt',
        master: 'Image',
        clientPropertySubIndex: 4,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill, wrap 1',
              columnConstraints: '100[center, fill]100',
              rowConstraints: '[top][top][fill, grow]')
    widget(new ImagePanel(), imagePath: 'Logo_Layer.png')
    widget(new ImagePanel(), imagePath: 'Logo_Layer2.png')
    label('', constraints: 'grow')
}

