log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

    error 'org.codehaus.griffon'

    info 'griffon.util',
            'griffon.core',
            'griffon.swing',
            'griffon.app'
}


presentation {
    screenWidth = 1280
    screenHeight = 768
    printRatio = 1.0f
    fileName = '/tmp/Griffon_Enterprise.pdf'
    subTitles = ['Plattform', 'Architektur', 'Migration', 'Integration', 'Einarbeitung']
    subTitlesPerRow = 5
    template = 'Default'
    order = [
            'Intro',
            'Money',
            'BeOne',
            'Agenda',
            'Entwicklung',
            'Projektsetup',
            'Buildsystem',
            'Testsystem',
            'Stats',
            'CreateMVC',
            'Scripts',
            'I18n',
            'Resources',
            'Logging',
            'Umgebung',
            'ReleaseCycle',
            'Entwicklung2',
            'Eventbus',
            'SoC',
            'MVC',
            'MetaComponents',
            'Artifacts',
            'Archetypes',
            'Plugins',
            'PluginHandling',
            'XCutting',
            'Dependency',
            'Mistakes',
            'Migration',
            'LegacyCode',
            'UIToolkits',
            'Integration',
            'Environment',
            'Einarbeitung',
            'Support',
            'Fazit',
            'VielenDank',
    ]
}

i18n.basename = 'messages'
i18n.basenames = ['messages']
i18n.provider = 'i18n-support'


