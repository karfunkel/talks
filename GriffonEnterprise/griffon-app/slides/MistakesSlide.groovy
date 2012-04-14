import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Mistakes',
        sub: 'Architektur',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Mistakes.selectedIndex = 0
                    else
                        tab_Mistakes.selectedIndex = 1
                }
        ],
        title: 'Griffon versucht Fehler zu vermeiden',
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel(background: color(0xDDFFFFFF)) {
        migLayout(layoutConstraints: 'fill, flowy',
                columnConstraints: '[center]',
                rowConstraints: '10[center]10')
        tabbedPane(id: 'tab_Mistakes', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'UI Thread Handling', buildMVCGroup('agenda', null, [ content: {
                panel(content) {
                    label('Korrektes UI-Threadhandling in Java ist aufwändig', cssClass: 'L1')
                    label('Griffon bietet eigene Methoden', cssClass: 'L2')
                    label('execSync', cssClass: 'L3')
                    label('execAsync', cssClass: 'L3')
                    label('execOutside', cssClass: 'L3')
                    label('Controller-Actions automatisch ausserhalb UI Thread', cssClass: 'L2')
                    label('Verhalten anpassbar', cssClass: 'L3')
                }
            }]).view.root)
            widget(title: 'Nicht gefangene Exceptions', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('Jede UncaughtException feuert zwei Events', cssClass: 'L1')
                    label('UncaughtExceptionThrown und Uncaught<ExceptionName>', cssClass: 'L2')
                    label('Jeder Eventcontroller kann darauf reagieren', cssClass: 'L2')
                    label('Gilt auch im UI Thread', cssClass: 'L1')
                }
            }]).view.root)
        }
    }
}
