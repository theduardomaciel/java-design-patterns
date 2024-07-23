package dev.theduardomaciel.javadesignpatterns.spring.service;

import dev.theduardomaciel.javadesignpatterns.spring.handler.BusinessException;
import dev.theduardomaciel.javadesignpatterns.spring.model.Address;
import dev.theduardomaciel.javadesignpatterns.spring.model.Client;
import dev.theduardomaciel.javadesignpatterns.spring.repository.AddressRepository;
import dev.theduardomaciel.javadesignpatterns.spring.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientService implements IClientService {
	private final ClientRepository clientRepository;
	private final AddressRepository addressRepository;
	private final ViaCepService viaCepService;
	
	public ClientService(ClientRepository clientRepository, AddressRepository addressRepository, ViaCepService viaCepService) {
		this.clientRepository = clientRepository;
		this.addressRepository = addressRepository;
		this.viaCepService = viaCepService;
	}
	
	@Override
	public Iterable<Client> searchAll() {
		return clientRepository.findAll();
	}
	
	@Override
	public Client searchById(Long id) {
		return clientRepository.findById(id).orElseThrow(() -> new BusinessException("Cliente não encontrado.", HttpStatus.NOT_FOUND));
	}
	
	private Client saveClientWithCep(Client client) {
		// Verificamos se o endereço do cliente já existe (pelo CEP)
		String clientCep = client.getAddress().getCep();
		
		Address address = addressRepository.findById(clientCep).orElseGet(() -> {
			System.out.println("Endereço não encontrado no banco de dados.");
			
			// Se não existir, realizar integração com a API de CEPs para buscar o endereço
			Address newAddress;
			try {
				newAddress = viaCepService.checkCep(clientCep);
				if (newAddress == null) {
					throw new BusinessException("Não foi possível encontrar o endereço pelo CEP.", HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				throw new BusinessException("Não foi possível encontrar o endereço pelo CEP.", HttpStatus.NOT_FOUND);
			}
			
			System.out.println("Novo endereço encontrado: " + newAddress.toString());
			
			// Salvar o novo endereço no banco de dados
			addressRepository.save(newAddress);
			
			return newAddress;
		});
		
		// Inserimos o cliente, vinculando o endereço (novo ou existente)
		client.setAddress(address);
		clientRepository.save(client);
		
		return client;
	}
	
	@Override
	public Client insert(Client client) {
		return saveClientWithCep(client);
	}
	
	@Override
	public void update(Long id, Client client) {
		// Buscamos o cliente pelo ID, caso exista
		Optional<Client> clientToUpdate = clientRepository.findById(id);
		
		if (clientToUpdate.isPresent()) {
			client.setId(id);
			saveClientWithCep(client);
		} else {
			throw new BusinessException("Cliente não encontrado para atualização.", HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
}
