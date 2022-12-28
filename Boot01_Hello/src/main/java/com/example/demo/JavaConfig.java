package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 어떤 객체를 spring이 생성해서 관리할지 설정( bean 설정 )
 */
@Configuration
public class JavaConfig {

	//이 메소드에서 리턴하는 객체를 spring이 관리하는 bean 이 되도록 한다.
	//아래의 메소드는 xml 문서에서 <Bean id="myCar" class="com.example.demo.Car" /> 와 같다.
	@Bean
	public Car myCar() { // method의 이름이 bean의 이름 역할을 한다.
		System.out.println("myCar 메소드 호출됨");
		Car c1=new Car();
		return c1;
	}
}
