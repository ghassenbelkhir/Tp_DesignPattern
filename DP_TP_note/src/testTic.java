import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testTic {

	@Test
	void test() {//to test all game
		
		MultiGame multiGame=new PlayTicTacToy();
		multiGame.play();
		
	}
	@Test
	void test1() {// tests unitaires
		Bord board = new Bord(new char[3][3]);		
		char[][] celles = board.getBrd();
		assertEquals(celles[0][0], ' ');
		assertEquals(celles[2][0], ' ');
		assertEquals(board.getHeightSize(), 3);
	}
	@Test
	void test2() {// tests unitaires		
		Bord board = new Bord(new char[3][3]);		
		char[][] celles = board.getBrd();
		board.setUserSymbol('x');
		board.setCompSymbol('o');
		
		board.setSymbol(0, 2, 0);//0 for user
		board.setSymbol(2, 2, 1);//1 for comp
		assertEquals(celles[0][2], 'x');
		assertEquals(celles[2][2], 'o');	
	}

}
