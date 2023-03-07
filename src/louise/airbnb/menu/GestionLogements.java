package louise.airbnb.menu;

import louise.airbnb.logements.Appartement;
import louise.airbnb.logements.Logement;
import louise.airbnb.logements.Maison;
import louise.airbnb.utilisateurs.Hote;

class GestionLogements {

	static void listerLogements() {

		System.out.println("-------------------------------------");
		System.out.println("Liste des logements ");

		int count = 0;
		for (Logement logement : Menu.listLogements) {
			System.out.print("n°" + count + " : ");
			logement.afficher();
			System.out.println("****");
			count++;
		}

		System.out.println("-------------------------------------");
		System.out.println("Saisir une option : ");
		System.out.println("1 : Ajouter un logement");
		System.out.println("2 : Supprimer un logement");
		System.out.println("3 : Retour");

		switch (Menu.choix(3)) {
		case 1:
			try {
				ajouterLogement();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			supprimerHote();
			break;
		case 3:
			Menu.listerMenu();
			break;
		}
	}

	private static void ajouterLogement() throws Exception {

		Logement logement;

		System.out.println("-------------------------------------");
		System.out.println("Ajouter un nouveau logement");

		System.out.println("Choisir l'hôte : ");
		int count = 0;
		for (Hote hote : Menu.listHotes) {
			System.out.println("n°" + count + " : " + hote);
			count++;
		}
		Hote hote = Menu.listHotes.get(Menu.scanner.nextInt());

		System.out.print("Tarif par nuit : ");
		int tarifParNuit = Menu.scanner.nextInt();

		System.out.print("Adresse : ");
		String adresse = Menu.scanner.next();

		System.out.print("Superficie : ");
		int superficie = Menu.scanner.nextInt();

		System.out.print("Nombre de voyageur maximum : ");
		int nbVoyageursMax = Menu.scanner.nextInt();
		System.out.println("Ajouter un appartement[0] ou une maison[1] ?");
		int estUneMaison = Menu.scanner.nextInt();
		if (estUneMaison == 1) {

			System.out.print("Superficie jardin : ");
			int superficieJardin = Menu.scanner.nextInt();

			boolean possedePiscine;
			System.out.print("Possède une piscine ? 0 : oui, 1 : non ");
			if (Menu.scanner.nextInt() == 0) {
				possedePiscine = true;
			} else {
				possedePiscine = false;
			}

			logement = new Maison(hote, tarifParNuit, adresse, superficie, nbVoyageursMax, superficieJardin,
					possedePiscine);

		} else if (estUneMaison == 0) {

			System.out.print("Numéro d'étage : ");
			int numeroEtage = Menu.scanner.nextInt();

			System.out.print("Superficie Balcon : ");
			int superficieBalcon = Menu.scanner.nextInt();
			logement = new Appartement(hote, tarifParNuit, adresse, superficie, nbVoyageursMax, numeroEtage,
					superficieBalcon);
		} else {
			throw new Exception("Choix invalide");
		}
		Menu.listLogements.add(logement);
		listerLogements();
	}

	private static void supprimerHote() throws IndexOutOfBoundsException {

		System.out.println("-------------------------------------");
		System.out.println("Supprimer un hôte");

		System.out.print("Numéro de l'hôte à supprimer : ");
		int hoteIndex = Menu.scanner.nextInt();

		Menu.listHotes.remove(hoteIndex);

		listerLogements();
	}

}
