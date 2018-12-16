package lab3;

public class HotFudge extends IceCreamDecorator {

	public HotFudge(Dessert d) {
		
		super(d);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return super.getDescription()+", Hot Fudge";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()+0.60;
	}

}
