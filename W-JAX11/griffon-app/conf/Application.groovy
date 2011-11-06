application {
    title = 'W-JAX 2011 - Von der Designergrafik zur Oberfläche'
    startupGroups = ['DeckLauncher']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "w-JAX11"
    'fishyGames' {
        model      = 'fishygames.FishyGamesModel'
        view       = 'fishygames.FishyGamesView'
        controller = 'fishygames.FishyGamesController'
    }
}
