package com.mspifarre.curriculum_ws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mspifarre.curriculum_ws.Configuration.InitParams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CurriculumWsApplication {

	public static InitParams initParams;

	public static void main(String[] args) throws JsonProcessingException {


		ObjectMapper mapper = new ObjectMapper();
		initParams = mapper.readValue(args[0], InitParams.class);
		SpringApplication.run(CurriculumWsApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}


