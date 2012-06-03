package resourcemanagement

import groovy.beans.Bindable
import java.awt.Color

class TabSlideModel {
    @Bindable Closure content
    @Bindable int gap
    @Bindable Color backgroundColor
}