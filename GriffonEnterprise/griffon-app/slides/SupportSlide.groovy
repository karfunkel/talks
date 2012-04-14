import javax.swing.JTabbedPane

slide(id: 'Support',
        title: 'Es gibt ausreichend Unterstützung',
        sub: 'Einarbeitung',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Support.selectedIndex = 0
                    else
                        tab_Support.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_Support.selectedIndex = 1
                    else
                        tab_Support.selectedIndex = 2
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
        tabbedPane(id: 'tab_Support', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'Informationen', buildMVCGroup('agenda', null, [gap: 5, content: {
                panel(content) {
                    label('Griffon Home', cssClass: 'L1')
                    label('http://griffon.codehaus.org', cssClass: 'L3')
                    label('http://griffon-framework.org', cssClass: 'L3')
                    label('Sourcecode', cssClass: 'L1')
                    label('https://github.com/griffon', cssClass: 'L3')
                    label('Artifact portal', cssClass: 'L1')
                    label('http://artifacts.griffon-framework.org', cssClass: 'L3')
                    label('Dokumentation / Griffon guide', cssClass: 'L1')
                    label('http://griffon.codehaus.org/guide/latest', cssClass: 'L3')
                    label('Blog', cssClass: 'L1')
                    label('http://www.jroller.com/aalmiray', cssClass: 'L3')
                }
            }]).view.root)
            widget(title: 'Bücher', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    panel(background: color(0x00)) {
                        migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '0[center][left, grow]0', rowConstraints: "0[center]20[center]20[center]20[center]0")
                        label(icon: imageIcon("/GriffonInAction.jpg"), cssClass: 'image', constraints: 'spany 4, wrap')
                        label('Griffon in Action (MEAP)', cssClass: 'L1')
                        label('Manning Publications Co', cssClass: 'L2')
                        label('Andres Almiray, Danno Ferrin, and James Shingler', cssClass: 'L2')
                        label('http://www.manning.com/almiray', cssClass: 'L2')
                    }
                }
            }]).view.root)
            widget(title: 'Schulungen und Support', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    migLayout(layoutConstraints: 'fill, flowy', columnConstraints: '0[center][left, grow]0', rowConstraints: "0[center]20[center]80[center]20[center]0")
                    label(icon: imageIcon("/BeOne.png"), cssClass: 'image', constraints: 'spany 2')
                    label(icon: imageIcon("/canoo_logo.png"), cssClass: 'image', constraints: 'spany 2, wrap')
                    label('BeOne Stuttgart GmbH', cssClass: 'L1')
                    label('http://www.beone-group.com', cssClass: 'L2')
                    label('Canoo Engineering AG, Basel', cssClass: 'L1')
                    label('http://www.canoo.com', cssClass: 'L2')
                }
            }]).view.root)
        }
    }
}