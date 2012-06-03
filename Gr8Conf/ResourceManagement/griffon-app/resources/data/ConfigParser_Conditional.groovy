ConfigParser parser = new ConfigParser(environments: 'test', debug: true)
parser.registerConditionalBlock('environments', ['test', 'dev', 'prod'])
parser.registerConditionalBlock('debug')
ConfigNode node = parser.parse('''
key1 = 123
environments {
    test {
        key1 = 456
    }
    dev {
        key1 = 789
    }
}
key2 = 123
debug {
    key2 = 456
} ''')
assert node.key1 == 456
assert node.key2 == 456