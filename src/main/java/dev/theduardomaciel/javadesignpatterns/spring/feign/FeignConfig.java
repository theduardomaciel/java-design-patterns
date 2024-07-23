package dev.theduardomaciel.javadesignpatterns.spring.feign;

import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
	
	@Bean
	public ErrorDecoder errorDecoder() {
		return new ViaCepErrorDecoder();
	}
	
	@Bean
	public Decoder decoder() {
		return new ViaCepDecoder();
	}
}
