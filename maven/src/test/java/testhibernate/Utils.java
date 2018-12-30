package testhibernate;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Utils {
	private static Map<String,String> maptable = new HashMap<>();
	private static Map<String,Map<String,String>> propertytable = new HashMap<>();
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
		Iterator<Element> pro = el.elementIterator("property");
		Map<String,String> p2c = new HashMap<>();
		while(pro.hasNext()){
			Element proc = pro.next();
			String namep = proc.attribute("name").getValue();
			p2c.put(namep, namep);
		}
		propertytable.put(name.getValue(), p2c);
	}
	
	public static void save(Object object) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class class1 = object.getClass();
		String tablename = maptable.get(class1.getName());
		StringBuffer insertbuff = new StringBuffer("insert into");
		insertbuff.append(tablename);
		insertbuff.append(" (");
		StringBuffer valuebuff = new StringBuffer("values (");
		
		Map<String,String> p2c = propertytable.get(class1.getName());
//		for(Entry<String, String> entry: p2c.entrySet()){
//			String key = entry.getKey();
//			String value = entry.getValue();
//		}
		Iterator<Entry<String, String>> pro = p2c.entrySet().iterator();
		while(pro.hasNext()){
			Entry<String, String> next = pro.next();
			String key = next.getKey();
			String value = next.getValue();
			PropertyDescriptor prop = new PropertyDescriptor(key, class1);
			Object values = prop.getWriteMethod().invoke(object);
			if(pro.hasNext()){
				insertbuff.append(value);
				insertbuff.append(",");
				valuebuff.append(values.toString());
				valuebuff.append(",");
			}else{
				insertbuff.append(value);
				insertbuff.append(")");
				valuebuff.append(values.toString());
				valuebuff.append(")");
			}
			insertbuff.append(valuebuff);
			System.err.println(insertbuff.toString());
		}
	}
}
