import java.awt.Color
import javax.swing.SwingConstants
import griffon.plugins.slideware.Slide

master_Default = [
        // Set an instance of java.awt.Paint to paint the lowest background level
        // Paint may be a Paint or a Closure with one parameter (the Slide to paint to) returning a Paint
        paint: new Color(0xD55500),
        // Add an image (below) or a GfxBuilder node to paint ontop of the given Paint
        // Node may be a GfxBuilder node or a Closure with one parameter (the Slide to paint to) returning a GfxNode
        node: { Slide slide ->
            builder.group {
                antialias true
                background('white')
                rect(x: 0, y: 0, w: slide.width, h: slide.height, bw: 0, fill: gradientPaint(x1: 0, y1: 0, x2: slide.width, y2: slide.height, color1: color('#D55500'), color2: color('#FFFFFF')))
                for (int d = 0; d <= 240; d += 12) {
                    quadCurve(
                            x1: 0, y1: slide.height / 3 + d,
                            x2: slide.width, y2: slide.height / 2 - d,
                            ctrlx: slide.width / 2, ctrly: slide.height,
                            bw: 1,
                            bc: new Color(0xFFFFFF)
                    )
                }
            }
        },
        // The image can be set as String (resource loaded from the classpath), URL, File, InputStream or Image
        // Image may aswell be a Closure with one parameter (the Slide to paint to) returning an Image
        image: null,
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
                    panel(constraints: TOP, opaque: false) {
                        def subTitles = app.config.presentation.subTitles ?: []
                        def index = slide.getClientProperty('sub')
                        if (index instanceof String)
                            index = subTitles.indexOf(index)
                        def rows = subTitles.inject([[]]) { init, value ->
                            if (value == null) init << [] else init.last() << value
                            return init
                        }
                        if (index != null) {
                            migLayout(layoutConstraints: '', columnConstraints: "20[left, grow, fill][center][right, grow, fill]20".toString(), rowConstraints: "20${(0..<(rows.size())).collect {'[center]'}.join('')}25[center]0[center]20".toString())
                        } else
                            migLayout(layoutConstraints: '', columnConstraints: "20[left, grow, fill][center][right, grow, fill]20".toString(), rowConstraints: "20[center]0[center]20".toString())
                        if (index != null) {
                            int idx = 0
                            for (def row : rows) {
                                label('', constraints: 'grow')
                                for (int col = 0; col < row.size(); col++) {
                                    label(text: row[col], cssClass: "subtitle${index == idx ? '_active' : ''}".toString(), constraints: "${col == 0 ? 'split ' + row.size() + ',' : ''}gap 30 30".toString())
                                    idx++
                                }
                                label('', constraints: 'grow, wrap')
                            }
                        }
                        label(text: slide.title, cssClass: 'header', constraints: "spanx 3, grow, wrap")
                        canvas(constraints: "spanx 3, grow, x 0, height 16, width ${app.config.presentation.screenWidth}".toString(), opaque: false) {
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
                    panel(constraints: BOTTOM, opaque: false) {
                        migLayout(layoutConstraints: 'fill', columnConstraints: '[grow, fill][right]30')
                        label ''
                        label(icon: imageIcon("$templateBase/gr8conf.png"))
                    }
                    panel(constraints: TOP, opaque: false) {
                        migLayout(layoutConstraints: 'fill', columnConstraints: '[center, grow]', rowConstraints: '[center]')
                        label(text: "$page / ${app.config.presentation.order.size()}".toString(), cssClass: 'footer')
                    }
                    panel(constraints: BOTTOM, opaque: false) {
                        migLayout(layoutConstraints: 'fill', columnConstraints: '5[left][center, grow][right]5', rowConstraints: '[bottom]5')
                        if (page > 2)
                            label(text: "${app.config.presentation.order[page - 2]}".toString(), cssClass: 'nextSlide')
                        else
                            label(text: '', cssClass: 'nextSlide')
                        label(text: '', cssClass: 'nextSlide')
                        if (page < app.config.presentation.order.size() - 1)
                            label(text: "${app.config.presentation.order[page]}".toString(), cssClass: 'nextSlide')
                        else
                            label(text: '', cssClass: 'nextSlide')
                    }
                }
            }
            footer
        }
]

