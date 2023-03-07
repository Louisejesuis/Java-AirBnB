package louise.airbnb.reservations;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import louise.airbnb.outils.MaDate;
import louise.airbnb.utilisateurs.Voyageur;

public class Reservation {

	private int identifiant;
	private Sejour sejour;
	private Voyageur voyageur;
	private boolean estValidee;
	private Date dateDeReservation;

	private static final AtomicInteger ID_FACTORY = new AtomicInteger();

	public Reservation(Sejour sejour, Voyageur voyageur) throws Exception {
		if (!sejour.verificationContrat()) {
			String message = (!sejour.verificationDateArrivee()) ? "La date d'arrivée est avant aujourd'hui\n " : "";
			message += (!sejour.verificationNombreDeNuits()) ? "Le nombre de nuit doit être entre 1 et 31\n" : "";
			message += (!sejour.verificationNombreDeVoyageurs())
					? "Le nombre de voyageurs est supérieur à la taille du logement"
					: "";
			throw new Exception("Sejour invalide : " + message);
		}
		this.identifiant = ID_FACTORY.getAndIncrement();
		this.sejour = sejour;
		this.voyageur = voyageur;
		this.estValidee = false;
		this.dateDeReservation = new MaDate();
	}

	public void afficher() {

		System.out.print("Voyageur : ");
		voyageur.afficher();
		System.out.println("Réservé le : " + dateDeReservation);
		sejour.afficher();
	}

	@Override
	public String toString() {
		return "Voyageur : " + voyageur + "\n" + sejour + "\nRéserver le : " + dateDeReservation;
	}

}
