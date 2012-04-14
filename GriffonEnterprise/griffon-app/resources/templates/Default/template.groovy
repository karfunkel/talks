import java.awt.Color
import javax.swing.SwingConstants

master_Default = [
        // Set an instance of java.awt.Paint to paint the lowest background level
        // Paint may be a Paint or a Closure with one parameter (the Slide to paint to) returning a Paint
        paint: Color.WHITE,
        // Add an image (below) or a GfxBuilder node to paint ontop of the given Paint
        // Node may be a GfxBuilder node or a Closure with one parameter (the Slide to paint to) returning a GfxNode
        node: null,
        // The image can be set as String (resource loaded from the classpath), URL, File, InputStream or Image
        // Image may aswell be a Closure with one parameter (the Slide to paint to) returning an Image
        image: "$templateBase/background.jpg",
        // java.awt.Composite used to draw the image
        // Composite may aswell be a Closure with one parameter (the Slide to paint to) returning a Composite
        composite: null,
        // java.awt.image.BufferedImageOp used to draw the image
        // Op may aswell be a Closure with one parameter (the Slide to paint to) returning a BufferedImageOp
        op: null,
        // java.awt.geom.AffineTransform used to draw the image
        // Transform may aswell be a Closure with one parameter (the Slide to paint to) returning a AffineTransform
        transform: null,
        // Component representing the header
        // Header may aswell be a Closure with two parameters (Slide slide, int page)
        // returning a Component
        header: { slide, page ->
            def header
            noparent {
                header = panel(cssClass: 'headerPanel') {
                    stackLayout()
                    //label(icon: imageIcon("$templateBase/BeOne.png"), verticalAlignment: SwingConstants.BOTTOM, constraints: BOTTOM)
                    panel(constraints: TOP, opaque: false) {
                        def subTitles = app.config.presentation.subTitles ?: []
                        def subTitlesPerRow = app.config.presentation.subTitlesPerRow ?: 1
                        def index = slide.getClientProperty('sub')
                        if (index instanceof String)
                            index = subTitles.indexOf(index)
                        def rows = (int) (subTitles.size / subTitlesPerRow + 0.9)
                        if (index != null)
                            migLayout(layoutConstraints: 'fill', columnConstraints: "20[left, grow][center][right, grow]20".toString(), rowConstraints: "20${(0..<rows).collect {'[center]'}.join('')}25[center]0[center]20".toString())
                        else
                            migLayout(layoutConstraints: 'fill', columnConstraints: "20[left, grow][center][right, grow]20".toString(), rowConstraints: "20[center]0[center]20".toString())
                        if (index != null) {
                            rows.times { row ->
                                label('', constraints: 'grow')
                                def split = subTitlesPerRow
                                if (row == rows - 1)
                                    split = (subTitles.size % subTitlesPerRow) ?: subTitlesPerRow
                                split.times { col ->
                                    def idx = row * subTitlesPerRow + col
                                    label(text: subTitles[idx], cssClass: "subtitle${index == idx ? '_active' : ''}".toString(), constraints: "${col == 0 ? 'split ' + split + ',' : ''}sizegroup subs".toString())
                                }
                                label('', constraints: 'grow, wrap')
                            }
                        }
                        label(text: slide.title, cssClass: 'header', constraints: "spanx 3, grow")
                        canvas(constraints: "spanx 3, grow, newline, x 0, height 16, width ${app.config.presentation.screenWidth}".toString(), opaque: false) {
                            line(x1: 30, y1: 3, x2: ((app.config.presentation.screenWidth as int) - 30), y2: 3, bw: 2, bc: color('white'))
                        }
                    }
                }
            }
            header
        },
        // Component representing the footer
        // Footer may aswell be a Closure with two parameters (Slide slide, int page)
        // returning a Component
        footer: { slide, page ->
            def footer
            noparent {
                footer = panel(cssClass: 'footerPanel') {
                    stackLayout()
                    label(icon: imageIcon("$templateBase/header_de.png"), constraints: BOTTOM)
                    panel(constraints: TOP, opaque: false) {
                        migLayout(layoutConstraints: 'fill', columnConstraints: '280[center, grow]280', rowConstraints: '[center]')
                        label(text: "$page / ${app.config.presentation.order.size()}".toString(), cssClass: 'footer')
                    }
                }
            }
            footer
        }
]

master_Intro = [
        // Set an instance of java.awt.Paint to paint the lowest background level
        // Paint may be a Paint or a Closure with one parameter (the Slide to paint to) returning a Paint
        paint: Color.WHITE,
        // Add an image (below) or a GfxBuilder node to paint ontop of the given Paint
        // Node may be a GfxBuilder node or a Closure with one parameter (the Slide to paint to) returning a GfxNode
        node: null,
        // The image can be set as String (resource loaded from the classpath), URL, File, InputStream or Image
        // Image may aswell be a Closure with one parameter (the Slide to paint to) returning an Image
        image: "$templateBase/background.jpg",
        // java.awt.Composite used to draw the image
        // Composite may aswell be a Closure with one parameter (the Slide to paint to) returning a Composite
        composite: null,
        // java.awt.image.BufferedImageOp used to draw the image
        // Op may aswell be a Closure with one parameter (the Slide to paint to) returning a BufferedImageOp
        op: null,
        // java.awt.geom.AffineTransform used to draw the image
        // Transform may aswell be a Closure with one parameter (the Slide to paint to) returning a AffineTransform
        transform: null,
        // Component representing the header
        // Header may aswell be a Closure with two parameters (Slide slide, int page)
        // returning a Component
        header:{ slide, page ->
            def header
            noparent {
                header = panel(cssClass: 'headerPanel') {
                    migLayout(layoutConstraints: 'fill', columnConstraints: "[center]".toString(), rowConstraints: "80[center]20".toString())
                    label(text: '', cssClass: 'header', constraints: "grow")
                }
            }
            header
        },
        // Component representing the footer
        // Footer may aswell be a Closure with two parameters (Slide slide, int page)
        // returning a Component
        footer: { slide, page ->
            def footer
            noparent {
                footer = panel(cssClass: 'footerPanel') {
                    stackLayout()
                    label(icon: imageIcon("$templateBase/header_de.png"), constraints: BOTTOM)
                }
            }
            footer
        }
]