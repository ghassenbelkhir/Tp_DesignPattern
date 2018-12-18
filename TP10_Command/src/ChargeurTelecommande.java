
public class ChargeurTelecommande {

	public static void main(String[] args) {
		TelecommandeAvecAnnul teleCommande = new TelecommandeAvecAnnul();
		Ventilateur ventilateur = new Ventilateur("Séjour");
		CommandeVentilateurMoyen ventilMoyen =
				new CommandeVentilateurMoyen(ventilateur);
		CommandeVentilateurRapide ventilRapide =
				new CommandeVentilateurRapide(ventilateur);
		CommandeEteindreVentilateur ventilateurEteint =
				new CommandeEteindreVentilateur(ventilateur);
		teleCommande.setCommande(0, ventilMoyen, ventilateurEteint);
		teleCommande.setCommande(1, ventilRapide, ventilateurEteint);
		teleCommande.boutonMarchePresse(0);
		teleCommande.boutonArretPresse(0);
		System.out.println(teleCommande);
		teleCommande.boutonAnnulPresse();
		teleCommande.boutonMarchePresse(1);
		System.out.println(teleCommande);
		teleCommande.boutonAnnulPresse();
	}
}
