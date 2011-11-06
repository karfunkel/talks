import griffon.plugins.slideware.ImagePanel

slide(
        master: 'Intro',
        backgroundPainter: backgroundPainter,
        /*
        slideActions : [
                { revert, print ->
                    if (revert) {
                        vielenDank.text = 'Vielen Dank'
                    } else {
                        vielenDank.text = 'für die Blumen'
                    }
                    vielenDank.repaint()
                    return false
                }
        ]
        */
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '[grow][left]50[left][grow]',
            rowConstraints: '10[center]50[center]35[center]25[center][center][center][grow]10')
    label('', constraints: 'spany 7, grow')
    label(id: 'vielenDank', "Vielen Dank", cssClass: 'H1w', constraints: 'spanx 2')
    label('', constraints: 'spany 7, grow, wrap')
    widget(new ImagePanel(), imagePath: 'AlexanderKlein.png', preferredSize: [140, 185], opaque: false, constraints: 'spany 5, left, top')
    label("Alexander Klein", cssClass: 'PNameW', constraints: 'wrap')
    label("alexander.klein@beone-group.com", cssClass: 'PEmail', constraints: 'wrap')
    label("@saschaklein", cssClass: 'PEmail', constraints: 'wrap')
    label("http://gplus.to/karfunkel", cssClass: 'PEmail', constraints: 'wrap')
    label("https://github.com/karfunkel", cssClass: 'PEmail', constraints: 'wrap')

    label('', constraints: 'grow')
}
