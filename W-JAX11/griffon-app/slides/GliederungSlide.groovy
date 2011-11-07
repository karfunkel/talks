import com.bric.image.transition.vanilla.MotionBlendTransition2D

slide(
        title: 'Gliederung',
        backgroundPainter: backgroundPainter,
        transition: new MotionBlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill, flowy',
              columnConstraints: '100[center]100',
              rowConstraints: '10[center]10')
    label("Was benötigen wir?", cssClass: 'H2')
    label("Was bekommen wir vom Grafiker?", cssClass: 'H2')
    label("Was müssen wir ergänzen?", cssClass: 'H2')
    label("Wie setzt man das in Swing um?", cssClass: 'H2')
    label("Gibt's dazu ein Beispiel?", cssClass: 'H2')
}
