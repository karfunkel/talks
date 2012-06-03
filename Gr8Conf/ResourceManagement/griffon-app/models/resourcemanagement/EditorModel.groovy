package resourcemanagement

import groovy.beans.Bindable

class EditorModel {
    @Bindable String text
    @Bindable boolean editable
    @Bindable String syntax
    @Bindable int tabSize
    @Bindable String cssClass
}