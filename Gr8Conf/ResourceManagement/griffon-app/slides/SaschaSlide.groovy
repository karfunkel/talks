import griffon.plugins.slideware.ImagePanel

slide(
        master: 'Intro',
        title: 'About myself',
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    widget(buildMVCGroup('agenda', null, [backgroundColor: color(0xAAFFFFFF), content: {
        panel(content) {
            migLayout(layoutConstraints: 'fill, debug',
                    columnConstraints: '[left]10[center]50[left, fill, grow]10[right]',
                    rowConstraints: '[center]20[center]20[center]20[center]50[center]20[center]20[center]20[center]5[center, fill, grow]')
            widget(new ImagePanel(), imagePath: 'AlexanderKlein.png', constraints: 'spany 9, left, top, gaptop 100')
            label("Alexander (Sascha) Klein", cssClass: 'PName', constraints: 'wrap, gaptop 100')
            label("Advisory Consultant at BeOne Stuttgart GmbH", cssClass: 'PInfo', constraints: 'wrap')
            label("Griffon committer", cssClass: 'PInfo', constraints: 'wrap')
            label("OpenSource, UI and Groovy - Junkie", cssClass: 'PInfo', constraints: 'wrap')
            label("info@aklein.org", cssClass: 'PEmailW', constraints: 'wrap')
            label("@saschaklein", cssClass: 'PEmailW', constraints: 'wrap')
            label("http://gplus.to/karfunkel", cssClass: 'PEmailW', constraints: 'wrap')
            label("", constraints: 'grow')
        }
    }]).view.root)

}
