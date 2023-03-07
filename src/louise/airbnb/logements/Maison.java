package louise.airbnb.logements;

import louise.airbnb.utilisateurs.Hote;

public class Maison extends Logement {

	private int superficieJardin;
	private Boolean possedePiscine;

	public Maison(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int superficieJardin,
			Boolean possedePiscine, String nom) {
		super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax, nom);
		this.superficieJardin = superficieJardin;
		this.possedePiscine = possedePiscine;
	}

	@Override
	public String toString() {
		String message = nom + "\n" + getHoteToString() + "\nLe logement est un appartement situé " + getAdresse()
				+ " au " + "\n" + getSuperficieToString() + "\n" + getSuperficieJardinToString() + "\n"
				+ getPossedePiscineToString();
		return message;
	}

	@Override
	public void afficher() {
		System.out.println(this);
	}

	@Override
	public int getSuperficieTotal() {
		return getSuperficie() + superficieJardin;
	}

	private String getSuperficieToString() {
		return "Superficie : " + getSuperficieTotal() + "m2";
	}

	private String getSuperficieJardinToString() {
		return "Jardin : " + (superficieJardin <= 0 ? "Non" : "Oui (" + superficieJardin + "m2)");
	}

	private String getHoteToString() {
		return "Hôte : " + getHote();
	}

	private String getPossedePiscineToString() {
		return "Piscine : " + (possedePiscine ? "Oui" : "Non");
	}

}
