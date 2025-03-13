package com.adrar.hello;

import com.adrar.hello.controller.LivreController;
import com.adrar.hello.service.HelloWorldService;
import com.adrar.hello.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class HelloApplication implements CommandLineRunner {

	@Autowired
	private HelloWorldService helloworldService;

	@Autowired
	private LivreController livreController;

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(helloworldService.getHelloWorld());

		livreController.router();
	}
}