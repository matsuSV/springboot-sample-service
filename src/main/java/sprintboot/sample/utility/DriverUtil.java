package sprintboot.sample.utility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class DriverUtil {

	private static Driver driver;

	private DriverUtil() {}

	/**
	 * Driverインスタンスを取得する
	 *
	 * @param clazz
	 * @return ドライバインスタンス
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public static Driver getDriver(String clazz) throws ClassNotFoundException,
	                                                    InstantiationException,
	                                                    IllegalAccessException,
	                                                    IOException {

		PropertyUtil.init();

		if( null == driver ) {
			String[] drivers = PropertyUtil.getDriverPath().split("#");

			List<URL> urls = new ArrayList<URL>();
			for (String driver : drivers) {
				String path = new File(driver).getAbsolutePath();
				URL url     = new File(path).toURI().toURL();
				urls.add(url);
			}
			URLClassLoader loader = URLClassLoader.newInstance(urls.toArray(new URL[urls.size()]));

			@SuppressWarnings("unchecked")
			Class<Driver> cd = (Class<Driver>) loader.loadClass(clazz);

			driver = cd.newInstance();
		}
		return driver;
	}
}
