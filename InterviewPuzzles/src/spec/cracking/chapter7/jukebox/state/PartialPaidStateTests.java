package spec.cracking.chapter7.jukebox.state;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.state.State;
import puzzles.cracking.chapter7.jukebox.state.UnloadedState;

public class PartialPaidStateTests extends BaseTest {

	@Test
	public void InsertCoin_StillNotEnough_StaysPartial(){
		State sut = getSut();
		
		State next = sut.insertCoin(quarter());
		
		assertEquals("Partially Paid", next.status());
	}
	
	@Test
	public void InsertRecord_StillLoadedState(){
		State sut = getSut();
		
		State next = sut.insertRecord(testRecord());
		
		assertEquals("Partially Paid", next.status());
		assertEquals(2, next.getAvailableSongs().size());
	}
	
	@Test
	public void MakeSelection_DoesNothing(){
		State sut = getSut();
		
		State next = sut.makeSelection(0);
		
		assertEquals("Partially Paid", next.status());
	}
	
	@Test
	public void RemoveRecord_RecordsEmpty_BecomesUnloadedRefundsCoins(){
		State sut = getSut();
		
		State next = sut.removeRecord(0);
		List<Coin> coins = next.emptyCoinReturn();
		
		assertEquals("Unloaded", next.status());
		assertEquals(1, coins.size());
	}
	
	@Test
	public void RemoveRecord_RecordsNotEmpty_StillLoaded(){
		State sut = getSut();
		
		State next = sut.insertRecord(testRecord());
		next = next.removeRecord(0);
		
		assertEquals("Partially Paid", next.status());
	}
	
	@Test
	public void ReturnCoins_BecomesLoaded(){
		State sut = getSut();
		
		State next = sut.returnCoins();
		
		assertEquals("Loaded", next.status());
	}
	
	private State getSut() {
		State sut = new UnloadedState(75).insertRecord(testRecord()).insertCoin(quarter());
		assertEquals("Partially Paid", sut.status());
		return sut;
	}
}
