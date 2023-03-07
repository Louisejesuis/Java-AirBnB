package louise.airbnb.logements;

import louise.airbnb.utilisateurs.Hote;

public class Appartement extends Logement {

	private int numeroEtage;
	private int superficieBalcon;

	public Appartement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int numeroEtage,
			int superficieBalcon, String nom) {
		super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax, nom);
		this.numeroEtage = numeroEtage;
		this.superficieBalcon = superficieBalcon;
	}

	@Override
	public String toString() {
		String message = nom + "\n" + getHoteToString() + "\nLe logement est un appartement situé " + getAdresse()
				+ " au " + getNumeroEtageToString() + "\n" + getSuperficieToString() + "\n"
				+ getsuperficieBalconToString();
		return message;
	}

	@Override
	public void afficher() {

		System.out.println(this);

	}

	@Override
	public int getSuperficieTotal() {
		return getSuperficie() + superficieBalcon;
	}

	private String getNumeroEtageToString() {
		String etageToString;
		if (numeroEtage == 0) {
			etageToString = "rez de chaussée";
		} else if (numeroEtage == 1) {
			etageToString = "1er étage";
		} else {
			etageToString = numeroEtage + "ème étage";
		}
		return etageToString;
	}

	private String getSuperficieToString() {
		return "Superficie : " + getSuperficieTotal() + "m2";
	}

	private String getsuperficieBalconToString() {
		return "Balcon : " + (superficieBalcon <= 0 ? "Non" : "Oui (" + superficieBalcon + "m2)");
	}

	private String getHoteToString() {
		return "Hôte : " + getHote();
	}

}
