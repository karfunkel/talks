import griffon.plugins.slideware.ImagePanel

slide(
        id: 'VielenDank',
        master: 'Intro'
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel(background: color(0x00)) {
        migLayout(layoutConstraints: 'fill',
                columnConstraints: '[grow][left]50[left][grow]',
                rowConstraints: '70[center]50[center]35[center]25[center][center][center][grow]10')
        label('', constraints: 'spany 7, grow')
        label("Thank you", cssClass: 'H1w', constraints: 'spanx 2')
        label('', constraints: 'spany 7, grow, wrap')
        widget(new ImagePanel(), imagePath: 'AlexanderKlein.png', preferredSize: [140, 185], opaque: false, constraints: 'spany 5, left, top')
        label("Alexander Klein", cssClass: 'PNameO', constraints: 'wrap')
        label("alexander.klein@beone-group.com", cssClass: 'PEmailW', constraints: 'wrap')
        label("@saschaklein", cssClass: 'PEmailW', constraints: 'wrap')
        label("http://gplus.to/karfunkel", cssClass: 'PEmailW', constraints: 'wrap')
        label("https://github.com/karfunkel/talks", cssClass: 'PEmailW', constraints: 'wrap')
        label('', constraints: 'grow')
    }
}