assert getMessage("application.title") == "My Demo Application"
assert getMessage("application.title", Locale.GERMAN) == "Meine Demo Anwendung"

try {
    getMessage("unknown.key")
    assert false
} catch (NoSuchMessageException e) {}
assert getMessage("unknown.key", 'No value') == "No value"

List data = getMessage("list.data", null)?.split("\\s*,\\s*")
Image logo = ImageIO.read(new File("imageDir" + getMessage("image.logo")))
Color alert = MyConfigUtilities.parseFont(getMessage("color.alert"))