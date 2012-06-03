ConfigParser parser = new ConfigParser()
ConfigNode node = parser.parse '''
person('Sascha') {
    permissions = 'all'
}
'''

assert node.person instanceof ConfigNodeProxy
assert node.person == 'Sascha'
assert 'Sascha' != node.person // !!! Attention
assert 'Sascha' == node.person.$

assert node.person.permissions == 'all'
assert 'all' == node.person.permissions