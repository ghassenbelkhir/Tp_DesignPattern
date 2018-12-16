package question2;

/**
 * extrait de http://www.oreilly.com/catalog/hfdesignpat/
 */
public  class BeetSugar extends CondimentDecorator  {

	public BeetSugar(Beverage beverage) {
		super(beverage);
	} 
	
	@Override 
		public String getDescription() {
			// TODO Auto-generated method stub
			return super.getDescription()+", Beet Sugar";
		}
	
	@Override 
	public double cost() {
		return super.cost()+ .1;
	}

}