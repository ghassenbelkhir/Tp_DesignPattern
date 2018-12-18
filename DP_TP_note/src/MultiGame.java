import java.util.Scanner;

public abstract class MultiGame {	
	
	protected int turn;  // 0 -- the user, 1 -- the computer	
	abstract void initialiseGame();
	abstract void startGame(int turn);
	abstract boolean isGameFinish();
	abstract void congratuteWinner();
	
	final void play () {
		initialiseGame();
		while (!isGameFinish()) {			
			startGame(turn);
		}				
		congratuteWinner();
	}
	
}
