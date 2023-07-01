package com.sungbaek.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sungbaek.cardatabase.domain.Car;
import com.sungbaek.cardatabase.domain.CarRepository;
import com.sungbaek.cardatabase.domain.Owner;
import com.sungbaek.cardatabase.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	// 로깅 수준에는 TRACE, DEBUG, INFO, WARN, ERROR, FATAL, OFF의 7가지가 있다.
	// 로깅 수준은 application.properties 파일에서 구성할 수 있다.
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository orepository;
	
	public static void main(String[] args) {
		
		// 이 주석을 추가하면 애플리케이션이 재시작됨
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {
		// 소유자 객체를 추가하고 데이터베이스에 저장
		Owner owner1 = new Owner("John", "Joshnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		orepository.saveAll(Arrays.asList(owner1, owner2));
		
		// 자동차 객체를 추가하고 소유자와 연결한 후 데이터베이스에 저장
		Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1);
		Car car2 = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2);
		Car car3 = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner2);
		repository.saveAll(Arrays.asList(car1, car2, car3));
		
		// 모든 자동차를 가져와 콘솔에 로깅
		for(Car car: repository.findAll()) {
			logger.info(car.getBrand()+" "+car.getModel());
		}
		
	}

}
