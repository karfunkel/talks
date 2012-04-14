import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'LegacyCode',
        title: 'Schrittweise Migration möglich',
        sub: 'Migration',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_LegacyCode.selectedIndex = 0
                    else
                        tab_LegacyCode.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_LegacyCode.selectedIndex = 1
                    else
                        tab_LegacyCode.selectedIndex = 2
                },
                { revert ->
                    if (revert)
                        tab_LegacyCode.selectedIndex = 2
                    else
                        tab_LegacyCode.selectedIndex = 3
                },
                { revert ->
                    if (revert)
                        tab_LegacyCode.selectedIndex = 3
                    else
                        tab_LegacyCode.selectedIndex = 4
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
        tabbedPane(id: 'tab_LegacyCode', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'Polyglot', buildMVCGroup('agenda', null, [gap: 5, content: {
                panel(content) {
                    label('Griffon ist mehrsprachig', cssClass: 'L1')
                    label('Out of the box', cssClass: 'L2')
                    label('Groovy', cssClass: 'L3')
                    label('Java', cssClass: 'L3')
                    label('Mittels Plugins', cssClass: 'L2')
                    label('Scala', cssClass: 'L3')
                    label('Clojure', cssClass: 'L3')
                    label('Erlang', cssClass: 'L3')
                    label('Jython (Python)', cssClass: 'L3')
                    label('Mirah (Ruby)', cssClass: 'L3')
                    label('Kotlin', cssClass: 'L3')
                }
            }]).view.root)
            widget(title: 'Java', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('MVC Gruppen nur mit View erstellen', cssClass: 'L1')
                    rtextScrollPane(cssClass: 'L3', constraints: 'grow') {
                        rsyntaxTextArea(editable: false,
                                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                                text: '''mvcGroups {
    'myJavaGroup' {
        view       = 'my.old.pkg.MyOldWindow'
    }
}'''
                        )
                    }
                    label('Fenster/Panel stückweise migrieren', cssClass: 'L2')
                    label('Mit griffon generate-view-script View erstellen', cssClass: 'L1')
                    label('MVC Gruppe in Java erstellen', cssClass: 'L1')
                    rtextScrollPane(cssClass: 'L3', constraints: 'grow') {
                        rsyntaxTextArea(editable: false,
                                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL, tabSize: 4, cssClass: 'codeEditor',
                                text: '''% griffon create-mvc Java -fileType=java'''
                        )
                    }
                }
            }]).view.root)
            rtextScrollPane(title: 'Model') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_JAVA, tabSize: 4, cssClass: 'codeEditorSmall',
                        text: '''package my.pkg;

import org.codehaus.griffon.runtime.core.AbstractGriffonModel;

public class JavaModel extends AbstractGriffonModel {
    // an observable property
    // private String input;

    // public String getInput() {
    //    return input;
    // }

    // public void setInput(String input) {
    //    firePropertyChange("input", this.input, this.input = input);
    // }
}'''
                )
            }
            rtextScrollPane(title: 'View') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_JAVA, tabSize: 4, cssClass: 'codeEditorSmall',
                        text: '''import javax.swing.*;
import java.util.Map;

import griffon.swing.SwingGriffonApplication;
import org.codehaus.griffon.runtime.core.AbstractGriffonView;

public class JavaView extends AbstractGriffonView {
    private JavaController controller;
    private JavaModel model;

    public void setController(JavaController controller) {
        this.controller = controller;
    }

    public void setModel(JavaModel model) {
        this.model = model;
    }

    private JComponent init() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Content Goes Here"), BorderLayout.CENTER);
        return panel;
    }
...
}'''
                )
            }
            rtextScrollPane(title: 'Controller') {
                rsyntaxTextArea(editable: false,
                        syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_JAVA, tabSize: 4, cssClass: 'codeEditorSmall',
                        text: '''package my.pkg;

import java.awt.event.ActionEvent;
import org.codehaus.griffon.runtime.core.AbstractGriffonController;

public class JavaController extends AbstractGriffonController {
    private JavaModel model;
    private JavaView view;

    public void setModel(JavaModel model) {
        this.model = model;
    }

    public void setView(JavaView view) {
        this.view = view;
    }

    // public void action(final ActionEvent e) {
    //     execOutsideUI(new Runnable() {
    //         public void run() {
    //             // action code
    //         }
    //     });
    // }
}'''
                )
            }
        }
    }
}