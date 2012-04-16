import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import javax.swing.JTabbedPane

slide(
        id: 'Umgebung',
        sub: 'Plattform',
        slideActions: [
                { revert ->
                    if (revert)
                        tab_Umgebung.selectedIndex = 0
                    else
                        tab_Umgebung.selectedIndex = 1
                },
                { revert ->
                    if (revert)
                        tab_Umgebung.selectedIndex = 1
                    else
                        tab_Umgebung.selectedIndex = 2
                },
                { revert ->
                    if (revert)
                        tab_Umgebung.selectedIndex = 2
                    else
                        tab_Umgebung.selectedIndex = 3
                }
        ],
        title: 'Griffon ist nicht isoliert'
) {
    migLayout(layoutConstraints: 'fill',
            columnConstraints: '30[center, grow, fill]30',
            rowConstraints: '[center, grow, fill]')
    panel(background: color(0xDDFFFFFF), constraints: 'grow') {
        migLayout(layoutConstraints: 'fill, flowy',
                columnConstraints: '[center]',
                rowConstraints: '10[center]10')
        tabbedPane(id: 'tab_Umgebung', tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer', constraints: 'center, grow') {
            widget(title: 'IDE-Integration', buildMVCGroup('agenda', null, [gap: 10, content: {
                panel(content) {
                    label('IDE-Integration', cssClass: 'L1')
                    label('Eclipse STS', cssClass: 'L2')
                    label('Eclipseprojekt durch Script erstellen', cssClass: 'L3')
                    label('Synchronisation durch eclipse-support plugin', cssClass: 'L3')
                    label('IntelliJ IDEA', cssClass: 'L2')
                    label('Projekt durch Script erstellen', cssClass: 'L3')
                    label('Direkt unterstützt', cssClass: 'L3')
                    label('Netbeans', cssClass: 'L2')
                    label('Netbeans-plugin', cssClass: 'L3')
                }
            }]).view.root)
            widget(title: 'UI-Designer', buildMVCGroup('agenda', null, [content: {
                panel(content) {
                    label('UI-Designer', cssClass: 'L1')
                    label('Netbeans Matisse, JFormsDesigner, WindowBuilder ... ', cssClass: 'L2')
                    label('griffon generate-view-script <class> <view-name>', cssClass: 'L3')
                    label('Abeille Forms', cssClass: 'L2')
                    label('abeilleform-builder plugin', cssClass: 'L3')
                }
            }]).view.root)
            widget(title: 'Build-Tools', buildMVCGroup('agenda', null, [gap: 5, content: {
                panel(content) {
                    label('Build-Tools', cssClass: 'L1')
                    label('Apache Ant', cssClass: 'L2')
                    label('griffon integrate-with -ant erstellt build.xml', cssClass: 'L3')
                    label('Gradle', cssClass: 'L2')
                    label('Gradle griffon plugin', cssClass: 'L3')
                    label('griffon integrate-with –gradle erstellt build.gradle', cssClass: 'L3')
                    label('gradle init erstellt Griffonprojekt aus build.gradle', cssClass: 'L3')
                    label('Maven', cssClass: 'L2')
                    label('Noch keine direkte Unterstützung', cssClass: 'L3')
                    label('Griffon-Wrapper', cssClass: 'L2')
                    label('Griffon ohne Installation benutzen', cssClass: 'L3')
                }
            }]).view.root)
            widget(title: 'Sonstiges', buildMVCGroup('agenda', null, [gap: 30, content: {
                panel(content) {
                    label('Sonstiges', cssClass: 'L1')
                    label('Git plugin', cssClass: 'L2')
                    label('griffonsh', cssClass: 'L2')
                    rtextScrollPane(cssClass: 'L2', constraints: 'grow') {
                        rsyntaxTextArea(editable: false,
                                syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL, tabSize: 4, cssClass: 'codeEditor',
                                text: '''% griffonsh
griffon> help
COMMANDS
        griffon:add-proxy
                Adds a proxy configuration
        griffon:app
                Runs the application in standalone mode
        griffon:archetype-info
                Displays information on a Griffon archetype
        griffon:clean
                Cleans a Griffon project
        griffon:clear-dependency-cache
                Removes dependencies from the Ivy cache
        griffon:clear-proxy
                Clears a proxy configuration
        griffon:compile
                Compiles project sources
        griffon:console
                Runs an embedded application in a Groovy console
        griffon:create-command-alias
                Create Griffon command alias
        griffon:create-integration-test
                Creates a new Griffon integration test which loads the whole Griffon environment when run
        griffon:create-mvc
                Creates a new MVC Group
        griffon:create-script
                Creates a Griffon Gant Script
        griffon:create-service
                Creates a new service class
        griffon:create-unit-test
                Creates a new Griffon unit test. A unit test requires that you mock out access to dynamic
                methods, but executes a lot quicker
        griffon:dependency-report
                Produces a dependency report for the current Griffon project
        griffon:doc
                Creates documentation for a Griffon project
        griffon:generate-view-script
                Generates a view script from an existing class
        griffon:install-archetype
                Installs an archetype for the given URL or name and version
        griffon:install-plugin
                Installs a plugin for the given URL or name and version
        griffon:integrate-with
                Generates tool specific files for a Griffon project
        griffon:list-archetype-updates
                Lists all available archetype updates
        griffon:list-archetypes
                Lists all archetypes available in an artifact repository
        griffon:list-plugin-updates
                Lists all available plugin updates that match the project´s configuration
        griffon:list-plugins
                Lists all plugins available in an artifact repository
        griffon:list-repositories
                Lists all configured repositories
        griffon:package
                Packages a Griffon project according to its type
        griffon:package-archetype
                Packages a Griffon archetype
        griffon:package-plugin
                Packages a Griffon archetype
        griffon:plugin-info
                Displays information on a Griffon plugin
        griffon:release
                Publishes a Griffon project according to its type
        griffon:release-archetype
                Publishes a Griffon archetype release
        griffon:release-plugin
                Publishes a Griffon plugin release
        griffon:remove-proxy
                Removes a proxy configuration
        griffon:replace-artifact
        griffon:run-app
                Runs the application in standalone mode
        griffon:run-applet
                Runs the application in applet mode
        griffon:run-webstart
                Runs the application in webstart mode
        griffon:set-proxy
                Sets HTTP proxy configuration for Griffon
        griffon:set-version
                Sets the current application version
        griffon:shell
                Runs an embedded application in a Groovy shell
        griffon:stats
                Generates basic stats for a Griffon project
        griffon:test-app
                Runs the project´s tests
        griffon:uninstall-archetype
                Uninstalls a Griffon application archetype
        griffon:uninstall-plugin
                Uninstalls a Griffon application plugin
        griffon:upgrade
                Upgrades a Griffon application from a previous version of Griffon
        shell:cat
                Displays the content of a file or URL.
        shell:clear
                Clears the console buffer.
        shell:exec
                Executes system processes.
        shell:exit
                Exit the shell
        shell:grep
                Prints lines matching the given pattern.
        shell:head
                Displays the first lines of a file.
        shell:help
                Displays this help or help about a command
        shell:history
                Prints command history.
        shell:info
                Prints system information.
        shell:more
                File pager.
        shell:open
                Opens a file using the platform´s default editor or viewer
        shell:properties
                Prints information on system properties.
        shell:reload-commands
                Reloads the list of available commands
        shell:resolve-dependencies
                Resolves plugin dependencies
        shell:set-property
                Sets or changes the value of a system property.
        shell:settings
                Displays current Griffon settings
        shell:sort
                Writes sorted concatenation of all files to standard output.
        shell:tail
                Displays the last lines of a file.'''
                        )
                    }
                }
            }]).view.root)
        }
    }
}