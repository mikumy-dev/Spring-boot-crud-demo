package com.example.demo;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController 
@EnableAutoConfiguration
public class HelloController {

	@PostMapping("/hello")
	@ResponseBody
	public String index() {
		return "hello";
	}
	public static void main(String[] args) {
	//	SpringApplication.run(DemoApplication.class, args);
		Tomcat t = new Tomcat();
		t.setPort(8080);
		try {
			t.stop();
		} catch (LifecycleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
