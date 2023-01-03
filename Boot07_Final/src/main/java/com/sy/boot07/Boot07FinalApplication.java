package com.sy.boot07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:custom.properties") //resources/custom.propeties 로딩하기
@SpringBootApplication
public class Boot07FinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot07FinalApplication.class, args);
	}

}
