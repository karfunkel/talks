import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Fonts können meistens ausgelesen werden',
        master: 'Image',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill, wrap 1',
              columnConstraints: '[left, fill]',
              rowConstraints: '[center][center, fill]')
    label("Im Zweifel Font bestimmen", cssClass: 'H2w')
    widget(new ImagePanel(), imagePath: 'prototypen/WhatTheFont.png', constraints: 'grow')
}
