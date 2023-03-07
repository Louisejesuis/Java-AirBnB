package louise.airbnb.reservations;

import java.util.Date;

import louise.airbnb.logements.Logement;

public abstract class Sejour implements SejourInterface {

	protected Date dateArrivee;
	protected int nbNuits;
	private Logement logement;
	private int nbVoyageurs;
	protected int tarif;

	Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
		this.dateArrivee = dateArrivee;
		this.nbNuits = nbNuits;
		this.logement = logement;
		this.nbVoyageurs = nbVoyageurs;
		miseAJourDuTarif();
	}

	public String toString() {
		return "La date d'arrivée est le " + dateArrivee + " pour " + nbNuits + " nuits.";
	}

	public void afficher() {
		logement.afficher();
		System.out.println(this);
	}

	public int getTarifInitial() {
		return logement.getTarifParNuit() * nbNuits;
	}

	@Override
	public boolean verificationDateArrivee() {
		return dateArrivee.after(new Date());
	}

	@Override
	public boolean verificationNombreDeVoyageurs() {
		return nbVoyageurs <= logement.getNbVoyageursMax();
	}

	public abstract void miseAJourDuTarif();

	public boolean verificationContrat() {
		return (verificationDateArrivee() && verificationNombreDeNuits() && verificationNombreDeVoyageurs());
	}
}
