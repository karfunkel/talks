def slurper = new ConfigSlurper()
slurper.binding=[image: {String image -> ImageIO.read(new File("images/$image"))}]
slurper.parse "image.logo = image.call('ApplicationLogo.png')"

// -------------------------------------------------------------------------------
def root = slurper.parse '''
color.alert = new Color(0x005500)
environments {
    asia {
        color.alert = new Color(0x000055)
    }
}
list {
    data = ['cherries', 'pears', 'oranges']
}
'''
assert root.color.alert == new Color(0x000055)
assert root.list.data == ['cherries', 'pears', 'oranges']