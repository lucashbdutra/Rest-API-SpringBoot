package com.portfolio.consume.marketconsumer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * DTO =  "Data transfer object"
 * */
@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(title = "API Organizacional de Produtos", version = "3.0.1",
				description = "API que armazena produtos de forma categorizada consumindo irformaçoes de outra API"),
		servers = {
				@Server(url = "http://localhost:8081"), //Url e porta utilizada pela API
		}
)
public class SpringMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMarketApplication.class, args);
	}

}
