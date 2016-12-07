package puzzles.cracking.chapter7.jukebox.state;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import puzzles.cracking.chapter7.jukebox.Coin;
import puzzles.cracking.chapter7.jukebox.Record;

public class InternalState{
	
	public InternalState(int songPrice){
		this.songPrice = songPrice;
	}

	private List<Coin> safe = new ArrayList<>();
	private List<Coin> coins = new ArrayList<>();
	private List<Coin> coinReturn = new ArrayList<>();
	private List<Record> records = new ArrayList<>();
	private List<Record> removedRecords = new ArrayList<>();
	private int songPrice = 0;
	private int currentBalance = 0;
	private int returnedBalance = 0;
	private Record songToPlay = null;
	
	
	public void addCoinToSafe(Coin coin){
		safe.add(coin);
	}
	
	public void addCoinToReturn(Coin coin){
		returnedBalance += coin.value;
		coinReturn.add(coin);
	}
	
	public void addCoin(Coin coin){
		if(coin == null) return;
		
		currentBalance += coin.value;
		coins.add(coin);
	}
	
	public void moveCoinsToSafe(){
		safe.addAll(coins);
		coins = new ArrayList<>();
	}
	
	public void returnCoinsFromSafe(){
		safe.addAll(coins);
		List<Coin> coinsToReturn = makeChange(currentBalance, safe);
		safe.removeAll(coinsToReturn);
		coinReturn.addAll(coinsToReturn);
		coins = new ArrayList<>();
		currentBalance = 0;
	}
	
	public void returnCoins(){		
		coinReturn.addAll(coins);		
		coins = new ArrayList<>();
		currentBalance = 0;
	}
	
	public int getSongPrice() {
		return songPrice;
	}
	
	public void makeChange(){
		//balance the song price with the current coin balance
		int difference = currentBalance - songPrice;
		if(difference <= 0) {
			return;
		}
		
		safe.addAll(coins);

		List<Coin> returned = makeChange(difference, safe);
		
		for(Coin coin : returned){
			currentBalance -= coin.value;
			returnedBalance += coin.value;
		}
		
		safe.removeAll(returned);
		coinReturn.addAll(returned);
		coins = new ArrayList<>();
	}

	private Comparator<Coin> coinComparator = new Comparator<Coin>(){
		@Override
		public int compare(Coin o1, Coin o2) {
			return o1.value - o2.value;
		}};
	
	private List<Coin> makeChange(int difference, List<Coin> allCoins) {
		//sort collection
		Collections.sort(allCoins, coinComparator);
		int[] valueArray = new int[allCoins.size()];
		
		for(int i = 0; i < allCoins.size(); i++){
			valueArray[i] = allCoins.get(i).value;
		}
		
		int[][] DP = new int[valueArray.length][difference+1];
		
		for(int row = 0; row < DP.length; row++){
			for(int col = 0; col < DP[0].length; col++){
				int val = valueArray[row];
				if(val > col){ //this value is too big for this column
					DP[row][col] = row == 0 ? 0 : DP[row-1][col];
				} else {
					//handle boundary conditions
					if(row == 0){
						DP[row][col] = val;
					} else {
						int rest = DP[row - 1][col - val];
						int withOut = DP[row - 1][col];
						DP[row][col] = Math.max(withOut, val + rest); //max without value and with value
					}
				}
				//if we have an exact match return early
				if(DP[row][col] == difference){
					return trackBack(DP, row, col, allCoins);
				}
			}
		}
		

		
		//trackback from last element, which is the best we can do
		return trackBack(DP, DP.length - 1, DP[0].length - 1, allCoins);
	}

	private List<Coin> trackBack(int[][] DP, int lastrow, int lastcol, List<Coin> allCoins) {
		
		//DEBUG
		System.out.printf("(%d, %d): %d\n",lastrow, lastcol,DP[lastrow][lastcol]);
		for(int row = 0; row < DP.length; row++){
			System.out.println(Arrays.toString(DP[row]));
		}
		
		
		List<Coin> coins = new ArrayList<>();
		int row = lastrow;
		int col = lastcol;
		while( row >= 0 && col > 0){
			Coin coin = allCoins.get(row);
			int val = coin.value;
			
			int rest = col - val < 0 ? 0 : DP[row][col-val];
			
			if( rest + val == DP[row][col]){
				coins.add(coin);
				col -= val;			
			}
			row--;
		}
		
		return coins;
	}

	public boolean enoughMoney(){
		return getCoinBalance() >= songPrice;
	}
	
	public boolean isLoaded(){
		return records.size() > 0;
	}

	public void addRecord(Record record){
		records.add(record);			
	}
	
	public void removeRecord(int index) {
		try{
			Record removed = records.remove(index);
			removedRecords.add(removed);
		} catch (Exception ex){
			//none of the exceptions that could be thrown here
			//are of any interest to the caller
		}
	}
	
	public List<Coin> emptyCoinReturn() {
		List<Coin> coins = coinReturn;
		coinReturn = new ArrayList<>();
		returnedBalance = 0;
		return coins;
	}
	
	public int getCoinBalance() {
		return currentBalance;
	}
	
	public List<String> getAvailableSongs() {
		List<String> titles = new ArrayList<>();
		for(Record record : records){
			titles.add(record.title);
		}
		return titles;
	}

	public int getReturnedBalance() {
		return returnedBalance;
	}

	public Record getSongToPlay() {
		return songToPlay;
	}

	public void setSongToPlay(Record songToPlay) {
		this.songToPlay = songToPlay;
	}

	public Record getSong(int index) {
		return records.get(index);
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}
}