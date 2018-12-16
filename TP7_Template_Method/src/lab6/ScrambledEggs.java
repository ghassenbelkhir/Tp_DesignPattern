package lab6;
public class ScrambledEggs extends BreakFastTemplate{
	
	public void crackingEggs(int num) {
		System.out.println("Cracking " + num + " eggs");
	}
	
	public void prepareEggs() {
		System.out.println("Stirring and adding milk to the eggs");
	}
	
	public void cook() {
		System.out.println("Scrambling the eggs.");
	}
	
	public void serve() {
		System.out.println("Placing the eggs on the plate.");
	}

}
