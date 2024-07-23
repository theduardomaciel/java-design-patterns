package dev.theduardomaciel.javadesignpatterns.spring.feign;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.Decoder;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.lang.reflect.Type;

public class ViaCepDecoder implements Decoder {
	
	private final ObjectMapper objectMapper;
	
	public ViaCepDecoder() {
		this.objectMapper = Jackson2ObjectMapperBuilder.json().build();
	}
	
	@Override
	public Object decode(Response response, Type type) throws IOException {
		if (response.body() == null) {
			return null;
		}
		
		JsonNode jsonNode = objectMapper.readTree(response.body().asInputStream());
		if (jsonNode.has("erro") && jsonNode.get("erro").asBoolean()) {
			return null;
		}
		
		// Use ObjectMapper to convert the JsonNode to the desired type
		return objectMapper.treeToValue(jsonNode, objectMapper.constructType(type));
	}
}
