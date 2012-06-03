package griffonenterprise

import java.awt.Color

class AgendaController {
    // these will be injected by Griffon
    AgendaModel model
    AgendaView view

    void mvcGroupInit(Map args) {
        //Map x = ConfigUtils.getMergedArguments(args)
        MVCGroupConfiguration configuration = args.configuration
        model.content = args.content ?: configuration?.config?.content
        model.gap = args.gap ?: configuration?.config?.gap ?: 20
        model.borderThickness = args.borderThickness ?: configuration?.config?.borderThickness ?: 0
        model.borderColor = args.borderColor ?: configuration?.config?.borderColor ?: Color.BLACK
        model.backgroundColor = args.backgroundColor ?: configuration?.config?.backgroundColor ?: new Color(0, 0, 0, 0)
    }
}


