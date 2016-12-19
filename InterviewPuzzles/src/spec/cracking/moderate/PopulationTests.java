package spec.cracking.moderate;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import puzzles.cracking.moderate.Population;
import puzzles.cracking.moderate.Population.Person;

public class PopulationTests {

	@Test
	public void BasicTest1(){
		
		List<Person> people = new ArrayList<>();
		people.add(new Person(1901, 1932));
		people.add(new Person(1905, 1932));
		people.add(new Person(1910, 1933));
		people.add(new Person(1925, 1943));
		people.add(new Person(1933, 1955));
		
		int result = Population.maxPopulation(people);
		
		assertEquals(1925, result);
	}
	
	@Test
	public void BasicTest2(){
		
		List<Person> people = new ArrayList<>();
		people.add(new Person(1901, 1932));
		people.add(new Person(1905, 1924));
		people.add(new Person(1910, 1933));
		people.add(new Person(1925, 1943));
		people.add(new Person(1933, 1955));
		
		int result = Population.maxPopulation(people);
		
		assertEquals(1910, result);
	}
	
	@Test
	public void BasicTest3(){
		
		List<Person> people = new ArrayList<>();
		people.add(new Person(1901, 1924));
		people.add(new Person(1905, 1932));
		people.add(new Person(1910, 1933));
		people.add(new Person(1925, 1943));
		people.add(new Person(1933, 1955));
		people.add(new Person(1933, 1968));
		
		int result = Population.maxPopulation(people);
		
		assertEquals(1933, result);
	}
	
}
