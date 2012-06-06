
root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
}

root.'griffon.builder.css.CSSBuilder'.view = '*'
root.'griffon.builder.css.CSSBuilder'.controller = ['CSS']

root.'griffon.builder.trident.TridentBuilder'.view = '*'

root.'griffon.builder.jide.JideBuilder'.view = '*'

root.'GlazedlistsGriffonAddon'.addon=true

jx {
    'groovy.swing.SwingXBuilder' {
        view = '*'
    }
}

root.'griffon.builder.gfx.GfxBuilder'.view = '*'
