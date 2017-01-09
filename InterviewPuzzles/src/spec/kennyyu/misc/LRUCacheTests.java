package spec.kennyyu.misc;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.kennyyu.misc.LRUCache;

public class LRUCacheTests {

	@Test
	public void BasicTest(){
		LRUCache<Integer, String> sut = new LRUCache<>();
		sut.cache(1, "first");
		sut.cache(2, "second");
		sut.cache(3, "third");
		
		sut.get(1);
		sut.get(2);
		sut.expel();
		
		assertEquals("first", sut.get(1));
		assertNull(sut.get(3));
		assertEquals("second", sut.get(2));
	}
	
	
}
