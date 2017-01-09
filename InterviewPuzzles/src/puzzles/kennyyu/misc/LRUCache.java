package puzzles.kennyyu.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LRUCache<K,T> {

	private TreeMap<Long, K> timestamps = new TreeMap<>();
	private Map<K, Item> cache = new HashMap<>();
	
	private class Item{
		public T value;
		public Item(T value){
			this.value = value;
		}
		public long timestamp;
	}
	
	private long timemap(K key){
		long T = System.currentTimeMillis();
		while(timestamps.containsKey(T)){
			T++;
		}
		timestamps.put(T, key);
		return T;
	}
	
	public T get(K key){
		if(!cache.containsKey(key)){
			return null;
		}
		//System.out.println("Pre:" + Arrays.toString(timestamps.values().toArray()));
		
		
		Item cached = cache.get(key);
		timestamps.remove(cached.timestamp);
		
		//System.out.println(Arrays.toString(timestamps.values().toArray()));
		cached.timestamp = timemap(key);
		
		//System.out.println("Post:" + Arrays.toString(timestamps.values().toArray()));
		cache.put(key, cached);
		return cached.value;
	}
	
	public void expel(){
		Entry<Long, K> oldest = timestamps.pollFirstEntry();
		cache.remove(oldest.getValue());
	}
	
	public void remove(K key){
		Item removed = cache.remove(key);
		timestamps.remove(removed.timestamp);
	}
	
	public void cache(K key, T value){
		Item entry = new Item(value);
		entry.timestamp = timemap(key);
		cache.put(key, entry);
	}
	
}
