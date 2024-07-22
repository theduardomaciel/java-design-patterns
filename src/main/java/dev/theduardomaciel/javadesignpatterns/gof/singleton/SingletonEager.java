package dev.theduardomaciel.javadesignpatterns.gof.singleton;

public class SingletonEager {
	
	// Atributo estático para armazenar a instância única
	// Note que, diferente do "SingletonLazy", que instancia o Singleton somente quando o método
	// "getInstance" é chamado, no "SingletonEager" a instância é criada no momento da declaração
	private static final SingletonEager instance = new SingletonEager();
	
	// Prevenimos a instanciação por outras classes
	private SingletonEager() {
		super();
	}
	
	// Método estático para retornar a instância única
	public static SingletonEager getInstance() {
		return instance;
	}
}
