package puzzles.cracking.chapter7.jukebox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import puzzles.cracking.chapter7.jukebox.state.State;
import puzzles.cracking.chapter7.jukebox.state.UnloadedState;

public class Jukebox {

	State state;
	Map<Integer, JukeboxCommand> commands = new HashMap<>();
	List<Coin> acceptedCoins = new ArrayList<>();
	
	public Jukebox(Map<Integer, JukeboxCommand> commands, 
			State state, 
			List<Coin> acceptedCoins){
		
		this.commands = commands;
		this.state = state;
		this.acceptedCoins = acceptedCoins;
	}
	
	
	public void executeCommand(int index){
		JukeboxCommand command = commands.get(index);
		if(command != null){
			command.execute();
		}
	}
	
	public List<String> getSongs(){
		return state.getAvailableSongs();
	}
	
	public static void main(String[] args){
		State state = new UnloadedState(100);
		Map<Integer, JukeboxCommand> commands = new HashMap<>();
		List<Coin> coins = new ArrayList<>();
		coins.add(new Coin(5));
		coins.add(new Coin(10));
		coins.add(new Coin(25));
		Jukebox jukebox = new Jukebox(commands, state, coins);		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		commands.putAll(JukeboxCommandFactory.cliCommands(jukebox, br));
		JukeboxDisplay console = new JukeboxConsolePrinter();
		
		while(true){ //run until user selects quit command
			console.display(jukebox);
			try{
				
				System.out.println("Enter command number: ");
				Integer option = Integer.parseInt(br.readLine());
				
				JukeboxCommand command = commands.get(option);
				command.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<String> getCommandNames() {
		List<String> commandNames = new ArrayList<>();
		
		for(Integer key: commands.keySet()){
			JukeboxCommand command = commands.get(key);
			String name = key + " " + command.commandName();
			commandNames.add(name);
		}

		return commandNames;
	}


	public void insertRecord(Record record) {
		state = state.insertRecord(record);
	}


	public void removeRecord(int index) {
		state = state.removeRecord(index);
	}


	public List<Coin> getAcceptedCoins() {
		return Collections.unmodifiableList(acceptedCoins);
	}


	public void insertCoin(Coin coin) {
		state = state.insertCoin(coin);
	}


	public void returnMoney() {
		state = state.returnCoins();
	}


	public int getBalance() {
		return state.getCoinBalance();
	}


	public int peekReturn() {
		return state.getReturnedBalance();
	}


	public String getStatus() {
		// TODO Auto-generated method stub
		return state.status();
	}


	public void playSong(Integer index) {
		state = state.makeSelection(index);
		Record toPlay = state.songToPlay();
		
		if(toPlay != null){
			System.out.println("♫" + toPlay.song + "♪");
			
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
