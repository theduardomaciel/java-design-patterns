package dev.theduardomaciel.javadesignpatterns.gof.singleton;

/*
* Benefícios do padrão SingletonLazyHolder:
* - Static factory:
*   o método "getInstance" é um static factory method, ou seja,
*   um método estático que retorna uma instância da própria classe
*
* - Lazy initialization:
*   a instância é criada somente quando o método "getInstance" é chamado
*
* - Thread-safe:
*   a classe é thread-safe, visto que a classe é inicializada com um inicializador estático.
*   Além disso, a primeira chamada ao método "getInstance" por qualquer thread faz com que a classe
*  "InstanceHolder" seja carregada e inicializada, momento em que a inicialização do Singleton ocorre
*   através do inicializador estático.
*
* @ see https://stackoverflow.com/a/24018148
* */
public class SingletonLazyHolder {
	
	// Classe estática para armazenar a instância única
	private static class SingletonHolder {
		private static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
	}
	
	// Prevenimos a instanciação por outras classes
	private SingletonLazyHolder() {
		super();
	}
	
	// Método estático para retornar a instância única
	public static SingletonLazyHolder getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	public void showMessage() {
		System.out.println("Hello, World!");
	}
	
	public static void main(String[] args) {
		SingletonLazyHolder.getInstance().showMessage();
	}
}
