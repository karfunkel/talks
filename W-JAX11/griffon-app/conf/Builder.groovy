






root.'griffon.builder.css.CSSBuilder'.view = '*'
root.'griffon.builder.css.CSSBuilder'.controller = ['CSS']

root.'griffon.builder.gfx.GfxBuilder'.view = '*'

root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
}

root.'GlazedlistsGriffonAddon'.addon=true

jx {
    'groovy.swing.SwingXBuilder' {
        view = '*'
    }
}

root.'griffon.builder.jide.JideBuilder'.view = '*'

root.'griffon.builder.trident.TridentBuilder'.view = '*'

root.'SlidewareGriffonAddon'.addon=true
