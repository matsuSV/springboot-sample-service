package sprintboot.sample.utility;

import java.io.IOException;
import java.util.Properties;

public final class PropertyUtil {

	private static String driverPath;
	private static Properties properties;

	private PropertyUtil() {}

	public static void init() throws IOException {
		if( null == properties ) {
			properties = new Properties();
			properties.load(PropertyUtil.class.getResourceAsStream("/connectiontester.properties"));
			driverPath = properties.getProperty("driver.path");
		}
	}

	public static String getDriverPath() {
		return driverPath;
	}
}
