import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Projektsetup',
        sub: 'Plattform',
        title: 'Ein neues Projekt mit einem Kommando erstellen ...',
        slideActions: [
                { revert ->
                    if (revert) {
                        tab_Projektsetup.selectedIndex = 0
                    } else {
                        tab_Projektsetup.selectedIndex = 1
                    }
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
        tabbedPane(id: 'tab_Projektsetup', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            rtextScrollPane(title: 'create-app') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL, tabSize: 4, cssClass: 'codeEditor',
                        text: '''% cd /tmp
[sascha@B1S-N101:/tmp]
% griffon create-app my.pkg.MyProjectName
...
Created Griffon Application at /tmp/MyProjectName
% cd MyProjectName
[sascha@B1S-N101:/tmp/MyProjectName]
% ls -la
insgesamt 20
drwxrwxr-x  8 sascha sascha  146 2012-04-12 18:37 .
drwxrwxrwt 23 root   root   4096 2012-04-12 18:37 ..
-rw-rw-r--  1 sascha sascha  199 2012-04-12 18:37 application.properties
drwxrwxr-x  9 sascha sascha  103 2012-04-09 11:21 griffon-app
-rw-rw-r--  1 sascha sascha 5050 2012-03-27 16:20 griffonw
-rw-rw-r--  1 sascha sascha 2405 2012-03-27 16:20 griffonw.bat
drwxrwxr-x  2 sascha sascha    6 2012-04-12 18:37 lib
drwxrwxr-x  2 sascha sascha    6 2012-04-12 18:37 scripts
drwxrwxr-x  3 sascha sascha   17 2012-04-12 18:37 src
drwxrwxr-x  4 sascha sascha   35 2012-04-12 18:37 test
drwxrwxr-x  2 sascha sascha   65 2012-04-12 18:37 wrapper'''
                )
            }
            rtextScrollPane(title: 'griffon-app') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL, tabSize: 4, cssClass: 'codeEditor',
                        text: '''% ls -la griffon-app
insgesamt 4
drwxrwxr-x 9 sascha sascha  103 2012-04-09 11:21 .
drwxrwxr-x 8 sascha sascha  146 2012-04-12 18:37 ..
drwxrwxr-x 6 sascha sascha  148 2012-04-12 18:37 conf
drwxrwxr-x 3 sascha sascha   15 2012-04-12 18:37 controllers
drwxrwxr-x 2 sascha sascha   32 2012-04-12 18:37 i18n
drwxrwxr-x 2 sascha sascha  110 2012-04-12 18:37 lifecycle
drwxrwxr-x 3 sascha sascha   15 2012-04-12 18:37 models
drwxrwxr-x 2 sascha sascha 4096 2012-04-12 18:37 resources
drwxrwxr-x 3 sascha sascha   15 2012-04-12 18:37 views'''
                )
            }
        }
    }
}