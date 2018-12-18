
public class Ventilateur {

	public static final int RAPIDE = 3;
	public static final int MOYEN = 2;
	public static final int LENT = 1;
	public static final int ARRET = 0;
	String localisation;
	int vitesse;
	public Ventilateur(String localisation) {
		this.localisation = localisation;
		vitesse = ARRET;
	}
	public void rapide() {
		vitesse = RAPIDE;
		// code pour r�gler la vitesse sur rapide
	}
	public void moyen() {
		vitesse = MOYEN;
		// code pour r�gler la vitesse sur moyen
	}
	public void lent() {
		vitesse = LENT;
		// code pour r�gler la vitesse sur lent
	}
	public void arret() {
		vitesse = ARRET;
		// code pour arr�ter le ventilateur
	}
	public int getVitesse() {
		return vitesse;
	}

}
