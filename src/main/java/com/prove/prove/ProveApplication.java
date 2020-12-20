package com.prove.prove;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ProveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProveApplication.class, args);
	}

	@RestController
	public class MessagingRestService {

		@GetMapping(path = "/user/message")
		public String getUserMessage() {


			return "Hello, User";
		}
	}
}
