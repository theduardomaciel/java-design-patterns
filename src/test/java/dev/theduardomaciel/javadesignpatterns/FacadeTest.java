package dev.theduardomaciel.javadesignpatterns;

import dev.theduardomaciel.javadesignpatterns.gof.facade.Facade;
import org.junit.jupiter.api.Test;

public class FacadeTest {
	@Test
	public void test() {
		Facade facade = new Facade();
		facade.migrateClient("João da Silva", "12345-678");
		
		// Output:
		// Cliente João da Silva salvo no Sistema de Cadastro com sucesso!
		// Endereço: Rua dos Bobos, nº 0
	}
}
