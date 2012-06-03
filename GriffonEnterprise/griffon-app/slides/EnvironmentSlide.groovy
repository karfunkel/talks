import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Environment',
        title: 'Für viele Systeme gibt es Plugins',
        sub: 'Integration',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Environment.selectedIndex = 0
                    else
                        tab_Environment.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_Environment.selectedIndex = 1
                    else
                        tab_Environment.selectedIndex = 2
                }
        ]
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel(background: color(0xDDFFFFFF)) {
        migLayout(layoutConstraints: 'fill, flowy',
                columnConstraints: '[center]',
                rowConstraints: '10[center]10')
        tabbedPane(id: 'tab_Environment', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'Datenbanken', buildMVCGroup('agenda', null, [gap: 10, content: {
                panel(content) {
                    label('Plugins für viele Datenbanken (27)', cssClass: 'L1')
                    label('SQL', cssClass: 'L2')
                    label('NoSQL', cssClass: 'L2')
                    label('Objekt basiert', cssClass: 'L2')
                    label('LDAP', cssClass: 'L2')
                    label('geplant nach V1.0: GORM', cssClass: 'L1')
                    label('geplant nach V1.0: Scaffolding', cssClass: 'L1')
                }
            }]).view.root)
            widget(title: 'Kommunikation', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('Nachrichten', cssClass: 'L1')
                    label('EMail, Jabber', cssClass: 'L2')
                    label('Protokolle', cssClass: 'L1')
                    label('Protobuf, RMI, Hessian', cssClass: 'L2')
                    label('Webkommunikation', cssClass: 'L1')
                    label('REST, SOAP, XMLRPC', cssClass: 'L2')
                }
            }]).view.root)
            widget(title: 'Reporting/Monitoring', buildMVCGroup('agenda', null, [gap: 40, content: {
                panel(content) {
                    label('Monitoring', cssClass: 'L1')
                    label('JMX', cssClass: 'L2')
                    label('Reporting', cssClass: 'L1')
                    label('JasperReports', cssClass: 'L2')
                    label('Slideware', cssClass: 'L2')
                }
            }]).view.root)
        }
    }
}