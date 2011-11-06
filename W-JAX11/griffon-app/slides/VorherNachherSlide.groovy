import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Unsere Aufgabe',
        master: 'Image',
        clientPropertySubIndex: 4,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D(),
        slideActions : [
                { revert ->
                    if (revert) {
                        Aufgabe_label.visible = false
                        Aufgabe_image.visible = false
                    } else {
                        Aufgabe_label.visible = true
                        Aufgabe_image.visible = true
                    }
                }
        ]
) {
    migLayout(layoutConstraints: 'fill, wrap 2, flowy',
              columnConstraints: '[center, fill][center, fill]',
              rowConstraints: '[center][center, fill]')
    label("Vorher", cssClass: 'H2w')
    widget(new ImagePanel(), imagePath: 'beispiel/Original.png', constraints: 'grow')
    label(id: 'Aufgabe_label', "Nachher", cssClass: 'H2w', visible: false)
    widget(id: 'Aufgabe_image', new ImagePanel(), imagePath: 'beispiel/Ergebnis.png', constraints: 'grow', visible: false)
}
