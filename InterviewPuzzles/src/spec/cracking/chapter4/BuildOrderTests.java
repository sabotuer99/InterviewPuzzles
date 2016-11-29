package spec.cracking.chapter4;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import puzzles.cracking.chapter4.BuildOrder;

public class BuildOrderTests {

	String a="a", b="b", c="c", d="d", e="e", f="f";
	
	@Test
	public void BookTestCase() {
		
		String[] projects = {a,b,c,d,e,f};
		String[][] dependencies = {{a,d}, {f,b}, {b,d}, {f,a}, {d,c}};
		
		String[] result = BuildOrder.computeOrder(projects, dependencies);
		String order = Arrays.toString(result);
		
		System.out.println(order);
		
		assertNotNull(result);
		assertEquals(6, result.length);
		checkDeps(dependencies, order);
	}
	
	@Test
	public void CreateCycle_ReturnsNull() {
		String[] projects = {a,b,c};
		String[][] dependencies = {{a,b}, {b,c}, {c,a}};
		
		String[] result = BuildOrder.computeOrder(projects, dependencies);

		assertNull(result);

	}
	
	@Test
	public void SimpleGraph_ReturnsCorrectResult() {
		String[] projects = {a,b,c};
		String[][] dependencies = {{a,c}, {a,b}};
		
		String[] result = BuildOrder.computeOrder(projects, dependencies);
		String order = Arrays.toString(result);
		
		System.out.println(order);
		
		assertNotNull(result);
		assertEquals(3, result.length);
		checkDeps(dependencies, order);
	}
	
	@Test
	public void AddDependencyTwice_IgnoresRepeatCall_ReturnsCorrectResult() {
		String[] projects = {a,b,c};
		String[][] dependencies = {{a,c}, {a,c}};
		
		String[] result = BuildOrder.computeOrder(projects, dependencies);
		String order = Arrays.toString(result);
		
		System.out.println(order);
		
		assertNotNull(result);
		assertEquals(3, result.length);
		checkDeps(dependencies, order);
	}
	



	private void checkDeps(String[][] dependencies, String order) {
		for(String[] dep : dependencies){
			assertTrue(order.indexOf(dep[0]) < order.indexOf(dep[1]));
		}
	}
}
