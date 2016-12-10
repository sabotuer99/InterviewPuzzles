package puzzles.cracking.chapter10;

import java.util.Random;

public class MissingInt {

	public static class BigFile{
		
		private Random generator;
		private int seed;
		
		public void resetCursor(){
			this.generator = new Random(seed);
		}
		
		public int nextInt(){
			//if I wanted to be evil I could put a Thread.sleep() here...
			return Math.abs(generator.nextInt());
		}
		
		public BigFile(int seed){
			this.seed = seed;
			resetCursor();
		}
	}
	
	public static int getNewInt(BigFile file, int fileSize){
		int[] buckets = new int[32768]; //2^15
		int bucketSize = 65536; //2^16
		
		file.resetCursor();
		//first pass
		for(int i = 0; i < fileSize; i++){
			int value = file.nextInt();
			int bucketIndex = value / bucketSize;
			buckets[bucketIndex]++;
		}
		
		//find an underpopulated bucket, then find a free number
		int mindex = 0;
		int minCount = buckets[0];
		for(int i = 1; i < buckets.length; i++){
			if(buckets[i] < minCount){
				minCount = buckets[i];
				mindex = i;
			}
		}
		
		{
			file.resetCursor();
			buckets = new int[65536]; 
			for(int j = 0; j < fileSize; j++){
				int value = file.nextInt();
				int bucketIndex = value / bucketSize;
				
				//only record values in bucket range
				if(bucketIndex == mindex){
					int numIndex = value - (bucketIndex * bucketSize);
					buckets[numIndex]++;
				}
				
			}
			
			//find empty number
			for(int j = 0; j < buckets.length; j++){
				if(buckets[j] == 0){
					return (mindex * bucketSize) + j;
				}
			}
			
		}
		
		//couldn't find a number
		return -1;
		
	}
}
