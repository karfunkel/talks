import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Scripts',
        sub: 'Plattform',
        title: 'Skripte erleichtern die Entwicklung',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Scripts.selectedIndex = 0
                    else
                        tab_Scripts.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_Scripts.selectedIndex = 1
                    else
                        tab_Scripts.selectedIndex = 2
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
        tabbedPane(id: 'tab_Scripts', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            rtextScrollPane(title: 'Skript erstellen') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL, tabSize: 4, cssClass: 'codeEditor',
                        text: '''% griffon create-script MyScript
...
Created Script for MyScript
...
Created ScriptTests for MyScript

% ls -la scripts
insgesamt 8
drwxrwxr-x  2 sascha sascha   28 2012-04-14 16:43 .
drwxrwxr-x 11 sascha sascha 4096 2012-04-13 09:37 ..
-rw-rw-r--  1 sascha sascha  452 2012-04-14 16:43 MyScript.groovy'''
                )
            }
            rtextScrollPane(title: 'MyScript.groovy') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''// Include core griffon scripts with the following call
//
//     includeTargets << griffonScript('_GriffonCompile)
//
// Include plugin scripts with the following call
//
//    includeTargets << griffonPluginScript('some-plugin-name', 'ScriptName')
//

target(name: 'myscript',
        description: "The description of the script goes here!",
        prehook: null, posthook: null) {
    // TODO: Implement script here
}

setDefaultTarget('myscript')'''
                )
            }
            widget(title: 'Gant-Skripte', buildMVCGroup('agenda', null, [gap: 10, content: {
                panel(content) {
                    label('Scripte sind Gant-Skripte', cssClass: 'L1')
                    label('Gant ist Ant als Groovy-Script', cssClass: 'L1')
                    label('Ant-Skript', cssClass: 'L2')
                    rtextScrollPane(cssClass: 'L3', constraints: 'growx') {
                        rsyntaxTextArea(editable: false,
                                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_XML, tabSize: 4, cssClass: 'codeEditor',
                                text: '''<project default="main">
    <target name="main">
        <mkdir dir="build"/>
    </target>
</project>'''
                        )
                    }
                    label('Gant-Skript', cssClass: 'L2')
                    rtextScrollPane(cssClass: 'L3', constraints: 'growx') {
                        rsyntaxTextArea(editable: false,
                                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                                text: '''target(name: "main") {
    ant.mkdir(dir: "build")
}

setDefaultTarget(main)'''
                        )
                    }
                }
            }]).view.root)
        }
    }
}