package br.com.strfelix.finora_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class FinoraSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinoraSpringApplication.class, args);
	}

}
