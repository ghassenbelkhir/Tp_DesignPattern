import java.util.Observable;

public class Bord  extends Observable{
	char[][] brd;
	char userSymbol;
	char compSymbol;
	int remainCount;
	int winner = -1;   // 0 -- the user, 1 -- the computer, -1 -- draw
	
	Bord(char[][] board){
		this.brd=board;
		initialisBord();		
	}	
	
	public void setwinner(int winner) {
		this.winner=winner;
	}
	
	public char[][] getBrd() {
		return this.brd;
	}
	private void initialisBord() {		
		for (int i = 0; i < brd.length; i++)
		      for (int j = 0; j < brd[0].length; j++)
		    	  brd[i][j] = ' ';		
		initialisCount();
	}
	private void initialisCount() {
		remainCount=brd.length*brd[0].length;		
	}
	
	public int decrimtRemainCount() {
		remainCount--;
		return remainCount;
	}
	
	public int getRemainCount() {
		return this.remainCount;
	}
	
	public void setCompSymbol(char compSymbol) {
		this.compSymbol=compSymbol;
	}
	public void setUserSymbol(char userSymbol) {		
		this.userSymbol=userSymbol;
		setCompSymbol((userSymbol == 'x') ? 'o' : 'x');
	}
	
	public char getCompSymbol() {
		return compSymbol;
	}
	
	public char getUserSymbol() {
		return userSymbol;
	}
	
	public void show() {
		int numRow = brd.length;
	    int numCol = brd[0].length;

	    System.out.println();

	    // First write the column header
	    System.out.print("    ");
	    for (int i = 0; i < numCol; i++)
	      System.out.print(i + "   ");
	    System.out.print('\n');

	    System.out.println(); // blank line after the header

	    // The write the table
	    for (int i = 0; i < numRow; i++) {
	      System.out.print(i + "  ");
	      for (int j = 0; j < numCol; j++) {
	        if (j != 0)
	          System.out.print("|");
	        System.out.print(" " + brd[i][j] + " ");
	      }

	      System.out.println();

	      if (i != (numRow - 1)) {
	        // separator line
	        System.out.print("   ");
	        for (int j = 0; j < numCol; j++) {
	          if (j != 0)
	            System.out.print("+");
	          System.out.print("---");
	        }
	        System.out.println();
	      }
	    }
	    System.out.println(); 
	}

	public char getSymbol(int rowIndex, int colIndex) {		
		return brd[rowIndex][colIndex];
	}

	public void setSymbol(int rowIndex, int colIndex, int turn) {
		if (turn==0) {
			brd[rowIndex][colIndex]=userSymbol;
		}else {
			brd[rowIndex][colIndex]=compSymbol;
		}
		setChanged();
		notifyObservers(this);
		
	}
	public int getWidthSize() {
		return brd.length;
	}
	public int getHeightSize() {
		return brd[0].length;
	}

}
