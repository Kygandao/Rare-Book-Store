package com.company.bookstoreconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BookstoreConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreConfigServiceApplication.class, args);
	}

}
