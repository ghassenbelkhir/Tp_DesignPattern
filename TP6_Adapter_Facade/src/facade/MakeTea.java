package facade;
/**
 * Put the kettle on and we'll all have tea.
 */

public class MakeTea {
	public static void main(String[] args) {
		TeaCup blueCup = new TeaCup();
		Water water = new Water();
		TeaInfuser infuser = new TeaInfuser();
		
		TeaFacade teaMaker = new TeaFacade(blueCup,water,infuser);
		
		teaMaker.makeTea("Earl Grey");
	
	}

}
