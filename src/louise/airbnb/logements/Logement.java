package louise.airbnb.logements;

import louise.airbnb.utilisateurs.Hote;

public abstract class Logement {

	private Hote hote;
	private int tarifParNuit;
	private String adresse;
	private int superficie;
	private int nbVoyageursMax;
	protected String nom;

	public Logement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, String nom) {
		this.hote = hote;
		this.tarifParNuit = tarifParNuit;
		this.adresse = adresse;
		this.superficie = superficie;
		this.nbVoyageursMax = nbVoyageursMax;
		this.nom = nom;
	}

	public abstract void afficher();

	public abstract int getSuperficieTotal();

	public int getTarifParNuit() {
		return tarifParNuit;
	}

	public Hote getHote() {
		return hote;
	}

	public String getAdresse() {
		return adresse;
	}

	public int getSuperficie() {
		return superficie;
	}

	public int getNbVoyageursMax() {
		return nbVoyageursMax;
	}

}
