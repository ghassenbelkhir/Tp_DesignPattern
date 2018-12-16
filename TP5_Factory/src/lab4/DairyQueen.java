package lab4;

public class DairyQueen extends IceCreamShop {

	@Override
	public IceCream getIceCream(String type) {
		// TODO Auto-generated method stub
		if (type.equals("chocolate"))
			return new Chocolate();
		else if (type.equals("strawberry"))
			return new Strawberry();
		else if (type.equals("vanilla"))
			return new Vanilla();
		else
			return null;
	}
	
	 public static void main(String[] args) {
		   IceCreamShop bAndJ = new DairyQueen();
		   IceCream cone;
		   
		   cone = bAndJ.orderCone("chocolate");
		   System.out.println("Enjoying some " + cone.getDescription() + " which costs " + cone.cost());
		 }

}
