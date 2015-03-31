package springboot.sample.service;

import static org.junit.Assert.*;

import java.util.Properties;

import mockit.Mocked;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import springboot.sample.service.Connector;
import sprintboot.sample.utility.DriverUtil;

@RunWith(MockitoJUnitRunner.class)
public class ConnectorTest {

    @Mock
    private DriverUtil driver;

    @Mock
    private Properties info;

    @Spy
    private DriverUtil spyDriverUtil;

    @InjectMocks
    private Connector injectMocksConnector;

    @Mocked
    private DriverUtil dd;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verify_ClassNotFoundException() throws Exception {


//        Mockito.when(driver.getDriver("oracle.jdbc.driver.OracleDriver")).thenThrow(new ClassNotFoundException());
//        Mockito.when(mockDriverUtil.getDriver("oracle.jdbc.driver.OracleDriver")).thenReturn(null);

//        Mockito.when(info.put("key", "value")).thenThrow(new OutOfMemoryError());
//        Mockito.doThrow(new ClassNotFoundException()).when(spyDriverUtil).getDriver("oracle.jdbc.driver.OracleDriver");
//        Mockito.doThrow(new ClassNotFoundException()).when(info).put("","");

        // モックの設定 InstantiationExceptionを返す
//        new Expectations() {{
//            dd.getDriver("oracle.jdbc.driver.OracleDriver");
//            result = new InstantiationException();
//        }};

//        new Expectations() {
//            @Mocked
//            DriverUtil driver;
//            {
//                DriverUtil.getDriver("oracle.jdbc.driver.OracleDriver");
//                result = new InstantiationException();
//            }
//        };
//        assertFalse(injectMocksConnector.verify("", "", "", ""));

      assertFalse(Connector.verify("", "", "", ""));

    }
}
