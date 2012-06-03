log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

    error  'org.codehaus.griffon'

    info   'griffon.util',
           'griffon.core',
           'griffon.swing',
           'griffon.app'
}

presentation {
    screenWidth = 1024
    screenHeight = 768
    template = 'Default'
    subTitles = ['ResourceBundle', 'Commons Configuration', 'Swing Application Framework', null, 'ConfigSlurper', 'ConfigParser', 'I18n-Support', 'Resources']
    order = [
            'Intro',
            'Start',
            'Sascha',
            'Agenda',
            'Java',
            'ResourceBundle',
            'CommonsConfiguration',
            'SAF',
            'Groovy',
            'ConfigSlurper',
            'ConfigParser',
            'Griffon',
            'I18nSupport',
            'Resources',
            'VielenDank'
    ]
}

i18n.provider = 'i18n-support'
i18n.basename = 'messages'
