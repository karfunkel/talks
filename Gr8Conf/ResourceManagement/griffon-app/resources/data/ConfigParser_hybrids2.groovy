ConfigParser parser = new ConfigParser()
ConfigNode node = parser.parse '''
a.b.c = 'Test1'
a.b = 'Test2'
x.y = 'Test3'
x.y.z = 'Test4' // needs: parser.configuration.resultEnhancementEnabled = true
x.y {
    w = 'Test5'
}
'''

assert node.a.b instanceof ConfigNodeProxy
// with parser.configuration.resultEnhancementEnabled = true

assert node.a.b.metaClass instanceof EnhancementMetaClass
// reset resultEnhancementEnabled after parsing to prevent metaClass problems