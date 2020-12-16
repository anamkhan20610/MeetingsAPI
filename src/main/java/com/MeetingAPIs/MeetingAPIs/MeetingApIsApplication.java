package com.MeetingAPIs.MeetingAPIs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MeetingApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingApIsApplication.class, args);
		Logger logger = LoggerFactory.getLogger(MeetingApIsApplication.class);
	}

}
