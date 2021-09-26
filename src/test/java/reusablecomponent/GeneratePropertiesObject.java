package reusablecomponent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GeneratePropertiesObject 
{
	public static Properties generatePropObject() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(".\\config.properties");
		prop.load(fis);
		return prop;
	}

}
