package dev.theduardomaciel.javadesignpatterns.gof.strategy;

public class Robot {
	private Behaviour behaviour;

	public Robot(Behaviour behaviour) {
		this.behaviour = behaviour;
	}

	public void move() {
		behaviour.move();
	}
	
	public Behaviour getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(Behaviour behaviour) {
		this.behaviour = behaviour;
	}
}
