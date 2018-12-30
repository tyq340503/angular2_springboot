package testhibernate;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Utils {
	private static Map<String,String> maptable = new HashMap<>();
	public static void parsexml() throws Exception{
		SAXReader reader = new SAXReader();
		String root = System.getProperty("user.dir");
		String filePath = root + File.separator + "src/test/java/testhibernate" + File.separator
				+ "User.hbm.xml";
		Document doc = reader.read(filePath);
		Element el = doc.getRootElement();
		Attribute name = el.attribute("name");
		Attribute table = el.attribute("table");
		maptable.put(name.getValue(), table.getValue());
	}
}
