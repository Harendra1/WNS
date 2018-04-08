package com.wns.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.wns.atm.entity.CashStatus;

@SpringBootApplication
public class CashManApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashManApplication.class, args);

	}

}
