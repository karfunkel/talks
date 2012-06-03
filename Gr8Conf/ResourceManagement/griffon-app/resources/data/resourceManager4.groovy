// ConfigSlurper-based resource-file
injections {
    property1 = { 'Test' }
    property2 = '2'
    property3.sub1 = 'Value3'
    url = 'http://www.google.de'
}

// Types will be converted to the property type with PropertyEditors
// custom PropertyEditors possible:
ResourceManager.registerEditor(Class cls, PropertyEditor editor)

// Call of inject e.g. in a Controller
def a = new A()
rm.inject(a, 'injections')
assert a.property1() == 'Test'
assert a.property2 == 2
assert a.property3.sub1 == 'Value3'
assert a.url == new URL('http://www.google.de')