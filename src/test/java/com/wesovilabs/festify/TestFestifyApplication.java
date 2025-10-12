package com.wesovilabs.festify;

import org.springframework.boot.SpringApplication;

public class TestFestifyApplication {

	public static void main(String[] args) {
		SpringApplication.from(FestifyApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
