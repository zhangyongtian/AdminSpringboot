package com.zhang.biyeseji.remeberme;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhang.biyeseji.remeberme.mapper")
public class RemebermeApplication {
	public static void main(String[] args) {
		SpringApplication.run(RemebermeApplication.class, args);
	}
}
