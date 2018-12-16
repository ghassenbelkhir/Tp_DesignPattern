package lab6;
public class EatBreakfast {
	public static void main(String[] args) {
		BreakFastTemplate scrambled = new ScrambledEggs();
		scrambled.MakeBreakFast(2);
		
		BreakFastTemplate omelette = new Omelette();
		omelette.MakeBreakFast(3);
		
		BreakFastTemplate sunny = new SunnySide();
		sunny.MakeBreakFast(1);
	}

}
