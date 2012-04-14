import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'CreateMVC',
        sub: 'Plattform',
        title: 'Artefakte erstellen ist Routine',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_CreateMVC.selectedIndex = 0
                    else
                        tab_CreateMVC.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_CreateMVC.selectedIndex = 1
                    else
                        tab_CreateMVC.selectedIndex = 2
                },
                { revert ->
                    if (revert)
                        tab_CreateMVC.selectedIndex = 2
                    else
                        tab_CreateMVC.selectedIndex = 3
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
        tabbedPane(id: 'tab_CreateMVC', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            rtextScrollPane(title: 'create-mvc') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL, tabSize: 4, cssClass: 'codeEditor',
                        text: '''% griffon create-mvc MyMVCGroup                                                                                                 130 ↵
...
Created Model for MyMVCGroup
Created View for MyMVCGroup
Created Controller for MyMVCGroup
Created IntegrationTests for MyMVCGroup'''
                )
            }
            rtextScrollPane(title: 'Model') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''package my.pkg

import groovy.beans.Bindable

class MyMVCGroupModel {
   // @Bindable String propName
}'''
                )
            }
            rtextScrollPane(title: 'View') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''package my.pkg

application(title: 'myProjectName',
  preferredSize: [320, 240],
  pack: true,
  //location: [50,50],
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    // add content here
    label('Content Goes Here') // delete me
}'''
                )
            }
            rtextScrollPane(title: 'Controller') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''package my.pkg
class MyMVCGroupController {
    // these will be injected by Griffon
    def model
    def view

    // void mvcGroupInit(Map args) {
    //    // this method is called after model and view are injected
    // }
    // void mvcGroupDestroy() {
    //    // this method is called when the group is destroyed
    // }

    /*
        Remember that actions will be called outside of the UI thread
        by default. You can change this setting of course.
        Please read chapter 9 of the Griffon Guide to know more.

    def action = { evt = null ->
    }
    */
}'''
                )
            }
        }
    }
}