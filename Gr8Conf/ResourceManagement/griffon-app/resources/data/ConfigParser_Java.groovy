ConfigParser parser = new ConfigParser()
ConfigNode node = parser.parse '''
a.b.c = 'Test'
'''

assert node.getRecursive('a.b.c') == 'Test'

node.putRecursive('a.b.c', 123)
assert node.getRecursive('a.b.c') == 123

node.removeRecursive('a.b.c')
assert node.getRecursive('a.b.c') == null