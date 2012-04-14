import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane
import griffon.plugins.slideware.ImagePanel

slide(
        id: 'Buildsystem',
        sub: 'Plattform',
        title: '... genauso wie es bauen und starten',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Buildsystem.selectedIndex = 0
                    else
                        tab_Buildsystem.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_Buildsystem.selectedIndex = 1
                    else
                        tab_Buildsystem.selectedIndex = 2
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
        tabbedPane(id: 'tab_Buildsystem', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            rtextScrollPane(title: 'compile') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL, tabSize: 4, cssClass: 'codeEditor',
                        text: '''[sascha@B1S-N101:/tmp/MyProjectName]
% griffon compile
...
 [griffonc] Compiling 8 source files to /home/sascha/.griffon/0.9.5/projects/MyProjectName/classes/main
 [griffonc] Compiling 4 source files to /home/sascha/.griffon/0.9.5/projects/MyProjectName/classes/main

% griffon run-app

% griffon run-applet

% griffon run-webstart'''
                )
            }
            widget(new ImagePanel(), title: 'Application', imagePath: 'Project.png')
            rtextScrollPane(title: 'package') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL, tabSize: 4, cssClass: 'codeEditor',
                        text: '''% griffon package
...
  [signjar] Signing JAR: /tmp/MyProjectName/staging/groovy-all-1.8.6.jar to /tmp/MyProjectName/staging/groovy-all-1.8.6.jar as production
...
[sascha@B1S-N101:/tmp/MyProjectName]
% ls -la dist
insgesamt 16
drwxrwxr-x  6 sascha sascha   54 2012-04-13 09:13 .
drwxrwxr-x 10 sascha sascha 4096 2012-04-12 22:36 ..
drwxrwxr-x  5 sascha sascha 4096 2012-04-13 09:13 applet
drwxrwxr-x  2 sascha sascha 4096 2012-04-13 09:13 jar
drwxrwxr-x  5 sascha sascha 4096 2012-04-13 09:13 webstart
drwxrwxr-x  4 sascha sascha   98 2012-04-13 09:10 zip'''
                )
            }
        }
    }
}