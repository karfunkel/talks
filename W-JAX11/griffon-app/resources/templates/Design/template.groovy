import griffon.builder.gfx.HSVGradientPaint
import griffon.plugins.slideware.ImagePanel

nodeIntro = { component ->
    def width = component.width
    def height = component.height
    builder.group {
        antialias true
        background('white')
        rect(x: 0, y: 0, w: width, h: height, bw: 0, fill: gradientPaint(x1: 0, y1: 0, x2: width, y2: height, color1: color('#581188'), color2: color('#370658')))
        for (int d = 0; d <= 240; d += 12) {
            quadCurve(
                    x1: 0, y1: height / 3 + d,
                    x2: width, y2: height / 2 - d,
                    ctrlx: width / 2, ctrly: height,
                    bw: 1, bc: new HSVGradientPaint(0, 0, color('red'), width / 2, height, color('red'), true)
            )
        }
    }
}

nodeMain = { component ->
    def width = component.width
    def height = component.height
    builder.group {
        antialias true
        background('white')
        rect(x: 0, y: 0, w: width, h: height, bw: 0, fill: gradientPaint(x1: 0, y1: 0, x2: width, y2: height, color1: color('#581188'), color2: color('#370658')))
        for (int d = 0; d <= 240; d += 12) {
            quadCurve(
                    x1: 0, y1: height / 3 + d,
                    x2: width, y2: height / 2 - d,
                    ctrlx: width / 2, ctrly: height,
                    bw: 1, bc: new HSVGradientPaint(0, 0, color('red'), width / 2, height, color('red'), true)
            )
        }
        rect(x: 100, y: 130, w: width - 200, h: height - 200, bw: 0, fill: color('white'), opacity: 0.8f)
    }
}

nodeDefault = nodeMain

nodeImage = nodeIntro

/*
 backgroundConfig.paint =
 backgroundConfig.image =
 backgroundConfig.node =
 backgroundConfig.composite =
 backgroundConfig.op =
 backgroundConfig.transform =
 */

backgroundConfig.node = { component ->
    def type = component.master
    if (!type)
        type = 'Default'
    this."node$type".call(component)
}

createHeader = { slide, page ->
    def header
    builder.noparent {
        def type = slide.master
        if (!type)
            type = 'Default'
        def subTitles = app.config.presentation.subTitles
        def subTitlesPerRow = app.config.presentation.subTitlesPerRow ?: 1
        def index = slide.getClientProperty('SubIndex')
        def rows = (int) (subTitles.size / subTitlesPerRow + 0.9)
        header = panel {
            migLayout(layoutConstraints: 'fill', columnConstraints: "20[grow][center][grow]20".toString(), rowConstraints: "20[center]${(0..<rows).collect {'[center]'}.join('')}[center]20".toString())
            label(text: slide.title, cssClass: 'header', constraints: "spanx 3, grow".toString())
            rows.times { row ->
                label('', constraints: 'grow, newline')
                def split = subTitlesPerRow
                if (row == rows - 1)
                    split = (subTitles.size % subTitlesPerRow) ?: subTitlesPerRow
                split.times { col ->
                    def idx = row * subTitlesPerRow + col
                    label(text: subTitles[idx], cssClass: "subtitle${index == idx ? '_active' : ''}".toString(), constraints: "${col == 0 ? 'split ' + split + ',' : ''}sizegroup subs".toString())
                }
                label('', constraints: 'grow')
            }
            canvas(constraints: "spanx 3, grow, newline, x 0, height 16, width ${app.config.presentation.screenWidth}".toString(), opaque: false) {
                line(x1: 100, y1: 8, x2: ((app.config.presentation.screenWidth as int) - 100), y2: 8, bw: 2, bc: color('white'))
            }
        }
        if (type == 'Intro')
            header = panel(opaque: false, preferredSize: header.preferredSize)
    }
    header
}

createFooter = { slide, page ->
    def footer
    builder.noparent {
        def type = slide.master
        if (!type)
            type = 'Default'
        if (type == 'Intro') {
            footer = panel {
                migLayout(layoutConstraints: 'fill', columnConstraints: '5%[left][center][right]5%', rowConstraints: '10[center]10')
                widget(new ImagePanel(), imagePath: 'BeOne.png', scale: 0.25f)
                label('W-JAX 2011', cssClass: 'footer-text', constraints: 'grow')
                label('7. - 11. November 2011, München, Germany', cssClass: 'footer-text2', constraints: 'grow')
            }
        } else {
            footer = panel {
                migLayout(layoutConstraints: 'fill', columnConstraints: '5%[left][center][right]5%', rowConstraints: '10[center]10')
                widget(new ImagePanel(), imagePath: 'BeOne.png', scale: 0.25f)
                label('', constraints: 'grow')
                label(page.toString(), cssClass: "footer$type")
            }
        }
    }
    footer
}

