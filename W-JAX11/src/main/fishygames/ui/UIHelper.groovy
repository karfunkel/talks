package fishygames.ui

import java.awt.Component
import javax.swing.JComponent
import javax.swing.UIDefaults

class UIHelper {
    static void overrideDelegates(UIDefaults overrides, def c) {
        if (c instanceof JComponent) {
            c.putClientProperty("Nimbus.Overrides", overrides)
            c.putClientProperty("Nimbus.Overrides.InheritDefaults", true)
        }
        for (Component comp: c.components) {
            overrideDelegates(overrides, comp)
        }
    }
}
