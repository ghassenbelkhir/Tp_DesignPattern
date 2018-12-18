
public class TelecommandeAvecAnnul {

	Commande[] commandesMarche;
	Commande[] commandesArret;
	Commande commandeAnnulation;
	public TelecommandeAvecAnnul() {
		commandesMarche = new Commande[7];
		commandesArret = new Commande[7];
		Commande pasDeCommande = new PasDeCommande();

		for(int i=0;i<7;i++) {
			commandesMarche[i] = pasDeCommande;
			commandesArret[i] = pasDeCommande;
		}
		commandeAnnulation = pasDeCommande;
	}
	public void setCommande(int empt, Commande comMarche, Commande comArret) {
		commandesMarche[empt] = comMarche;
		commandesArret[empt] = comArret;
	}
	public void boutonMarchePresse(int empt) {
		commandesMarche[empt].executer();
		commandeAnnulation = commandesMarche[empt];
	}
	public void boutonArretPresse(int empt) {
		commandesArret[empt].executer();
		commandeAnnulation = commandesArret[empt];
	}
	public void boutonAnnulPresse() {
		commandeAnnulation.annuler();
	}
	
}