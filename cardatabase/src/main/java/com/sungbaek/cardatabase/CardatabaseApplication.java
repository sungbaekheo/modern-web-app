package com.sungbaek.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardatabaseApplication {
	// 로깅 수준에는 TRACE, DEBUG, INFO, WARN, ERROR, FATAL, OFF의 7가지가 있다.
	// 로깅 수준은 application.properties 파일에서 구성할 수 있다.
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	public static void main(String[] args) {
		
		// 이 주석을 추가하면 애플리케이션이 재시작됨
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}

}
