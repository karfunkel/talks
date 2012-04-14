import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Stats',
        sub: 'Plattform',
        title: 'Projekt-Statistiken sind leicht erreichbar',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Stats.selectedIndex = 0
                    else
                        tab_Stats.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_Stats.selectedIndex = 1
                    else
                        tab_Stats.selectedIndex = 2
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
        tabbedPane(id: 'tab_Stats', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            rtextScrollPane(title: 'version') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL, tabSize: 4, cssClass: 'codeEditor',
                        text: '''% griffon -version

------------------------------------------------------------
  Griffon 0.9.5
------------------------------------------------------------

   Build: 05-Apr-2012 10:01 AM
  Groovy: 1.8.6
     Ant: 1.8.2
   Slf4j: 1.6.4
  Spring: 3.1.0.RELEASE
     JVM: 1.6.0_26 (Sun Microsystems Inc. 20.1-b02)
      OS: Linux 3.0.0-17-generic amd64'''
                )
            }
            rtextScrollPane(title: 'stats') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL, tabSize: 4, cssClass: 'codeEditor',
                        text: '''% griffon stats
...
    +----------------------+-------+-------+
    | Name                 | Files |  LOC  |
    +----------------------+-------+-------+
    | Models               |     1 |     4 |
    | Views                |     1 |    11 |
    | Controllers          |     1 |     5 |
    | Lifecycle            |     5 |     3 |
    | Unit Tests           |     1 |    13 |
    | Integration Tests    |     1 |    15 |
    +----------------------+-------+-------+
    | Totals               |    10 |    51 |
    +----------------------+-------+-------+'''
                )
            }
            widget(title: 'Code-Quality', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('Code-Quality', cssClass: 'L1')
                    label('Codecoverage mit Clover und Cobertura', cssClass: 'L2')
                    label('Codeanalyse mit Findbugs und CodeNarc', cssClass: 'L2')
                    label('Metriken mit GMetrics und JDepend', cssClass: 'L2')
                }
            }]).view.root)
        }
    }
}