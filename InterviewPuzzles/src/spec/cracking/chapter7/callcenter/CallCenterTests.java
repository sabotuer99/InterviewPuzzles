package spec.cracking.chapter7.callcenter;

import org.junit.Test;

import puzzles.cracking.chapter7.callcenter.Call;
import puzzles.cracking.chapter7.callcenter.CallCenter;
import puzzles.cracking.chapter7.callcenter.Employee;

public class CallCenterTests {

	@Test
	public void SystemTest(){
		//Create Employees
		Employee grumpy = new Employee();
		grumpy.setName("Grumpy");
		grumpy.setMaxServiceLevel(30);
		Employee sunny = new Employee();
		sunny.setName("Sunny");
		sunny.setMinServiceLevel(80);
		Employee manager = new Employee();
		manager.setName("Manny");
		Employee director = new Employee();
		director.setName("Lumberg");
		director.setMaxServiceLevel(55);
		director.setPatience(8);
		
		Call typical = new Call();
		typical.setId("Bob");
		typical.addSatisfiedResponse("You guys rock!");
		typical.addUnsatisfiedResponse("You guys suck!");
		
		Call easy = new Call();
		easy.setId("Lydia");
		easy.setSatisfactionThreshold(25);
		easy.addSatisfiedResponse("Thank you so much I love you guys!");
		easy.addUnsatisfiedResponse("Awe darn, wish we could have worked it out...");
		
		Call imp = new Call();
		imp.setId("Clint");
		imp.setSatisfactionThreshold(90);
		imp.addSatisfiedResponse("Whatever, I guess this'll do.");
		imp.addUnsatisfiedResponse("I'm calling a lawyer!");
		
		CallCenter cc = new CallCenter();
		cc.addRespondent(grumpy);
		cc.addRespondent(sunny);
		cc.addManager(manager);
		cc.addDirector(director);
		
		
		cc.acceptCall(typical);
		cc.acceptCall(easy);
		cc.acceptCall(imp);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
