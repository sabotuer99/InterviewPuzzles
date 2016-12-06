package spec.cracking.chapter7.jukebox;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.state.InternalState;

public class InternalStateTests {

	@Test
	public void MakeChange_ExactChangePossible_ReturnsExactChange() {
		InternalState sut = new InternalState(75);
		
		sut.addCoin(new Coin(25));
		sut.addCoin(new Coin(25));
		sut.addCoin(new Coin(25));
		sut.addCoin(new Coin(25));
		
		sut.makeChange();
		
		List<Coin> change = sut.emptyCoinReturn();
		
		assertEquals(1, change.size());
		assertEquals(25, change.get(0).value);
		assertEquals(75, sut.getCoinBalance());
		
	}
	
	@Test
	public void MakeChange_ExactChangeImpossible_ReturnsCloseChange() {
		InternalState sut = new InternalState(75);
		
		sut.addCoin(new Coin(20));
		sut.addCoin(new Coin(20));
		sut.addCoin(new Coin(20));
		sut.addCoin(new Coin(20));
		sut.addCoin(new Coin(10));
		
		sut.makeChange();
		
		List<Coin> change = sut.emptyCoinReturn();
		
		assertEquals(1, change.size());
		assertEquals(10, change.get(0).value);
		assertEquals(80, sut.getCoinBalance());
		
	}
	
	@Test
	public void MakeChange_BalanceZero_ReturnsNothing() {
		InternalState sut = new InternalState(75);
		
		sut.makeChange();
		
		List<Coin> change = sut.emptyCoinReturn();
		
		assertEquals(0, change.size());
		assertEquals(0, sut.getCoinBalance());		
	}
	
	@Test
	public void MakeChange_LotsOfSmallCoins_ReturnsChange() {
		InternalState sut = new InternalState(75);
		
		sut.addCoin(new Coin(5));
		sut.addCoin(new Coin(7));
		sut.addCoin(new Coin(8));
		sut.addCoin(new Coin(15));
		sut.addCoin(new Coin(75));
		sut.addCoin(new Coin(10));
		
		sut.makeChange();
		
		List<Coin> change = sut.emptyCoinReturn();
		
		int totalChange = 0;
		for(Coin coin : change){
			totalChange += coin.value;
		}
		
		assertEquals(5, change.size());
		assertEquals(45, totalChange);
		assertEquals(75, sut.getCoinBalance());		
	}

}
