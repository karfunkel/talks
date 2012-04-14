import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Umgebung',
        sub: 'Plattform',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Umgebung.selectedIndex = 0
                    else
                        tab_Umgebung.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_Umgebung.selectedIndex = 1
                    else
                        tab_Umgebung.selectedIndex = 2
                },
                { revert ->
                    if (revert)
                        tab_Umgebung.selectedIndex = 2
                    else
                        tab_Umgebung.selectedIndex = 3
                }
        ],
        title: 'Griffon ist nicht isoliert'
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel(background: color(0xDDFFFFFF), constraints: 'grow') {
        migLayout(layoutConstraints: 'fill, flowy',
                columnConstraints: '[center]',
                rowConstraints: '10[center]10')
        tabbedPane(id: 'tab_Umgebung', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'IDE-Integration', buildMVCGroup('agenda', null, [gap: 10, content: {
                panel(content) {
                    label('IDE-Integration', cssClass: 'L1')
                    label('Eclipse STS', cssClass: 'L2')
                    label('Eclipseprojekt durch Script erstellen', cssClass: 'L3')
                    label('Synchronisation durch eclipse-support plugin', cssClass: 'L3')
                    label('IntelliJ IDEA', cssClass: 'L2')
                    label('Projekt durch Script erstellen', cssClass: 'L3')
                    label('Direkt unterstützt', cssClass: 'L3')
                    label('Netbeans', cssClass: 'L2')
                    label('Netbeans-plugin', cssClass: 'L3')
                }
            }]).view.root)
            widget(title: 'UI-Designer', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('UI-Designer', cssClass: 'L1')
                    label('Netbeans Matisse, JFormsDesigner, WindowBuilder ... ', cssClass: 'L2')
                    label('griffon generate-view-script <class> <view-name>', cssClass: 'L3')
                    label('Abeille Forms', cssClass: 'L2')
                    label('abeilleform-builder plugin', cssClass: 'L3')
                }
            }]).view.root)
            widget(title: 'Build-Tools', buildMVCGroup('agenda', null, [gap: 5, content: {
                panel(content) {
                    label('Build-Tools', cssClass: 'L1')
                    label('Apache Ant', cssClass: 'L2')
                    label('griffon integrate-with -ant erstellt build.xml', cssClass: 'L3')
                    label('Gradle', cssClass: 'L2')
                    label('Gradle griffon plugin', cssClass: 'L3')
                    label('griffon integrate-with –gradle erstellt build.gradle', cssClass: 'L3')
                    label('gradle init erstellt Griffonprojekt aus build.gradle', cssClass: 'L3')
                    label('Maven', cssClass: 'L2')
                    label('Noch keine direkte Unterstützung', cssClass: 'L3')
                    label('Griffon-Wrapper', cssClass: 'L2')
                    label('Griffon ohne Installation benutzen', cssClass: 'L3')
                }
            }]).view.root)
            widget(title: 'Sonstiges', buildMVCGroup('agenda', null, [gap: 30, content: {
                panel(content) {
                    label('Sonstiges', cssClass: 'L1')
                    label('Git plugin', cssClass: 'L2')
                    label('maven-publisher plugin', cssClass: 'L2')
                }
            }]).view.root)
        }
    }
}