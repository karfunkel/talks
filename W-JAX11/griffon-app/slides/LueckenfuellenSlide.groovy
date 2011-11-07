import com.bric.image.transition.spunk.CollapseTransition2D

slide(
        title: 'Gliederung',
        clientPropertySubIndex: 2,
        backgroundPainter: backgroundPainter,
        transition: new CollapseTransition2D()
) {
    migLayout(layoutConstraints: 'fill, flowy',
              columnConstraints: '100[center]100',
              rowConstraints: '10[center]10')
    label("Was benötigen wir?", cssClass: 'H2')
    label("Was bekommen wir vom Grafiker?", cssClass: 'H2')
    label("Was müssen wir ergänzen?", cssClass: 'H2o')
    label("Wie setzt man das in Swing um?", cssClass: 'H2')
    label("Gibt's dazu ein Beispiel?", cssClass: 'H2')
}
