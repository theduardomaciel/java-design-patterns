package dev.theduardomaciel.javadesignpatterns;

import dev.theduardomaciel.javadesignpatterns.gof.strategy.Behaviour;
import dev.theduardomaciel.javadesignpatterns.gof.strategy.behaviour.DefaultBehaviour;
import dev.theduardomaciel.javadesignpatterns.gof.strategy.behaviour.DefensiveBehaviour;
import dev.theduardomaciel.javadesignpatterns.gof.strategy.Robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StrategyTest {
	
	@Test
	public void test() {
		Behaviour defaultBehaviour = new DefaultBehaviour();
		Behaviour defensiveBehaviour = new DefensiveBehaviour();
		
		Robot robot = new Robot(defaultBehaviour);
		robot.move();
		robot.move();
		
		Assertions.assertEquals(defaultBehaviour, robot.getBehaviour());
		
		robot.setBehaviour(defensiveBehaviour);
		robot.move();
		
		Assertions.assertEquals(defensiveBehaviour, robot.getBehaviour());
	}
}
