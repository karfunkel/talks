import com.bric.image.transition.vanilla.BlendTransition2D
import griffon.plugins.slideware.ImagePanel

slide(
        title: 'Freigestellte Bilder sind handlicher',
        master: 'Image',
        clientPropertySubIndex: 1,
        backgroundPainter: backgroundPainter,
        transition: new BlendTransition2D()
) {
    migLayout(layoutConstraints: 'fill, wrap 1',
              columnConstraints: '[left, fill]',
              rowConstraints: '[center][center][center][center][center, fill]')
    label("Einzelne Bilder herauslösen", cssClass: 'H2w')
    label("Ebenen einzeln speichern", cssClass: 'H3w')
    label("Zerschneiden (Slicen)", cssClass: 'H3w')
    label("Freistellen", cssClass: 'H3w')
    widget(new ImagePanel(), imagePath: 'prototypen/Bilder.png', constraints: 'grow')
}
