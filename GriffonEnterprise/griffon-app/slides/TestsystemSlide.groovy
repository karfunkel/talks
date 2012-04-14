import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Testsystem',
        title: 'Ein Testsystem ist integraler Bestandteil von Griffon',
        sub: 'Plattform',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Testsystem.selectedIndex = 0
                    else
                        tab_Testsystem.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_Testsystem.selectedIndex = 1
                    else
                        tab_Testsystem.selectedIndex = 2
                },
                { revert ->
                    if (revert)
                        tab_Testsystem.selectedIndex = 2
                    else
                        tab_Testsystem.selectedIndex = 3
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
        tabbedPane(id: 'tab_Testsystem', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            rtextScrollPane(title: 'create-unit-test') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL, tabSize: 4, cssClass: 'codeEditor',
                        text: '''% griffon create-unit-test Sample
...
[mkdir] Created dir: /tmp/MyProjectName/test/unit/my/pkg
Created Tests for Sample
% ls -la /tmp/MyProjectName/test/unit/my/pkg/
insgesamt 4
drwxrwxr-x 2 sascha sascha  31 2012-04-12 21:48 .
drwxrwxr-x 3 sascha sascha  16 2012-04-12 21:48 ..
-rw-rw-r-- 1 sascha sascha 277 2012-04-12 21:48 SampleTests.groovy'''
                )
            }
            rtextScrollPane(title: 'Unit-Test') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''package my.pkg

import griffon.test.*

class SampleTests extends GriffonUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSomething() {
        fail('Not implemented!')
    }
}'''
                )
            }
            rtextScrollPane(title: 'Integration-Test') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                        text: '''package my.pkg

import griffon.core.GriffonApplication
import griffon.test.*

class MyProjectNameTests extends GriffonUnitTestCase {
    GriffonApplication app

    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSomething() {
        fail('Not implemented!')
    }
}'''
                )
            }
            widget(title: 'Frameworks', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('Unterstützte Frameworks', cssClass: 'L1')
                    label('JUnit', cssClass: 'L2')
                    label('spock', cssClass: 'L2')
                    label('easyb', cssClass: 'L2')
                    label('FEST', cssClass: 'L2')
                    label('UISpec4J', cssClass: 'L2')
                }
            }]).view.root)
        }
    }
}