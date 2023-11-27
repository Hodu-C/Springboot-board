package com.melog.melog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MelogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MelogApplication.class, args);
	}

}
