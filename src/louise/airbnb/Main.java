package louise.airbnb;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

import louise.airbnb.logements.Appartement;
import louise.airbnb.logements.Maison;
import louise.airbnb.outils.MaDate;
import louise.airbnb.reservations.Reservation;
import louise.airbnb.reservations.Sejour;
import louise.airbnb.reservations.SejourFactory;
import louise.airbnb.utilisateurs.Hote;
import louise.airbnb.utilisateurs.Voyageur;

public class Main {

	public static void main(String[] args) throws ParseException {

		Hote hote1 = new Hote("Louise", "Roy", 23, 7);

		Voyageur voyageur1 = new Voyageur("Jean", "Pierre", 52);

		Appartement appart1 = new Appartement(hote1, 80, "14 rue Constantine, 37000 Tours", 50, 3, 2, 90, "appart 1");
		Maison maison1 = new Maison(hote1, 5000, "5 rue du truc, tours", 5000, 2, 12, true, "maison 1");

		MaDate dateArriveeSejour1 = new MaDate(21, 05, 2023);

		Sejour sejour1 = SejourFactory.createSejour(dateArriveeSejour1, 12, maison1, 2);

		try {
			Reservation reservation1 = new Reservation(sejour1, voyageur1);
			reservation1.afficher();

			Path path = Paths.get("C:\\Users\\lroy\\Documents\\🏫 2. CEFIM\\Java\\reservation.txt");
			try {
				String str = reservation1.toString();
				byte[] bs = str.getBytes();
				Path writtenFilePath = Files.write(path, bs);
				System.out.println("Written content in file:\n" + new String(Files.readAllBytes(writtenFilePath)));

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
