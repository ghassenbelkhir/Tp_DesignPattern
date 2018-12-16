package lab3;

public class WhippedCream  extends IceCreamDecorator{

	public WhippedCream(Dessert dessert) {
		super(dessert);
	
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return super.getDescription() +", Whipped Cream";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()+0.25;
	}

}
