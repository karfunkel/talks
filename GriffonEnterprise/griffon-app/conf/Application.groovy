
application {
    title = 'GriffonEnterprise'
    startupGroups = ['DeckLauncher']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true
}
mvcGroups {
    // MVC Group for "agenda"
    'agenda' {
        model      = 'griffonenterprise.AgendaModel'
        controller = 'griffonenterprise.AgendaController'
        view       = 'griffonenterprise.AgendaView'
        config {
            component = true
        }
    }

    'media' {
        model      = 'griffonenterprise.DialogModel'
        controller = 'griffonenterprise.DialogController'
        view       = 'griffonenterprise.DialogView'
        config {
            component = true
            format = 'dd.MM.yyyy'
        }
    }
}
