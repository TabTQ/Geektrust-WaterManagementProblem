package com.example.geektrust;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.mypack.Calculator;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mypack"})
public class Main {
	public static void main(String[] args) throws IOException{
		ConfigurableApplicationContext ctx= SpringApplication.run(Main.class, args[0]);
		Calculator calculator = ctx.getBean("bc",Calculator.class);
		calculator.start(args[0]);
	}
}
