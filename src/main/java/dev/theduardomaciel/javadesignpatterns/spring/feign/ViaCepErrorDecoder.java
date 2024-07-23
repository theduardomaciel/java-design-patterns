package dev.theduardomaciel.javadesignpatterns.spring.feign;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class ViaCepErrorDecoder implements ErrorDecoder {
	
	@Override
	public Exception decode(String methodKey, Response response) {
		if (response.status() == 404) {
			return new HttpClientErrorException(HttpStatus.NOT_FOUND, "Resource not found");
		}
		return new HttpClientErrorException(HttpStatus.valueOf(response.status()), "General error");
	}
}
