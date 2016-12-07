package puzzles.cracking.chapter7.jukebox;

import java.util.List;

public class JukeboxConsolePrinter implements JukeboxDisplay{

	@Override
	public void display(Jukebox jukebox) {
		
		//clear the console
		for(int i = 0; i < 80; i++)
			System.out.println();
		
		System.out.printf(			"* ********** ********** ********** *\n"); //36 chars wide
		System.out.printf(			"*             JUKE BOX             *\n");
		System.out.printf(			"* ********** ********** ********** *\n");
		System.out.printf(			"*               SONGS              *\n");
		System.out.printf(			"* ********** ********** ********** *\n");
		List<String> titles = jukebox.getSongs();
		if(titles.size() == 0){
			System.out.printf(		"*        -= None  loaded =-        *\n");
			System.out.printf(		"* ********** ********** ********** *\n");
		} else {
			for(int i = 0; i < titles.size(); i++){
				String title = titles.get(i);
				System.out.printf(	"* %-2d%-30s *\n",i ,title);
			}
			System.out.printf(		"* ********** ********** ********** *\n");
		}
	    System.out.printf(			"* Balance: %-4d       Return: %-4d *\n", 
	    		jukebox.getBalance(), jukebox.peekReturn() );
	    System.out.printf(			"* Status: %-24s *\n", jukebox.getStatus());
		System.out.printf(			"* ********** ********** ********** *\n");
	    System.out.printf(			"*               MENU               *\n");
		System.out.printf(			"* ********** ********** ********** *\n");
		List<String> commands = jukebox.getCommandNames();
		if(commands.size() == 0){
			System.out.printf(		"*        -= None  loaded =-        *\n");
			System.out.printf(		"* ********** ********** ********** *\n");
		} else {
			for(String command : commands){
				System.out.printf(	"* %-32s *\n", command);
			}
			System.out.printf(		"* ********** ********** ********** *\n");
		}
	}

}
