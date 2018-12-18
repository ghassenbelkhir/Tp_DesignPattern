
public class CommandeVentilateurMoyen implements Commande{
	
	Ventilateur ventilateur;
	int derniereVitesse;
	public CommandeVentilateurMoyen(Ventilateur ventilateur) {
		this.ventilateur = ventilateur;
	}
	public void executer() {
		derniereVitesse = ventilateur.getVitesse();
		ventilateur.moyen();
	}
	public void annuler() {
		if (derniereVitesse == Ventilateur.RAPIDE) {
			ventilateur.rapide();
		} else if (derniereVitesse == Ventilateur.MOYEN) {
			ventilateur.moyen();
		} else if (derniereVitesse == Ventilateur.LENT) {
			ventilateur.lent();
		} else if (derniereVitesse == Ventilateur.ARRET) {
			ventilateur.arret();
		}
	}

}
