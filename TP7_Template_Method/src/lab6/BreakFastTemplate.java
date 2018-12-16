package lab6;

public abstract class BreakFastTemplate {

	
	public final void MakeBreakFast(int numOfEggs) {
		crackingEggs(numOfEggs);
		prepareEggs();
		cook();
		serve();
		if(hook()) System.out.println("ajouter du sel et du poivre");;
	}
	
	abstract public void crackingEggs(int numOfEggs);
	abstract public void prepareEggs() ;
	abstract public void cook() ;
	abstract public void serve() ;
	 boolean hook() {
		  return true;
		 }

}
