import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Unsere Aufgabe',
        master: 'Image',
        clientPropertySubIndex: 4,
        backgroundPainter: backgroundPainter,
        slideActions : [
                { revert ->
                    if (revert) {
                        Aufgabe_vorher.visible = false
                    } else {
                        Aufgabe_vorher.visible = true
                    }
                },
                { revert ->
                    if (revert) {
                        Aufgabe_nachher.visible = false
                    } else {
                        Aufgabe_nachher.visible = true
                    }
                }
        ]
) {
    migLayout(layoutConstraints: 'fill, wrap 2, flowy',
              columnConstraints: '[center, fill][center, fill]',
              rowConstraints: '[center][center, fill]')
    label("Vorher", cssClass: 'H2w')
    widget(id: 'Aufgabe_vorher', new ImagePanel(), imagePath: 'beispiel/Original.png', constraints: 'grow', visible: false)
    label("Nachher", cssClass: 'H2w')
    widget(id: 'Aufgabe_nachher', new ImagePanel(), imagePath: 'beispiel/Ergebnis.png', constraints: 'grow', visible: false)
}
