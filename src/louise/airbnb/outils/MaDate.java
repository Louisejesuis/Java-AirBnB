package louise.airbnb.outils;

import java.util.Date;

public class MaDate extends Date {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param jour  de 1 à 31
	 * @param mois  de 1 à 12 ( Janvier = 1 )
	 * @param annee ( ex : 2023 )
	 */
	@SuppressWarnings("deprecation")
	public MaDate(int jour, int mois, int annee) {
		super(annee - 1900, mois - 1, jour);
	}

	public MaDate() {
		super();
	}

	/**
	 * Retourne la date au format dd/MM/Y
	 */
	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		// Récupère le jour
		int jour = getDate();

		// Récupère le mois + 1 car getMonth() part de janvier = 0
		int mois = getMonth() + 1;

		// Récupère l'année + 1900 car getYear renvois l'année -1900
		int annee = getYear() + 1900;

		return
		// Retourne le jour avec un zéro devant si le jour < 10
		(jour < 10 ? "0" + jour : jour) + "/" +
		// Retourne le mois avec un zéro devant si le mois < 10
				(mois < 10 ? "0" + mois : mois) + "/" + annee;
	}

}
