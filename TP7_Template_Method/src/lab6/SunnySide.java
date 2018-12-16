package lab6;
public class SunnySide extends BreakFastTemplate {

	public void crackingEggs(int n) {
		System.out.println("Cracking " + n + " eggs.");
	}

	public void prepareEggs() {
		System.out.println("Never stir sunny side up!");
	}

	public void cook() {
		System.out.println("Cooking the eggs sunny side up.");
	}

	public void serve() {
		System.out.println("Placing the eggs on a plate");
	}
	
	
	@Override
	public boolean hook() {
		
		return false;
	}

}
