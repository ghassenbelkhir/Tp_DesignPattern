package facade;

public class TeaFacade {

	private TeaCup teaCup;
	private Water water;
	private TeaInfuser infuser;

	public TeaFacade(TeaCup cup, Water water, TeaInfuser infuser) {

		this.teaCup=cup;
		this.water= water;
		this.infuser= infuser;

	}

	public void makeTea(String teaType) {
		Tea tea = new Tea(teaType);
		infuser.addTea(tea);

		water.boilWater();

		teaCup.addWater(water);

		teaCup.setSteepTime(15);

		teaCup.steep();
	}
	
	
}
