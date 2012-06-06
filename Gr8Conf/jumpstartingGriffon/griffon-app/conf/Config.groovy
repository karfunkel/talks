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


presentation {        // <-- Fix for archetype
    screenWidth = 1024
    screenHeight = 768
    template = 'Default'
    order = [
            'Intro',
            'Infos'
    ]
}

i18n.provider = 'i18n-support'
i18n.basename = 'messages'
