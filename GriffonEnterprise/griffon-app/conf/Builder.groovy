
root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
}





jx {
    'groovy.swing.SwingXBuilder' {
        view = '*'
    }
}










root.'griffon.builder.gfx.GfxBuilder'.view = '*'

root.'griffon.builder.trident.TridentBuilder'.view = '*'

root.'griffon.builder.jide.JideBuilder'.view = '*'

root.'griffon.builder.css.CSSBuilder'.view = '*'
root.'griffon.builder.css.CSSBuilder'.controller = ['CSS']

root.'GlazedlistsGriffonAddon'.addon=true



root.'SlidewareGriffonAddon'.addon=true
