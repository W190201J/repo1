package com.newer.deliver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.newer.deliver.mapper")
public class SuperDeliverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperDeliverApplication.class, args);
	}

}
