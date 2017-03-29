package com.nme;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class NMEApplication {

	public static void main(String[] args) {
		SpringApplication.run(NMEApplication.class, args);
	}
}


@RestController
class MessageRestController {

	@Value("${message}")
	private String message;

	@RefreshScope
	@RequestMapping("/message")
	String read() {
		return message;
	}
}
