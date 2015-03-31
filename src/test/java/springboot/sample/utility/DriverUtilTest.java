package springboot.sample.utility;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Driver;

import org.junit.Test;

import sprintboot.sample.utility.DriverUtil;
import sprintboot.sample.utility.PropertyUtil;

public class DriverUtilTest {

    @Test
    public void getDriver_success() throws IOException,
                                           ClassNotFoundException,
                                           InstantiationException,
                                           IllegalAccessException {

        String clazz  = "oracle.jdbc.driver.OracleDriver";
        String expect = clazz;

        PropertyUtil.init();
        // driver instance is null
        Driver driver = DriverUtil.getDriver(clazz);
        assertEquals(expect, driver.getClass().getName());

        // driver instance is not null
        driver = DriverUtil.getDriver(clazz);
        assertEquals(expect, driver.getClass().getName());
    }
}
