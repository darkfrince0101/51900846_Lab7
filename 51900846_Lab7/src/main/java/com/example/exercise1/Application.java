package com.example.exercise1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner myCommandLineRunner(){
		return new MyCommandLineRunner();
	}

	private static class MyCommandLineRunner implements CommandLineRunner {
		@Override
		public void run(String... args) throws Exception {
			System.out.println("Công nghệ JAVA");
		}
	}
}
