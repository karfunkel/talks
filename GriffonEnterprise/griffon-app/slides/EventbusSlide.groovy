import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Eventbus',
        sub: 'Architektur',
        title: 'EventDrivenDevelopment frei Haus',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Eventbus.selectedIndex = 0
                    else
                        tab_Eventbus.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_Eventbus.selectedIndex = 1
                    else
                        tab_Eventbus.selectedIndex = 2
                },
                { revert ->
                    if (revert)
                        tab_Eventbus.selectedIndex = 2
                    else
                        tab_Eventbus.selectedIndex = 3
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
        tabbedPane(id: 'tab_Eventbus', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'Nachrichten', buildMVCGroup('agenda', null, [gap: 10, content: {
                panel(content) {
                    label('Griffon nutzt einen zentralen Event-Bus', cssClass: 'L1')
                    label('im Build-System', cssClass: 'L2')
                    label('um den Compile-Prozess zu beeinflussen', cssClass: 'L3')
                    label('um auf create- oder andere Commands zu reagieren', cssClass: 'L3')
                    label('um Trigger für externe System zu ermöglichen', cssClass: 'L3')
                    label('zur Laufzeit', cssClass: 'L2')
                    label('um Aktionen während des Lebenszyklus auszuführen', cssClass: 'L3')
                    label('um die Erzeugung von MVCGruppen zu beeinflussen', cssClass: 'L3')
                    label('um eigene Nachrichten zu versenden/verarbeiten', cssClass: 'L3')
                }
            }]).view.root)
            widget(title: 'Build-Events', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('Events feuern', cssClass: 'L1')
                    rtextScrollPane(cssClass: 'L2', constraints: 'grow') {
                        rsyntaxTextArea(editable: false,
                                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                                text: '''target(name: 'myscript') {
    event("Ping", ["Hallo Welt!"])
}

setDefaultTarget(myscript)
'''
                        )
                    }
                    label('Auf Events horchen', cssClass: 'L1')
                    label('in scripts/_Events.groovy', cssClass: 'L2')
                    rtextScrollPane(cssClass: 'L2', constraints: 'grow') {
                        rsyntaxTextArea(editable: false,
                                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                                text: '''eventPing = { msg ->
    println "Got '${msg}' from ping"
}'''
                        )
                    }
                }
            }]).view.root)
            widget(title: 'Application-Events', buildMVCGroup('agenda', null, [gap: 10, content: {
                panel(content) {
                    label('Events feuern', cssClass: 'L1')
                    rtextScrollPane(cssClass: 'L2', constraints: 'grow') {
                        rsyntaxTextArea(editable: false,
                                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                                text: '''app.event("Ping", ["Hallo Welt!"])'''
                        )
                    }
                    label('Auf Events horchen', cssClass: 'L1')
                    rtextScrollPane(cssClass: 'L2', constraints: 'grow') {
                        rsyntaxTextArea(editable: false,
                                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_GROOVY, tabSize: 4, cssClass: 'codeEditor',
                                text: '''onPing = { app ->
    println "Got '${msg}' from ping"
}'''
                        )
                    }
                    label('Globale Listener: in griffon-app/conf/Events.groovy', cssClass: 'L3')
                    label('Alle public Controller-Methoden mit on<Event>', cssClass: 'L3')
                    label('app.addApplicationEventListener(Object obj)', cssClass: 'L3')
                    label('app.addApplicationEventListener(String name, Closure closure)', cssClass: 'L3')
                }
            }]).view.root)
            widget(title: 'Privater Eventbus', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('@EventPublisher macht jede Klasse zum Bus', cssClass: 'L1')
                    rtextScrollPane(cssClass: 'L2', constraints: 'grow') {
                        rsyntaxTextArea(editable: false,
                                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_JAVA, tabSize: 4, cssClass: 'codeEditor',
                                text: '''public interface EventPublisher {
    void addEventListener(Object listener);
    void addEventListener(String eventName, Closure listener);
    void removeEventListener(Object listener);
    void removeEventListener(String eventName, Closure listener);
    void publishEvent(String eventName);
    void publishEvent(String eventName, List args);
    void publishEventOutsideUI(String eventName);
    void publishEventOutsideUI(String eventName, List args);
    void publishEventAsync(String eventName);
    void publishEventAsync(String eventName, List args);
    boolean isEventPublishingEnabled();
    void setEventPublishingEnabled(boolean enabled);
}'''
                        )
                    }
                }
            }]).view.root)
        }
    }
}