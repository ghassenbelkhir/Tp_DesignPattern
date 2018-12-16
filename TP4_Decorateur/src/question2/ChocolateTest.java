package question2;


public class ChocolateTest extends junit.framework.TestCase{
	private question2.Chocolate choco;

// � d�commenter


 	public void setUp(){
 		choco = new Chocolate();
 	}
 
 	
 	
 	public void testChocolate(){
 		assertEquals(2.1, choco.cost(), 0.1);
 	}
 
 	public void testChocolateWhip(){
 		Beverage chocoSimpleWhip = new Whip(choco);
 
 		assertEquals(2.2, chocoSimpleWhip.cost(), 0.01);
 	}
 	
 	public void testChocolateWhipWhip(){
 		Beverage chocoDoubleWhip = new Whip(new Whip(choco));
 
 		assertEquals(2.3, chocoDoubleWhip.cost(), 0.01);
 	}
 	
 	public void testChocolateWhipSoyMocha(){
 		Beverage chocoWhipSoyMocha = new Mocha(new Soy(new Whip(choco)));
 
 		assertEquals(2.55, chocoWhipSoyMocha.cost(), 0.01);
 		Beverage b = new BeetSugar(new Whip(new Mocha(new Soy(new HouseBlend())))); 
 	   System.out.println(b);
 	}
 	public void testDecafMilk() {
 		Beverage DecafMilk = new Milk(new Decaf());
 		assertEquals(1.15,DecafMilk.cost(),0.01);
 	}
	

	
	

	
}
