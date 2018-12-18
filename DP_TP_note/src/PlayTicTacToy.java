import java.util.Scanner;

public class PlayTicTacToy extends MultiGame {
	final static Scanner sc = new Scanner(System.in);
	public Bord board;//to use in test		
	final int SIZE = 3;	
	int winner = -1;   // 0 -- the user, 1 -- the computer, -1 -- draw   		
	
	public PlayTicTacToy(){
		board=new Bord(new char[SIZE][SIZE]);
	    board.addObserver(new Interface());
	}
	@Override
	void initialiseGame() {		
		System.out.println("===== WELCOME TO THE TIC-TAC-TOE GAME!! =====\n");
		board.show();
		System.out.print("  Which symbol do you want to play, \"x\" or \"o\"? ");
		char symbolUser=sc.next().toLowerCase().charAt(0);
		board.setUserSymbol(symbolUser);
		
		// Also ask whether or not the user wants to go first.
		System.out.println();
	    System.out.print("  Do you want to go first (y/n)? ");
	    char ans = sc.next().toLowerCase().charAt(0);	    
	    if (ans == 'y') {
	    	turn = 0;
	    }
	    else {
	    	turn = 1;
	    }
	}
	
	@Override
	void startGame(int joueur) {		
		if (joueur==0) {
			
			System.out.print("\nEnter the row and column indices: ");
		    int rowIndex = sc.nextInt();
		    int colIndex = sc.nextInt();

		    while (board.getSymbol(rowIndex,colIndex) != ' ') {
		      System.out.print("\n!! The cell is already taken.\nEnter the row and column indices: ");
		      rowIndex = sc.nextInt();
		      colIndex = sc.nextInt();
		    }
		    board.setSymbol(rowIndex, colIndex, joueur);		    
		}else {			
			outerloop:
		    for (int i = 0; i <board.getWidthSize(); i++) {
		      for (int j = 0; j < board.getHeightSize(); j++) {
		        if (board.getSymbol(i, j) == ' ') { // empty cell
		        	board.setSymbol(i, j, joueur);		        	
		        	break outerloop;		        	
		        }		        
		      }
		    }		    
		}
		board.decrimtRemainCount();
		turn = (joueur + 1 ) % 2;
		//board.show();
	}
	@Override
	boolean isGameFinish() {		
		boolean done = false;	
		if (/*!done &&*/ board.getRemainCount() > 0) {
		      // If there is a winner at this time, set the winner and the done flag to true.
		      done = isGameWon(board.getBrd(), 
		    		   (turn+ 1 ) % 2,
		    		  board.getUserSymbol(),
		    		  board.getCompSymbol()); // Did the turn won?
		      //System.out.println("done "+done);
		      if (done) {
		    	  winner = (turn+ 1 ) % 2; // the one who made the last move won the game
			      done =true;  
		      }else {
		    	  done =false;		       
		      }
		}		
		return done;	
	}
		
	@Override
	void congratuteWinner() {
		// Winner is found.  Declare the winner.
	    if (winner == 0)
	      System.out.println("\n** YOU WON.  CONGRATULATIONS!! **");
	    else if (winner == 1)
	      System.out.println("\n** YOU LOST..  Maybe next time :) **");
	    else
	      System.out.println("\n** DRAW... **");   
		
	}

	public static boolean isGameWon(char[][] brd, int turn, char usym, char csym){
	    char sym;
	    if (turn == 0)
	      sym = usym;
	    else
	      sym = csym;

	    int i, j;
	    boolean win = false;

	    // Check win by a row
	    for (i = 0; i < brd.length && !win; i++) {
	      for (j = 0; j < brd[0].length; j++) {
	        if (brd[i][j] != sym)
	          break;
	      }
	      if (j == brd[0].length)
	        win = true;
	    }

	    // Check win by a column
	    for (j = 0; j < brd[0].length && !win; j++) {
	      for (i = 0; i < brd.length; i++) {
	        if (brd[i][j] != sym)
	          break;
	      }
	      if (i == brd.length)
	        win = true;
	    }

	    // Check win by a diagonal (1)
	    if (!win) {
	      for (i = 0; i < brd.length; i++) {
	        if (brd[i][i] != sym)
	          break;
	      }
	      if (i == brd.length)
	        win = true;
	    }

	    // Check win by a diagonal (2)
	    if (!win) {
	      for (i = 0; i < brd.length; i++) {
	        if (brd[i][brd.length - 1 - i] != sym)
	          break;
	      }
	      if (i == brd.length)
	        win = true;
	    }

	    // Finally return win
	    return win;
	  }
}
