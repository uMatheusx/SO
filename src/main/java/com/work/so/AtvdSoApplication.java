package com.work.so;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.work.so.service.Escalonador;

@SpringBootApplication
public class AtvdSoApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AtvdSoApplication.class, args);
        
        Escalonador.run();
    }
}
