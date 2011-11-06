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
    screenHeight = 800
    fileName = '/tmp/Von_der_Designergrafik_zur_Oberflaeche.pdf'
    template = 'Design'
    subTitles = ['Anforderungen', 'Spurensuche', 'Lückenfüllen', 'Swing', 'Beispiel']
    subTitlesPerRow = 5
    order = [
            "Start",
            "Dominion",
            "BeOne",
            "Gliederung",
            "Anforderungen",
            "Facetten1",
            "Facetten2",
            "Spurensuche",
            "Werkzeug1",
            "Werkzeug2",
            "Werkzeug3",
            "Werkzeug4",
            "FishyGames",
            "Layout",
            "Measurement",
            "Winkel",
            "Pipette",
            "Pipette2",
            "Fonts",
            "Bilder",
            "BildOderRendern",
            "Skalierung1",
            "Skalierung2",
            "NeunFeldSkalierung1",
            "NeunFeldSkalierung2",
            "NeunFeldSkalierung3",
            "NeunFeldSkalierungCode",
            "Lueckenfuellen",
            "Groessen",
            "Status",
            "FontsVorhanden",
            "Lizenzen",
            "Swing",
            "Java2D",
            "SwingMVC",
            "LaF",
            "UIManager",
            "UIDelegate",
            "Skinnable",
            "Beispiel",
            "VorherNachher",
            "Beispiel1",
            "GlowEffect",
            "BaseLaF",
            "BeispielHintergrund",
            "BeispielHintergrund1",
            "BeispielHintergrund2",
            "BeispielPanel",
            "BeispielButton",
            "BeispielButton1",
            "BeispielNimbus",
            "BeispielNimbus2",
            "BeispielPainter",
            "BeispielPainter1",
            "BeispielPainter2",
            "BeispielPainter3",
            "BeispielPainter4",
            "BeispielPainter5",
            "Download",
            "VielenDank"
    ]
}
lookandfeel.lookAndFeel = 'System'
lookandfeel.theme = 'Nimbus'
