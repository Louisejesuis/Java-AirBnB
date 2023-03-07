package louise.airbnb.reservations;

public interface SejourInterface {

	/**
	 * Retourne vrai si la date d'arrivée est après la date du jour, sinon retourne
	 * faux
	 */
	public boolean verificationDateArrivee();

	/**
	 * Retourne vrai si le nombre de nuits est compris entre 1 et 31, sinon retourne
	 * faux
	 */
	public boolean verificationNombreDeNuits();

	/**
	 * Retourne vrai si le nombre de voyageur de la réservation est inférieur ou
	 * égale au nombre de voyageur max du logement, sinon retourne faux
	 */
	public boolean verificationNombreDeVoyageurs();

	public void afficher();
}
