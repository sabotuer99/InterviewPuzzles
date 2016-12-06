package spec.cracking.chapter7.jukebox.state;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.Record;
import puzzles.cracking.chapter7.jukebox.state.State;
import puzzles.cracking.chapter7.jukebox.state.UnloadedState;

public class UnloadedStateTests extends BaseTest {

	@Test
	public void AddRecord_TransitionsToLoadedState(){
		State sut = getSut();
		Record record = testRecord();
		
		State next = sut.insertRecord(record);
		
		assertEquals("Loaded", next.status());
	}
	
	@Test
	public void AddCoin_ReturnsCoinStillUnloadedState(){
		State sut = getSut();
		Coin coin = quarter();
		
		State next = sut.insertCoin(coin);
		List<Coin> returned = sut.emptyCoinReturn();
		
		assertEquals("Unloaded", next.status());
		assertEquals(1, returned.size());
		assertEquals(0, next.getCoinBalance());
	}
	
	@Test
	public void MakeSelection_DoesNothing(){
		State sut = getSut();
		
		State next = sut.makeSelection(0);
		
		assertEquals("Unloaded", next.status());
	}
	
	@Test
	public void ReturnCoins_DoesNothing(){
		State sut = getSut();
		
		State next = sut.returnCoins();
		
		assertEquals("Unloaded", next.status());
	}
	
	@Test
	public void RemoveRecord_DoesNothing(){
		State sut = getSut();
		
		State next = sut.removeRecord(0);
		
		assertEquals("Unloaded", next.status());
	}
	
	State getSut(){
		return new UnloadedState(75);
	}
}
