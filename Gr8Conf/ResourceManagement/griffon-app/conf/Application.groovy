
application {
    title = 'ResourceManagement'
    startupGroups = ['DeckLauncher']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true
}
mvcGroups {
    // MVC Group for "tabSlide"
    'tabSlide' {
        model      = 'resourcemanagement.TabSlideModel'
        view       = 'resourcemanagement.TabSlideView'
        controller = 'resourcemanagement.TabSlideController'
        config {
            component = true
        }
    }

    // MVC Group for "editor"
    'editor' {
        model      = 'resourcemanagement.EditorModel'
        view       = 'resourcemanagement.EditorView'
        controller = 'resourcemanagement.EditorController'
        config {
            component = true
        }
    }

    'agenda' {
        model      = 'resourcemanagement.AgendaModel'
        controller = 'resourcemanagement.AgendaController'
        view       = 'resourcemanagement.AgendaView'
        config {
            component = true
        }
    }

    'media' {
        model      = 'resourcemanagement.DialogModel'
        controller = 'resourcemanagement.DialogController'
        view       = 'resourcemanagement.DialogView'
        config {
            component = true
            format = 'dd.MM.yyyy'
        }
    }
}
