package dev.theduardomaciel.javadesignpatterns.gof.singleton;

public class SingletonLazy {
	
	// Atributo estático para armazenar a instância única
	private static SingletonLazy instance;
	
	// Prevenimos a instanciação por outras classes
	private SingletonLazy() {
		super();
	}
	
	// Método estático para retornar a instância única
	public static SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}
	
	public void showMessage() {
		System.out.println("Hello, World!");
	}
	
	public static void main(String[] args) {
		SingletonLazy.getInstance().showMessage();
	}
}
