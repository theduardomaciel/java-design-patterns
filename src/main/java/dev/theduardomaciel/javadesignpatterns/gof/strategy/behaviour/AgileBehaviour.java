package dev.theduardomaciel.javadesignpatterns.gof.strategy.behaviour;

import dev.theduardomaciel.javadesignpatterns.gof.strategy.Behaviour;

public class AgileBehaviour implements Behaviour {

	@Override
	public void move() {
		System.out.println("O robô está se movendo agilmente.");
	}
}
