import javax.imageio.ImageIO
import java.awt.Color

title = 'My Demo Application'
confirm.shutdown.message = 'Do you really want to exit?'
confirm.shutdown.title = 'Exit'

menu.File.name = 'File'
menu.File.mnemonic = 'F'

action.Quit.name = 'Quit'
action.Quit.mnemonic = 'Q'
action.Quit.shortcut = 'ctrl Q'
action.Quit.short_description = 'Quit'

list.data = ['cherries', 'pears', 'oranges']
image.logo = ImageIO.read(new File('images/ApplicationLogo.png'))
color.alert = new Color(0xD55500)