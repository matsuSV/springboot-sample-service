package springboot.sample.restcontroller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import springboot.sample.restcontroller.DataBaseConnectionRestController;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DataBaseConnectionRestController.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class DataBaseConnectionRestControllerTest {

    @Value("${local.server.port}")
    private int port;

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void sendSuccess_and_connectFalse() {
        String url = "http://localhost:" + port + "/connect?clazz&url&user&password";
        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody());
    }
}
