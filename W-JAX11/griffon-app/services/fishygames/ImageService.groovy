package fishygames

import java.awt.geom.AffineTransform
import java.awt.image.BufferedImage
import java.awt.image.BufferedImageOp
import java.util.List
import javax.imageio.ImageIO
import javax.swing.Icon
import javax.swing.ImageIcon
import com.jhlabs.image.*
import java.awt.*
import griffon.builder.gfx.ops.AutoCropOp
import griffon.builder.gfx.ops.ClipMaskOp

class ImageService {
    BufferedImage buffer(Image image) {
        if (image instanceof BufferedImage)
            return image

        BufferedImage target = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB)
        target.graphics.drawImage(image, 0, 0, null)
        return target
    }

    BufferedImage buffer(Icon icon) {
        if (icon instanceof ImageIcon)
            return buffer(icon.image)

        BufferedImage target = new BufferedImage(icon.iconWidth, icon.iconHeight, BufferedImage.TYPE_INT_ARGB)
        icon.paintIcon(null, target.graphics, 0, 0)
        return target
    }

    BufferedImage crop(BufferedImage image) {
        new AutoCropOp().filter(image, null)
    }

    BufferedImage highlight(String resource, Color color, int radius, int xOffset = radius, int yOffset = radius) {
        crop(highlight(enlarge(ImageIO.read(ImageService.classLoader.getResource(resource)), xOffset * 2, yOffset * 2), color, radius))
    }

    BufferedImage highlight(BufferedImage image, Color color, int radius) {
        layer([
                new Layer(image: image, effect: alphaSelectionFillAndBlurFilter(image, color, radius)),
                new Layer(image: image)
        ], image.width, image.height)
    }

    BufferedImage doubleHighlight(String resource, Color color1, Color color2, int radius1, int radius2, int xOffset = Math.max(radius1, radius2), int yOffset = Math.max(radius1, radius2)) {
        crop(doubleHighlight(enlarge(ImageIO.read(ImageService.classLoader.getResource(resource)), xOffset * 2, yOffset * 2), color1, color2, radius1, radius2))
    }

    BufferedImage doubleHighlight(BufferedImage image, Color color1, Color color2, int radius1, int radius2) {
        layer([
                new Layer(image: image, effect: alphaSelectionFillAndBlurFilter(image, color1, radius1)),
                new Layer(image: image, effect: alphaSelectionFillAndBlurFilter(image, color2, radius2)),
                new Layer(image: image)
        ], image.width, image.height)
    }

    BufferedImage grayscale(BufferedImage image) {
        new GrayscaleFilter().filter(image, null)
    }

    BufferedImage glow(BufferedImage image, float amount) {
        def filter = new GlowFilter()
        filter.amount = amount
        return filter.filter(image, null)
    }

    BufferedImage dropShadow(BufferedImage image, Color color) {
        def filter = new ShadowFilter(10, 10, -10, 0.5)
        filter.shadowColor = color.getRGB()
        return filter.filter(image, null)
    }

    private CompoundFilter alphaSelectionFillAndBlurFilter(BufferedImage image, Color color, int radius) {
        ClipMaskOp clipMask = new ClipMaskOp(image, true,)
        FillFilter fill = new FillFilter(color.getRGB())
        GaussianFilter blur = new GaussianFilter(radius)
        CompoundFilter compound = new CompoundFilter(fill, new CompoundFilter(clipMask, blur))
        return compound
    }

    BufferedImage enlarge(BufferedImage image, int diffX, int diffY, boolean center = true) {
        BufferedImage target = new BufferedImage(image.width + diffX, image.height + diffY, image.getType())
        Graphics2D g = target.createGraphics()
        g.drawImage(image, center ? (int) (diffX / 2) : 0, center ? (int) (diffY / 2) : 0, null)
        g.dispose()
        return target
    }

    BufferedImage scale(BufferedImage image, double fX, double fY = fX) {
        BufferedImage target = new BufferedImage((int) (image.width * fX), (int) (image.height * fY), image.getType())
        Graphics2D g = target.createGraphics()
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC)
        g.drawImage(image, 0, 0, target.width, target.height, null)
        g.dispose()
        return target
    }

    BufferedImage layer(List<Layer> layers, int width, int height, int imageType = BufferedImage.TYPE_INT_ARGB) {
        layer(layers, new BufferedImage(width, height, imageType))
    }

    BufferedImage layer(List<Layer> layers, BufferedImage target) {
        if (target == null)
            throw new IllegalArgumentException('Target-Image not defined')

        Graphics2D g = target.createGraphics()
        Composite defaultComposite = g.composite

        for (Layer layer: layers) {
            layer.target = target
            layer.with {
                if (composite)
                    g.composite = composite
                else
                    g.composite = defaultComposite

                AffineTransform oldTransform = g.transform
                if (transform)
                    g.transform(transform)

                if (effect)
                    g.drawImage(image, effect, xOffset, yOffset)
                else
                    g.drawImage(image, xOffset, yOffset, null)

                if (!persistTransform)
                    g.transform = oldTransform
            }
        }
        g.dispose()
        return target
    }
}

class Layer {
    BufferedImage image
    BufferedImageOp effect = null
    AffineTransform transform = null
    boolean persistTransform = false
    Composite composite = null
    int xOffset = 0
    int yOffset = 0
    BufferedImage target
}