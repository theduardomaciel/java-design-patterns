package dev.theduardomaciel.javadesignpatterns;

import dev.theduardomaciel.javadesignpatterns.gof.singleton.SingletonEager;
import dev.theduardomaciel.javadesignpatterns.gof.singleton.SingletonLazy;
import dev.theduardomaciel.javadesignpatterns.gof.singleton.SingletonLazyHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {
	@Test
	public void testNotSingleton() {
		// Testamos se duas instâncias de uma classe que não é Singleton são diferentes
		Object object = new Object();
		Object secondObject = new Object();
		
		Assertions.assertNotEquals(object.toString(), secondObject.toString());
	}
	
	@Test
	public void testSingletonLazyHolder() {
		SingletonLazy singletonLazy = SingletonLazy.getInstance();
		SingletonLazy secondSingletonLazy = SingletonLazy.getInstance();
		
		Assertions.assertEquals(singletonLazy.toString(), secondSingletonLazy.toString());
	}
	
	@Test
	public void testSingletonEager() {
		SingletonEager singletonEager = SingletonEager.getInstance();
		SingletonEager secondSingletonEager = SingletonEager.getInstance();
		
		Assertions.assertEquals(singletonEager.toString(), secondSingletonEager.toString());
	}
	
	@Test
	public void testSingletonLazy() {
		SingletonLazyHolder singletonLazyHolder = SingletonLazyHolder.getInstance();
		SingletonLazyHolder secondSingletonLazyHolder = SingletonLazyHolder.getInstance();
		
		Assertions.assertEquals(singletonLazyHolder.toString(), secondSingletonLazyHolder.toString());
	}
}