master_Intro = [
        // Set an instance of java.awt.Paint to paint the lowest background level
        // Paint may be a Paint or a Closure with one parameter (the Slide to paint to) returning a Paint
        paint: new Color(0xD55500),
        // Add an image (below) or a GfxBuilder node to paint ontop of the given Paint
        // Node may be a GfxBuilder node or a Closure with one parameter (the Slide to paint to) returning a GfxNode
        node: { Slide slide ->
            builder.group {
                antialias true
                background('white')
                rect(x: 0, y: 0, w: slide.width, h: slide.height, bw: 0, fill: gradientPaint(x1: 0, y1: 0, x2: slide.width, y2: slide.height, color1: color('#D55500'), color2: color('#FFFFFF')))
                for (int d = 0; d <= 240; d += 12) {
                    quadCurve(
                            x1: 0, y1: slide.height / 3 + d,
                            x2: slide.width, y2: slide.height / 2 - d,
                            ctrlx: slide.width / 2, ctrly: slide.height,
                            bw: 1,
                            bc: new Color(0xFFFFFF)
                    )
                }
            }
        },
        // The image can be set as String (resource loaded from the classpath), URL, File, InputStream or Image
        // Image may aswell be a Closure with one parameter (the Slide to paint to) returning an Image
        image: null,
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
                    migLayout(layoutConstraints: 'fill', columnConstraints: '[grow, fill][right]30')
                    label ''
                    label(icon: imageIcon("$templateBase/gr8conf.png"))
                }
            }
            footer
        }
]

master_Gr8conf_Intro = [
        // Set an instance of java.awt.Paint to paint the lowest background level
        // Paint may be a Paint or a Closure with one parameter (the Slide to paint to) returning a Paint
        paint: new Color(0xFFFFFF),
        // Add an image (below) or a GfxBuilder node to paint ontop of the given Paint
        // Node may be a GfxBuilder node or a Closure with one parameter (the Slide to paint to) returning a GfxNode
        node: { Slide slide ->
            builder.group {
                antialias true
                background('white')
                multiRoundRect(x: 10, y: 95, w: slide.width - 20, h: slide.height - 115, fill: color('#FFFFFF'), bc: color('#D55500'), bw: 3, tlw: 10, tlh: 10, trw: 10, trh: 10, blw: 10, blh: 10, brw: 10, brh: 10)
            }
        },
        // The image can be set as String (resource loaded from the classpath), URL, File, InputStream or Image
        // Image may aswell be a Closure with one parameter (the Slide to paint to) returning an Image
        image: null,
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
                    migLayout(layoutConstraints: 'fill', rowConstraints: '[center, grow]', columnConstraints: '10[left][center, grow][right]10')
                    label(icon: imageIcon("$templateBase/gr8conf.png"))
                    label(text: '', cssClass: 'header', constraints: "grow")
                    label(icon: imageIcon("$templateBase/gr8conf2.png"))
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
                    migLayout(layoutConstraints: 'fill', columnConstraints: '10[grow, fill]30')
                    label ''
                }
            }
            footer
        }
]

master_Globe = [
        // Set an instance of java.awt.Paint to paint the lowest background level
        // Paint may be a Paint or a Closure with one parameter (the Slide to paint to) returning a Paint
        paint: new Color(0xFFFFFF),
        // Add an image (below) or a GfxBuilder node to paint ontop of the given Paint
        // Node may be a GfxBuilder node or a Closure with one parameter (the Slide to paint to) returning a GfxNode
        node: null,
        // The image can be set as String (resource loaded from the classpath), URL, File, InputStream or Image
        // Image may aswell be a Closure with one parameter (the Slide to paint to) returning an Image
        image: 'Globe.jpg',
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
        header: { slide, page -> label('') },
        // Component representing the footer
        // Footer may aswell be a Closure with two parameters (Slide slide, int page)
        // returning a Component
        footer: { slide, page -> label('') }
]