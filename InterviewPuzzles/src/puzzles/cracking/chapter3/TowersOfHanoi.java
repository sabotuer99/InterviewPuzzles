package puzzles.cracking.chapter3;

import java.util.ArrayDeque;
import java.util.Deque;

public class TowersOfHanoi {

	int N = 8; //hard limit to disks
	int disks;
	Deque<Integer> L;
	Deque<Integer> M;
	Deque<Integer> R;
	
	public TowersOfHanoi(int disks){
		this.disks = disks;
		L = new ArrayDeque<>(disks);
		M = new ArrayDeque<>(disks);
		R = new ArrayDeque<>(disks);
	}
	
	public void solve(){
		for(int i = disks; i >= 1; i--){
			int e = (i*2) - 1;
			R.push(e);
		}
		move(disks, R, L, M);
		System.out.println("Tada!");
	}

	private void move(int disks, 
			          Deque<Integer> source, 
			          Deque<Integer> target,
			          Deque<Integer> auxilary) {
		
		if(disks > 1){
			move(disks-1, source, auxilary, target);
		}
		int disk = source.pop();
		
		//enforce size rule
		if(target.size() > 0 && target.peek() < disk){
			System.out.println("Tried to put " + disk + " on top of " + target.peek());
			throw new RuntimeException("Illegal move, cannot put disk on top of smaller disk...");
		}
		
		target.push(disk);
		
		printTowers();
		
		if(disks > 1){
			move(disks-1, auxilary, target, source);
		}
	}

	int step = 1;
	private void printTowers() {
		
		System.out.println("State at step " + step + ": ");
		System.out.println(L.peek() + "  " + M.peek() + "  " + R.peek());
		step++;
		
	}
}
