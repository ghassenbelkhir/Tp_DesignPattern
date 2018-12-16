// Because we extend IceCream, IceCreamDecorator is-a IceCream
package lab3;
public abstract class IceCreamDecorator extends Dessert {
	
	Dessert dessert;
	
 public IceCreamDecorator(Dessert dessert) {
	this.dessert=dessert;
}
 public  String getDescription() {
	 return dessert.getDescription();
 }
 public double cost() {
	 return dessert.cost();
 }
}
