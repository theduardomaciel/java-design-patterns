package dev.theduardomaciel.javadesignpatterns.spring.service;
import dev.theduardomaciel.javadesignpatterns.spring.model.Client;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter múltiplas implementações dessa mesma
 * interface.
 */
public interface IClientService {
	Iterable<Client> searchAll();
	Client searchById(Long id);
	
	Client insert(Client client);
	void update(Long id, Client client);
	void delete(Long id);
}