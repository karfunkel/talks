import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'XCutting',
        sub: 'Architektur',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_XCutting.selectedIndex = 0
                    else
                        tab_XCutting.selectedIndex = 1
                }
        ],
        title: 'Querschnittsthemen sind oft ohne AOP lösbar',
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel(background: color(0xDDFFFFFF)) {
        migLayout(layoutConstraints: 'fill, flowy',
                columnConstraints: '[center]',
                rowConstraints: '10[center]10')
        tabbedPane(id: 'tab_XCutting', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'Events und Inspection', buildMVCGroup('agenda', null, [gap: 10, content: {
                panel(content) {
                    label('Application Events ermöglichen Artefakte', cssClass: 'L1')
                    label('bei Erzeugung zu analysieren', cssClass: 'L2')
                    label('nach Erzeugung zu verändern', cssClass: 'L2')
                    label('Alle Artefake sind zu Laufzeit analysierbar', cssClass: 'L1')
                    label('Groovy Metaprogramming hilft oft', cssClass: 'L1')
                }
            }]).view.root)
            widget(title: 'Manager und Handler', buildMVCGroup('agenda', null, [gap: 10, content: {
                panel(content) {
                    label('Managerklassen verfügbar', cssClass: 'L1')
                    label('Addons', cssClass: 'L2')
                    label('Artefakte', cssClass: 'L2')
                    label('MVC Gruppen', cssClass: 'L2')
                    label('WindowManager (Swing, SWT)', cssClass: 'L2')
                    label('Handler verfügbar', cssClass: 'L1')
                    label('Lifecycle', cssClass: 'L2')
                    label('Platform', cssClass: 'L2')
                }
            }]).view.root)
        }
    }
}