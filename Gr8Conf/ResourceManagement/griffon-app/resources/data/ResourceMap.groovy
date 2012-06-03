import com.dteoh.treasuremap.ResourceMaps;
import org.jdesktop.application.ResourceMap;

ResourceMap rMap, rMap1, rMap2;
rMap = new ResourceMaps(Foo.class).build();
rMap1 = new ResourceMaps(Foo.class).and(Bar.class).withParent(rMap).build();
rMap2 = new ResourceMaps(Foo.class, Locale.GERMAN).build();

rMap.getString("application.title");

//results.found = %d results found
rMap.getString("results.found", 1);

ResourceConverter.register(new MyListStringConverter());
List data = rMap.getObject("list.data", List.class);

Image logo = rMap.getImage("image.logo");

rMap.injectComponent(component);