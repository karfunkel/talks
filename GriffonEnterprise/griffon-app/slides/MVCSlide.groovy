import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'MVC',
        sub: 'Architektur',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_MVC.selectedIndex = 0
                    else
                        tab_MVC.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_MVC.selectedIndex = 1
                    else
                        tab_MVC.selectedIndex = 2
                },
                { revert ->
                    if (revert)
                        tab_MVC.selectedIndex = 2
                    else
                        tab_MVC.selectedIndex = 3
                }
        ],
        title: 'MVC ist Standard, Presentation Model ist möglich'
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel(background: color(0xDDFFFFFF), constraints: 'grow') {
        migLayout(layoutConstraints: 'fill, flowy',
                columnConstraints: '[center]',
                rowConstraints: '10[center]10')
        tabbedPane(id: 'tab_MVC', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            rtextScrollPane(title: 'Application.groovy') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''application {
    title = 'MyProjectName'
    startupGroups = ['myProjectName']
    autoShutdown = true
}
mvcGroups {
    'myMVCGroup' {
        model      = 'my.pkg.MyMVCGroupModel'
        view       = 'my.pkg.MyMVCGroupView'
        controller = 'my.pkg.MyMVCGroupController'
    }
    'myProjectName' {
        model      = 'my.pkg.MyProjectNameModel'
        view       = 'my.pkg.MyProjectNameView'
        actions    = 'my.pkg.MyProjectNameActions'
        controller = 'my.pkg.MyProjectNameController'
    }
    'myPMGroup' {
        model      = 'my.pkg.MyMVCGroupModel'
        view       = 'my.pkg.MyMVCGroupView'
    }
}'''
                )
            }
            widget(title: 'Views aufteilen', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('Alle Artefakte werden gleich behandelt', cssClass: 'L1')
                    label('Scripts werden mit der selben Builderinstanz erstellt (View)', cssClass: 'L2')
                    label('Klassen bekommen alle Instanzen injiziert (Controller, Model)', cssClass: 'L2')
                    label('SwingBuilder Views aufteilen', cssClass: 'L1')
                    label('build(<class>) führt das Script aus', cssClass: 'L2')
                }
            }]).view.root)
            panel(title: 'XML Views', background: color(0x00)) {
                migLayout(layoutConstraints: 'fill, flowy',
                        columnConstraints: '[center, fill, grow]',
                        rowConstraints: '[center, fill, grow]')
                rtextScrollPane {
                    rsyntaxTextArea(editable: false,
                            syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                            text: '''application(title: app.config.application.title, pack: true) {
  actions {
    action(id: 'clickAction', name: 'Click', closure: {controller.click(it)})
  }
  gridLayout(cols: 1, rows: 3)
  textField(id: 'input', text: bind('value', target: model), columns: 20)
  textField(id: 'output', text: bind{model.value}, columns: 20, editable: false)
  button(action: clickAction)
}'''
                    )
                }
                rtextScrollPane {
                    rsyntaxTextArea(editable: false,
                            syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_XML, tabSize: 4, cssClass: 'codeEditor',
                            text: '''<application title="app.config.application.title" pack="true">
    <actions>
        <action id="'clickAction'" name="'Click'" closure="{controller.click(it)}"/>
    </actions>
    <gridLayout cols="1" rows="3"/>
    <textField id="'input'" columns="20" text="bind('value', target: model)"/>
    <textField id="'output'" columns="20" text="bind{model.value}" editable="false"/>
    <button action="clickAction"/>
</application>'''
                    )
                }
            }
            rtextScrollPane(title: 'MultiView Groups') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''buildMVCGroup('myPMGroup')

def myPMGroup = app.groups.myPMGroup

def myOtherGroup = buildMVCGroup('myOtherGroup', [model: myPMGroup.model])

assert myPMGroup.model.is(myOtherGroup.model) '''
                )
            }
        }
    }
}