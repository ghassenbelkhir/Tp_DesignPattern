package lab3;
public class Cherry extends IceCreamDecorator {
 // the dessert we are decorating
 // notice the use of composition rather than inheritance


 public static final double COST = 0.15;

 public Cherry(Dessert flavor) {
  super(flavor);
 }
 
 public String getDescription() {
  return super.getDescription() + " with a cherry";
 }

 public double cost() {
  return super.cost() + COST;
 }
}
