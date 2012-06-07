def slurper = new ConfigSlurper()
ConfigNode cfg = slurper.parse(new File('i18n.groovy').toURL())

assert cfg.title == 'My Demo Application'

List data = cfg.list.data
Image logo = cfg.image.logo
Color alert = cfg.color.alert

// -----------------------------------------------------

Properties props = new Properties()
new File('i18n.properties').withReader { reader ->
    props.load(reader)
}
def cfg2 = slurper.parse(props)
assert cfg2.list.data == 'cherries, pears, oranges'