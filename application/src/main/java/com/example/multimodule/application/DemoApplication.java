package com.example.multimodule.application;

import com.example.multimodule.command.BotBootstrap;
import com.example.multimodule.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Import(BotBootstrap.class)
@RestController
public class DemoApplication {

//	private final MyService myService;

//	public DemoApplication(MyService myService) {
//		this.myService = myService;
//	}

//	public DemoApplication(){}

	@GetMapping("/")
	public String home() {
		return "Hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
