package properties;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesUpload {
	static Properties prop= new Properties(); 

	public static String getPropertiesValuesByKey(String key) throws Exception {
		String filePath=System.getProperty("user.dir")+"/src/main/resources/config.properties";

		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		String value=prop.get(key).toString();
		if (StringUtils.isEmpty(value)) {
			throw new Exception ("could not find "+key +" in the properties file");
		} 

		return value ;
	}
 /*
	public static void main(String[] args) throws Exception {
		System.out.println(PropertiesUpload.getPropertiesValuesByKey("Browser"));
		System.out.println(PropertiesUpload.getPropertiesValuesByKey("URL"));
	}
	*/
}
