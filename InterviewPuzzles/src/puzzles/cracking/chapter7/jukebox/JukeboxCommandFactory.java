package puzzles.cracking.chapter7.jukebox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import puzzles.cracking.chapter7.jukebox.state.State;

public class JukeboxCommandFactory {

	public static Map<Integer, JukeboxCommand> cliCommands(Jukebox jb, BufferedReader br){
		
		
		Map<Integer, JukeboxCommand> commands = new HashMap<>();
		
		
		JukeboxCommand insertRecord = new JukeboxCommand(){

			@Override
			public String commandName() {
				return "Insert new record";
			}

			@Override
			public void execute() {
				try{
					
					System.out.println("Enter title of record: ");
					String title = br.readLine();
					System.out.println("Enter song: ");
					String song = br.readLine();
					
					jb.insertRecord(new Record(title, song));
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}};

		JukeboxCommand removeRecord = new JukeboxCommand(){

			@Override
			public String commandName() {
				return "Remove a record";
			}

			@Override
			public void execute() {
				try{
					
					System.out.println("Enter song number: ");
					Integer song = Integer.parseInt(br.readLine());
					
					jb.removeRecord(song);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}};
			
		JukeboxCommand insertCoin = new JukeboxCommand(){

			@Override
			public String commandName() {
				return "Insert Money";
			}

			@Override
			public void execute() {

				
				try{
					
					System.out.println("Available coins: ");
					List<Coin> coins = jb.getAcceptedCoins();
					for(int i = 0; i < coins.size(); i++){
						System.out.printf("%d:   %d¢ \n", i , coins.get(i).value);
					}
					System.out.println("Select coin: ");
					Integer coinIndex = Integer.parseInt(br.readLine());
					
					Coin coin = coins.get(coinIndex);
					
					jb.insertCoin(new Coin(coin.value));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}};
			
		JukeboxCommand returnCoins = new JukeboxCommand(){

			@Override
			public String commandName() {
				return "Return money";
			}

			@Override
			public void execute() {
				jb.returnMoney();
				
			}};
			
		JukeboxCommand makeSelection = new JukeboxCommand(){

			@Override
			public String commandName() {
				return "Play song";
			}

			@Override
			public void execute() {
				try{
					
					System.out.println("Song number: ");
					Integer songIndex = Integer.parseInt(br.readLine());
					jb.playSong(songIndex);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}};
			
		JukeboxCommand quit = new JukeboxCommand(){

			@Override
			public String commandName() {
				return "Quit";
			}

			@Override
			public void execute() {
				System.exit(0);				
			}};
			
		commands.put(1, insertRecord);
		commands.put(2, removeRecord);
		commands.put(3, insertCoin);
		commands.put(4, returnCoins);
		commands.put(5, makeSelection);
		commands.put(6, quit);
			
		return commands;
	}
	
}
