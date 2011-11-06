import com.bric.image.transition.vanilla.BlendTransition2D

slide(
        title: 'Die Größe macht häufig sorgen',
        clientPropertySubIndex: 2,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '100[center]100',
            rowConstraints: '10[center, fill]10')
    panel(opaque: false) {
        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '[left]', rowConstraints: '[center, fill]')
        label("Welche Devices/Medien werden bedient?", cssClass: 'L1')
        label("Was ist dort möglich?", cssClass: 'L2')
        label("Passen Auflösung bzw. Seitenverhältnis?", cssClass: 'L1')
        label("Welche Elemente verändern ihre Größe?", cssClass: 'L1')
        label("Wie verhalten Sie sich dabei?", cssClass: 'L2')
        label("Wie verhalten sich die Kinder dabei?", cssClass: 'L2')
        label("", constraints: 'grow')
    }
}
