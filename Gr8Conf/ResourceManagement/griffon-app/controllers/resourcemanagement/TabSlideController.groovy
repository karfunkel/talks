package resourcemanagement

import java.awt.Color

class TabSlideController {
    TabSlideModel model
    TabSlideView view

    void mvcGroupInit(Map args) {
        MVCGroupConfiguration configuration = args.configuration
        model.content = args.content ?: configuration?.config?.content
        model.gap = args.gap ?: configuration?.config?.gap ?: 20
        model.backgroundColor = args.backgroundColor ?: configuration?.config?.backgroundColor ?: new Color(0, 0, 0, 0)
    }
}
