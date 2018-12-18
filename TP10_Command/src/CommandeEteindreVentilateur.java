
public class CommandeEteindreVentilateur implements Commande {
	Ventilateur ventilateur;
	int derniereVitesse;
	public CommandeEteindreVentilateur(Ventilateur ventilateur) {
		this.ventilateur = ventilateur;
	}
	public void executer() {
		derniereVitesse = ventilateur.getVitesse();
		ventilateur.arret();
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
