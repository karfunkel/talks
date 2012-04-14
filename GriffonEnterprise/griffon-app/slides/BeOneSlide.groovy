import griffon.plugins.slideware.ImagePanel

slide(
        id: 'BeOne',
        master: 'Intro'
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel(background: color('white')) {
        migLayout(layoutConstraints: 'fill',
                columnConstraints: '0[left]10[center]50[left, fill, grow]10[right]0',
                rowConstraints: '0[center]10[center]10[center]10[center]10[center]10[center]20[center]10[center]10[center][center, fill, grow]')
        widget(new ImagePanel(), imagePath: 'BeOneArc-Left.png', constraints: 'spany 10')
        widget(new ImagePanel(), imagePath: 'BeOne_Logo.png', scale: 0.5f, constraints: 'spanx 2, center, gaptop 10')
        widget(new ImagePanel(), imagePath: 'BeOneArc-Right.png', constraints: 'spany 10, wrap')
        widget(new ImagePanel(), imagePath: 'AlexanderKlein.png', constraints: 'spany 9, left, top, gaptop 85')
        label("Alexander Klein", cssClass: 'PName', constraints: 'wrap, gaptop 73')
        label("Advisory Consultant bei BeOne Stuttgart GmbH", cssClass: 'PInfo', constraints: 'wrap')
        label("Consulting für Prozesse, Engineering und IT", cssClass: 'PInfo', constraints: 'wrap')
        label("Technisch verantwortlich für den Java-Stack", cssClass: 'PInfo', constraints: 'wrap')
        label("http://www.beone-group.com", cssClass: 'PUrl', constraints: 'wrap')
        label("Committer bei Griffon", cssClass: 'PInfo', constraints: 'wrap')
        label("@saschaklein", cssClass: 'PEmail', constraints: 'wrap')
        label("http://gplus.to/karfunkel", cssClass: 'PEmail', constraints: 'wrap')

        label("", constraints: 'grow')
    }
}