package dev.theduardomaciel.javadesignpatterns.spring.service;

import dev.theduardomaciel.javadesignpatterns.spring.feign.FeignConfig;
import dev.theduardomaciel.javadesignpatterns.spring.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Client HTTP, criado via <b>OpenFeign</b>, para o consumo da API do
 * <b>ViaCEP</b>.
 *
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws", configuration = FeignConfig.class)
public interface ViaCepService {
	@GetMapping("/{cep}/json/")
	Address checkCep(@PathVariable("cep") String cep);
}