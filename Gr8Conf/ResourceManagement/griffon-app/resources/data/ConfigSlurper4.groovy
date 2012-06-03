def cfg = slurper.parse '''
key1 = 123
key2 = 456
'''
def cfg2 = slurper.parse '''
key1 = 456
key2 = 456
key3 = 456
'''
def merged = cfg.merge(cfg2)
assert merged.key1 == 456
assert merged.key2 == 456
assert merged.key3 == 456

def cfg = slurper.parse '''
a {
    b = 456
}'''
assert cfg.flatten().'a.b' == 456