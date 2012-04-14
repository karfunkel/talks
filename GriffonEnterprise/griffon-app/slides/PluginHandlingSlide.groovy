import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'PluginHandling',
        sub: 'Architektur',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_PluginHandling.selectedIndex = 0
                    else
                        tab_PluginHandling.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_PluginHandling.selectedIndex = 1
                    else
                        tab_PluginHandling.selectedIndex = 2
                }
        ],
        title: 'Das Plugin-Handling wurde komplett überarbeitet'
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel(background: color(0xDDFFFFFF), constraints: 'grow') {
        migLayout(layoutConstraints: 'fill, flowy',
                columnConstraints: '[center]',
                rowConstraints: '10[center]10')
        tabbedPane(id: 'tab_PluginHandling', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'Repositories', buildMVCGroup('agenda', null, [gap: 10, content: {
                panel(content) {
                    label('Es gibt 3 Typen von Repositories', cssClass: 'L1')
                    label('Lokale Repositories', cssClass: 'L2')
                    label('Die Artifakte liegen im Dateisystem', cssClass: 'L3')
                    label('Immer vorhanden: griffon-local', cssClass: 'L3')
                    label('Remote Repositories', cssClass: 'L2')
                    label('Die Artifakte liegen in einem Portal', cssClass: 'L3')
                    label('Offizielles Portal (griffon-central) unter: http://artifacts.griffon-framework.org', cssClass: 'L3')
                    label('Quellcode (Grails) unter: https://github.com/griffon/griffon-artifact-portal', cssClass: 'L3')
                    label('Legacy Repository', cssClass: 'L2')
                    label('Rückwärtskompatibilität für alte Plugins', cssClass: 'L3')
                }
            }]).view.root)
            widget(title: 'Versionen', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('ab V1.0 bedeutsame Versionsnummern', cssClass: 'L1')
                    label('<Major>.<Minor>.<Bugfix> z.B. 1.2.3', cssClass: 'L2')
                    label('Major: Grundlegende Änderungen', cssClass: 'L3')
                    label('Minor: sind abwärtskompatibel', cssClass: 'L3')
                    label('Bugfix: nur Korrekturen', cssClass: 'L3')
                    label('SNAPSHOT-Versionen werden anders behandelt', cssClass: 'L1')
                    label('V1.2-SNAPSHOT < V1.2', cssClass: 'L2')
                    label('SNAPSHOTs werden nicht gecached', cssClass: 'L2')
                }
            }]).view.root)
            widget(title: 'Verteilte Entwicklung', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('Große Anwendungen logisch in Plugins aufteilen', cssClass: 'L1')
                    label('Hauptprojekt bindet Unterprojekte als Plugins ein', cssClass: 'L2')
                    label('Unterprojekte sollten Plugins mit SNAPSHOT-Versionen sein', cssClass: 'L2')
                    label('Linked Plugins in Planung', cssClass: 'L2')
                    label('Framework Plugins (global) werden diskutiert', cssClass: 'L2')
                }
            }]).view.root)
        }
    }
}