package springboot.sample.restcontroller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.sample.service.Connector;

@RestController
@EnableAutoConfiguration
public class DataBaseConnectionRestController {

	@RequestMapping(value = "/connect", method = RequestMethod.GET)
	@ResponseBody
	public boolean send(@RequestParam("clazz")    String clazz,
						@RequestParam("url")      String url,
						@RequestParam("user")     String user,
						@RequestParam("password") String password) {

		return Connector.verify(clazz, url, user, password);
	}

	public static void main(String[] args) {
		SpringApplication.run(DataBaseConnectionRestController.class, args);
	}
}
