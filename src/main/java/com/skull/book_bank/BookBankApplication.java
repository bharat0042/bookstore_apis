package com.skull.book_bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class BookBankApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookBankApplication.class, args);
	}
}
