package com.derteuffel;

import com.derteuffel.controller.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class ProjetPolytechApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetPolytechApplication.class, args);
	}

}

