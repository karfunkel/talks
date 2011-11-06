import griffon.plugins.slideware.ImagePanel

slide(
        master: 'Intro',
        backgroundPainter: backgroundPainter
) {
    panel(background: color('white')) {
        migLayout(layoutConstraints: 'fill',
                columnConstraints: '10[left]10[center]50[left, fill, grow]10[right]10',
                rowConstraints: '10[center]20[center]20[center]20[center]20[center]50[center]25[center, fill, grow]')
        widget(new ImagePanel(), imagePath: 'BeOneArc-Left.png', constraints: 'spany 7')
        widget(new ImagePanel(), imagePath: 'BeOne.png', scale: 0.5f, constraints: 'spanx 2, center')
        widget(new ImagePanel(), imagePath: 'BeOneArc-Right.png', constraints: 'spany 7, wrap')
        widget(new ImagePanel(), imagePath: 'AlexanderKlein.png', constraints: 'spany 6, left, top, gaptop 175')
        label("Alexander Klein", cssClass: 'PName', constraints: 'wrap, gaptop 143')
        label("Senior Consultant bei BeOne Stuttgart GmbH", cssClass: 'PInfo', constraints: 'wrap')
        label("Consulting für Prozesse, Engineering und IT", cssClass: 'PInfo', constraints: 'wrap')
        label("http://www.beone-group.com", cssClass: 'PUrl', constraints: 'wrap')
        label("Committer bei Griffon", cssClass: 'PInfo', constraints: 'wrap')

        label("", constraints: 'grow')
    }
}
