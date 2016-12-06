package puzzles.cracking.chapter7.jukebox.state;

import java.util.ArrayList;
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
	
	public void addCoinToReturn(Coin coin){
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
	
	public void returnCoins(){
		coinReturn.addAll(coins);
		coins = new ArrayList<>();
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
		
		List<Coin> allCoins = new ArrayList<>(coins);
		allCoins.addAll(safe);

		List<Coin> returned = makeChange(difference, allCoins);
		
		for(Coin coin : returned){
			if(!coins.remove(coin)){
				safe.remove(coin);
			}
			addCoinToReturn(coin);
		}
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
		int[][] DP = new int[valueArray.length][difference];
		
		for(int row = 0; row < DP.length; row++){
			for(int col = 0; col < DP[0].length; col++){
				int val = valueArray[row];
				if(val > col || row == 0){ //this value is too big for this column
					DP[row][col] = row == 0 ? 0 : DP[row-1][col];
				} else {
					//handle boundary conditions
					int rest = DP[row - 1][col - val];
					DP[row][col] = Math.max(DP[row-1][col], val + rest); //max without value and with value
				}
				//if we have an exact match return early
				if(DP[row][col] == difference){
					return trackBack(DP, row, col, allCoins);
				}
			}
		}
		
		//trackback from last element, which is the best we can do
		return trackBack(DP, DP.length - 1, DP[0].length, allCoins);
	}

	private List<Coin> trackBack(int[][] DP, int lastrow, int lastcol, List<Coin> allCoins) {
		List<Coin> coins = new ArrayList<>();
		int row = lastrow;
		int col = lastcol;
		while( row >= 0 && col > 0){
			Coin coin = allCoins.get(row);
			int val = coin.value;
			
			if(DP[row][col-val] + val >= DP[row-1][col]){
				coins.add(coin);
				col -= val;			
			}
			row --;
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
}