package louise.airbnb.menu;

import java.util.InputMismatchException;

import louise.airbnb.utilisateurs.Hote;

class GestionHotes {

	static void listerHotes() {

		System.out.println("-------------------------------------");
		System.out.println("Liste des hôtes ");

		int count = 0;
		for (Hote hote : Menu.listHotes) {
			System.out.println("n°" + count + " : " + hote);
			count++;
		}

		System.out.println("-------------------------------------");
		System.out.println("Saisir une option : ");
		System.out.println("1 : Ajouter un hôte");
		System.out.println("2 : Supprimer un hôte");
		System.out.println("3 : Retour");

		switch (Menu.choix(3)) {
		case 1:
			try {
				ajouterHote();
				System.out.println("Votre hôte a été ajouté avec succès !");
			} catch (Exception e) {
				System.out.println("Saisie invalide, recommencer.");
				Menu.scanner.next();
			}
			listerHotes();
			break;
		case 2:
			try {
				supprimerHote();
				System.out.println("Votre hôte a été supprimé avec succès !");
			} catch (Exception e) {
				System.out.println("Saisie invalide, recommencer.");
				Menu.scanner.next();
			}
			listerHotes();
			break;
		case 3:
			Menu.listerMenu();
			break;
		}
	}

	private static void ajouterHote() throws InputMismatchException {

		System.out.println("-------------------------------------");
		System.out.println("Ajouter un nouvel hôte");

		System.out.print("Prénom : ");
		String prenom = Menu.scanner.next();

		System.out.print("Nom : ");
		String nom = Menu.scanner.next();

		System.out.print("Age : ");
		int age = Menu.scanner.nextInt();

		System.out.print("Délais de réponse : ");
		int delaiDeReponse = Menu.scanner.nextInt();

		Hote hote = new Hote(prenom, nom, age, delaiDeReponse);
		Menu.listHotes.add(hote);

	}

	private static void supprimerHote() throws InputMismatchException, IndexOutOfBoundsException {

		System.out.println("-------------------------------------");
		System.out.println("Supprimer un hôte");

		System.out.print("Numéro de l'hôte à supprimer : ");
		int hoteIndex = Menu.scanner.nextInt();

		Menu.listHotes.remove(hoteIndex);

		listerHotes();
	}

}
