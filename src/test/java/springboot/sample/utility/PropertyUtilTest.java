package springboot.sample.utility;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import sprintboot.sample.utility.PropertyUtil;

public class PropertyUtilTest {

	@Test
	public void init_get_properties_instance() throws IOException {

	    String expect = "./driver/oracle/11_2_0_3_0/ojdbc6.jar#./driver/11_2_0_3_0/orai18n.jar";

	    // properties instance is null
		PropertyUtil.init();
		assertEquals(expect, PropertyUtil.getDriverPath());

		// properties instance is not null
	    PropertyUtil.init();
	    assertEquals(expect, PropertyUtil.getDriverPath());
	}
}
