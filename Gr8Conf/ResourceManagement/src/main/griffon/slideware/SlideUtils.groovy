package griffon.slideware

import javax.swing.JTabbedPane
import griffon.plugins.slideware.Slide

class SlideUtils {
    static void createDefaultSlideAction(JTabbedPane tab, Slide slide) {
        slide.slideActions = createDefaultSlideAction(tab, [])
    }

    static List createDefaultSlideAction(JTabbedPane tab, List slideActions) {
        if (tab.componentCount > 1) {
            (tab.componentCount - 1).times {
                slideActions << { revert ->
                    tab.selectedIndex = revert ? it : it + 1
                }
            }
        }
        return slideActions
    }
}
