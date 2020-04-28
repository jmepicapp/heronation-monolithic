package com.hackathlon.heronation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "30s")
public class HeronationApplication{

	public static void main(String[] args) {
		SpringApplication.run(HeronationApplication.class, args);
	}

}
