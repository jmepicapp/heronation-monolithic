package com.hackathlon.heronation;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "30s")
public class HeronationApplication{

	public static void main(String[] args) {
		SpringApplication.run(HeronationApplication.class, args);
	}
//
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

//	public void run(String... args) throws Exception {
//		String password = "12345";
//
//		for (int i = 0; i < 5; i++){
//			String passwordBcrypt = passwordEncoder.encode(password);
//			System.out.println(passwordBcrypt);
//		}
//	}
}
