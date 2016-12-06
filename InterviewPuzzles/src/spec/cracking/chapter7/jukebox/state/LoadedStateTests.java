package spec.cracking.chapter7.jukebox.state;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.cracking.chapter7.jukebox.state.State;
import puzzles.cracking.chapter7.jukebox.state.UnloadedState;

public class LoadedStateTests extends BaseTest {

	@Test
	public void InsertCoin_GetPartialState(){
		State sut = getSut();
		
		State next = sut.insertCoin(quarter());
		
		assertEquals("Partially Paid", next.status());
		assertEquals(25, next.getCoinBalance());
	}

	@Test
	public void InsertRecord_StillLoadedState(){
		State sut = getSut();
		
		State next = sut.insertRecord(testRecord());
		
		assertEquals("Loaded", next.status());
		assertEquals(2, next.getAvailableSongs().size());
	}
	
	@Test
	public void MakeSelection_DoesNothing(){
		State sut = getSut();
		
		State next = sut.makeSelection(0);
		
		assertEquals("Loaded", next.status());
	}
	
	@Test
	public void ReturnCoins_DoesNothing(){
		State sut = getSut();
		
		State next = sut.returnCoins();
		
		assertEquals("Loaded", next.status());
	}
	
	@Test
	public void RemoveRecord_RecordsEmpty_BecomesUnloaded(){
		State sut = getSut();
		
		State next = sut.removeRecord(0);
		
		assertEquals("Unloaded", next.status());
	}
	
	@Test
	public void RemoveRecord_RecordsNotEmpty_StillLoaded(){
		State sut = getSut();
		
		State next = sut.insertRecord(testRecord());
		next = next.removeRecord(0);
		
		assertEquals("Loaded", next.status());
	}
	
	private State getSut() {
		State sut = new UnloadedState(75).insertRecord(testRecord());
		assertEquals("Loaded", sut.status());
		return sut;
	}
}
