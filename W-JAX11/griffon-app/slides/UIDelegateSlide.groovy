import com.bric.image.transition.vanilla.BlendTransition2D
import org.fife.ui.rsyntaxtextarea.SyntaxConstants

slide(
        title: 'ComponentUI ist der Vater aller UIDelegates',
        clientPropertySubIndex: 3,
        backgroundPainter: backgroundPainter
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '100[center]100',
            rowConstraints: '10[center, fill]10')
    panel(opaque: false) {
        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '[left]', rowConstraints: '[center, fill]')
        label("Funktionen eines Delegates:", cssClass: 'L1')
        label("installUI / uninstallUI setzt bzw. entfernt Elemente", cssClass: 'L2')
        label("Font, Color, Border, Opacity und sonstige Eigenschaften", cssClass: 'L3')
        label("LayoutManager", cssClass: 'L3')
        label("Unterkomponenten", cssClass: 'L3')
        label("Event-Listener", cssClass: 'L3')
        label("Keyboard-Actions und Mnemonics", cssClass: 'L3')
        label("Sonstige Initialisierungen", cssClass: 'L3')
        label("Definiert minimale, bevorzugte und maximale Größe", cssClass: 'L2')
        label("Implementiert Hit-Detection (contains)", cssClass: 'L2')
        label("Zeichnet die Komponente", cssClass: 'L2')
        label("", constraints: 'grow')
    }
}
