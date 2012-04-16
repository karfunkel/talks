import javax.swing.JTabbedPane

slide(id: 'Fazit',
        title: 'Griffon ist reif für Enterprise',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Fazit.selectedIndex = 0
                    else
                        tab_Fazit.selectedIndex = 1
                }
        ]
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, fill, grow]30',
            rowConstraints: '[center, fill, grow]')
    panel(background: color(0xDDFFFFFF)) {
        migLayout(layoutConstraints: 'fill, flowy',
                columnConstraints: '[center]',
                rowConstraints: '10[center]10')
        tabbedPane(id: 'tab_Fazit', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'Kosten', buildMVCGroup('agenda', null, [gap: 5, content: {
                panel(content) {
                    label('Kosteneinsparung', cssClass: 'L1')
                    label('Nimmt Routineaufgaben ab', cssClass: 'L2')
                    label('Minimiert Rüstzeiten', cssClass: 'L2')
                    label('Vereinfacht und erspart Bibliotheken Wissen', cssClass: 'L2')
                    label('Bringt Buildsystem mit', cssClass: 'L2')
                    label('Steigert Wartbarkeit', cssClass: 'L1')
                    label('Unterstützt Architekturansätze', cssClass: 'L2')
                    label('Unterstützt Wiederverwendbarkeit', cssClass: 'L2')
                    label('Fördert lesbaren Code', cssClass: 'L2')
                    label('Fördert Tests und Code Qualität', cssClass: 'L2')
                }
            }]).view.root)
            widget(title: 'Sonstiges', buildMVCGroup('agenda', null, [gap: 5, content: {
                panel(content) {
                    label('Toolkit vs. Framework', cssClass: 'L1')
                    label('Nicht beschränkend', cssClass: 'L2')
                    label('Schrittweise Migration möglich', cssClass: 'L2')
                    label('Unterstützte Integration in Umgebung', cssClass: 'L2')
                    label('Organisatorisch', cssClass: 'L1')
                    label('Ermöglicht Entwicklung in verteilten Teams', cssClass: 'L2')
                    label('Liberale Lizenz (APL)', cssClass: 'L2')
                    label('Community und Kommerzieller Support', cssClass: 'L2')
                    label('Referenzen', cssClass: 'L1')
                    label('Automotive', cssClass: 'L2')
                    label('Sozialversicherung', cssClass: 'L2')
                }
            }]).view.root)
        }
    }
}
