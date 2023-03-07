package louise.airbnb.reservations;

import java.util.Date;

import louise.airbnb.logements.Logement;
import louise.airbnb.outils.MaDate;

public class SejourFactory {

	public static Sejour createSejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {

		Sejour sejour;
		Date debutWE = new MaDate(25, 02, 2023);
		if (dateArrivee.equals(debutWE) && nbNuits == 1) {
			sejour = new SejourSpecialCarnaval(dateArrivee, nbNuits, logement, nbVoyageurs);

		} else if (nbNuits >= 1 && nbNuits < 6) {
			sejour = new SejourCourt(dateArrivee, nbNuits, logement, nbVoyageurs);

		} else {
			sejour = new SejourLong(dateArrivee, nbNuits, logement, nbVoyageurs);

		}

		System.out.println(sejour.verificationDateArrivee());

		return sejour;
	}

}
