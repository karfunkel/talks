package fishygames.ui

import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.LookAndFeel
import javax.swing.plaf.ComponentUI
import javax.swing.plaf.PanelUI
import javax.swing.plaf.basic.BasicPanelUI

class FishyPanelUI extends BasicPanelUI {
    private static PanelUI componentUI = new FishyPanelUI()

    static ComponentUI createUI(JComponent c) {
        return componentUI
    }

    @Override
    void installDefaults(JPanel p) {
        super.installDefaults(p)
        LookAndFeel.installProperty(p, "opaque", false);
    }
}
