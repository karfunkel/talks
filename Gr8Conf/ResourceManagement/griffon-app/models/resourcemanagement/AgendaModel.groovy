package resourcemanagement

import groovy.beans.Bindable
import java.awt.Color

class AgendaModel {
    @Bindable Closure content
    @Bindable int gap
    @Bindable int borderThickness
    @Bindable Color borderColor
    @Bindable Color backgroundColor
}