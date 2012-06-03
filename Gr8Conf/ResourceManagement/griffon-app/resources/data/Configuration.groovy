ConfigurationFactory factory = new ConfigurationFactory("config.xml");
Configuration cfg = factory.getConfiguration();
// or
String lang = Locale.getDefault().getLanguage()
CompositeConfiguration cfg = new CompositeConfiguration();
cfg.addConfiguration(new SystemConfiguration());
cfg.addConfiguration(new PropertiesConfiguration(loc+"/i18n.properties"));
cfg.addConfiguration(new PropertiesConfiguration(loc+"/i18n_custom.properties"));
File userConfig = new File(System.getProperty("user.home")+"/.myApp/user.xml");
if(userConfig.exists())
    cfg.addConfiguration(new XMLConfiguration(userConfig));

cfg.getString("application.title")
cfg.getString("application.title", "default value")

List data = cfg.getList("list.data")
Image logo = null;
try {
    logo = ImageIO.read(new File("imageDir"+cfg.getString("image.logo")));
} catch (IOException e) { /* do something */ }