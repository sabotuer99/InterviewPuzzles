package puzzles.cracking.moderate;

import java.util.List;

public class Population {

	public static class Person{
		public int birth;
		public int death;
		public Person(int birth, int death){
			this.birth = birth;
			this.death = death;
		}
	}
	
	
	public static int maxPopulation(List<Person> people){
		int[] births = new int[101];
		int[] deaths = new int[101];
		int[] population = new int[101];
		
		for(Person person : people){
			int bindex = person.birth - 1900;
			int dindex = person.death - 1900;
			births[bindex]++;
			deaths[dindex]++;
		}
		
		int max = births[0];
		int year = 1900;
		
		for(int i = 1; i <= 100; i++){
			population[i] = births[i] - deaths[i-1] + population[i-1];
			if(population[i] > max){
				year = i + 1900;
				max = population[i];
			}
		}
		return year;
	}
	
}
