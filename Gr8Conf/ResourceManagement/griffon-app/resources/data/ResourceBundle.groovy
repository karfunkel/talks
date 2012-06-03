import java.util.ResourceBundle

Locale.setDefault(Locale.ENGLISH);

ResourceBundle i18n = ResourceBundle.getBundle("i18n");
assert i18n.getProperty("application.title").equals("My Demo Application");

ResourceBundle i18n_de = ResourceBundle.getBundle("i18n", Locale.GERMAN);
assert i18n_de.getProperty("application.title").equals("Meine Demo Anwendung");

List data = Arrays.asList(i18n.getProperty("list.data").split("\\s*,\\s*"))

Image logo = null;
try {
    logo = ImageIO.read(new File("imageDir"+i18n.getProperty("image.logo")));
} catch (IOException e) { /* do something */ }

Color alert = MyConfigUtilities.parseFont(i18n.getProperty("color.alert"));