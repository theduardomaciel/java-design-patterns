package dev.theduardomaciel.javadesignpatterns.gof.facade;

// Subsistema A
class ClientService {
	private ClientService() {
		super();
	}
	
	public static void saveClient(String name, String address) {
		System.out.println("Cliente " + name + " salvo no Sistema de Cadastro com sucesso!");
		System.out.println("Endereço: " + address);
	}
}

class CepApi {
	private static CepApi instance = new CepApi();
	
	private CepApi() {
		super();
	}
	
	public static CepApi getInstance() {
		return instance;
	}
	
	public String getAddressByCep(String cep) {
		return "Rua dos Bobos, nº 0";
	}
}

public class Facade {
	public void migrateClient(String name, String cep) {
		String address = CepApi.getInstance().getAddressByCep(cep);
		ClientService.saveClient(name, address);
	}
}