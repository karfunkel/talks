import com.bric.image.transition.vanilla.BlendTransition2D

slide(
        title: 'Präsentation und Demo-Projekt auf github',
        clientPropertySubIndex: 4,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill,',
            columnConstraints: '100[center]100',
            rowConstraints: '10[center, fill]10')
    panel(opaque: false) {
        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '[left]', rowConstraints: '[center, fill]')
        label("FishyGames", cssClass: 'L1')
        label("https://github.com/karfunkel/FishyGames", cssClass: 'L3')
        label("Präsentation", cssClass: 'L1')
        label("https://github.com/karfunkel/talks/tree/master/W-JAX11", cssClass: 'L3')
        label("", constraints: 'grow')
    }
}
