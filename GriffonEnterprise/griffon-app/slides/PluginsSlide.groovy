import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Plugins',
        sub: 'Architektur',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Plugins.selectedIndex = 0
                    else
                        tab_Plugins.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_Plugins.selectedIndex = 1
                    else
                        tab_Plugins.selectedIndex = 2
                }
        ],
        title: 'Plugins erweitern Griffons Fähigkeiten'
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel(background: color(0xDDFFFFFF), constraints: 'grow') {
        migLayout(layoutConstraints: 'fill, flowy',
                columnConstraints: '[center]',
                rowConstraints: '10[center]10')
        tabbedPane(id: 'tab_Plugins', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'Erweiterung', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('Aktuell ca. 170 Plugins', cssClass: 'L1')
                    label('Es gibt zwei Arten von Plugins', cssClass: 'L1')
                    label('Buildtime-Plugins -> Plugins', cssClass: 'L2')
                    label('Runtime-Plugins -> Addons', cssClass: 'L2')
                }
            }]).view.root)
            widget(title: 'Plugins', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('Plugins können enthalten:', cssClass: 'L1')
                    label('Runtime-Bibliotheken (z.B. miglayout)', cssClass: 'L2')
                    label('Compiletime-Bibliotheken und Skripts (z.B. spock)', cssClass: 'L2')
                    label('Addons', cssClass: 'L2')
                }
            }]).view.root)
            widget(title: 'Addons', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('Addons können enthalten:', cssClass: 'L1')
                    label('Factories für die Verwendung wie BuilderNodes', cssClass: 'L2')
                    label('Methoden welche in Artefakte injiziert werden', cssClass: 'L2')
                    label('Properties welche in Artefakte injiziert werden', cssClass: 'L2')
                    label('MVCGroups', cssClass: 'L2')
                    label('Runtime-Eventhandler', cssClass: 'L2')
                }
            }]).view.root)
        }
    }
}