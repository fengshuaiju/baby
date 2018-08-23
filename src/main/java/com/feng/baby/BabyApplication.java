package com.feng.baby;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@EnableEurekaClient
@SpringBootApplication
public class BabyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabyApplication.class, args);
	}

	/**
	 * Spring默认使用使用jackson来进行json格式转换，我们只需要使用@Bean注解创建一个ObjectMapperbean，并将JavaTimeModule注册到ObjectMapper中即可，spring会使用该bean创建MappingJackson2HttpMessageConverter进行json格式转换。
	 * @return
	 */
	@Bean(name = "mapperObject")
	public ObjectMapper getObjectMapper() {
		ObjectMapper om = new ObjectMapper();
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
		om.registerModule(javaTimeModule);
		return om;
	}

}


