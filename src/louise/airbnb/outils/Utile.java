package louise.airbnb.outils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class Utile {

	public static Date creerDate(String date) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(date);
	}

	public static String formatDate(Date date) {
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}

	public static String formatDatev2(Date date) {

		// Récupère le jour
		int jour = date.getDate();

		// Récupère le mois + 1 car getMonth() part de janvier = 0
		int mois = date.getMonth() + 1;

		// Récupère l'année + 1900 car getYear renvois l'année -1900
		int annee = date.getYear() + 1900;

		return
		// Retourne le jour avec un zéro devant si le jour < 10
		(jour < 10 ? "0" + jour : jour) + "/" +
		// Retourne le mois avec un zéro devant si le mois < 10
				(mois < 10 ? "0" + mois : mois) + "/" + annee;
	}

	public static String formatDatev3(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int jour = calendar.get(Calendar.DAY_OF_MONTH);

		// Récupère le mois + 1 car get(Calendar.MONTH) part de janvier = 0
		int mois = calendar.get(Calendar.MONTH) + 1;

		int annee = calendar.get(Calendar.YEAR);

		return
		// Retourne le jour avec un zéro devant si le jour < 10
		(jour < 10 ? "0" + jour : jour) + "/" +
		// Retourne le mois avec un zéro devant si le mois < 10
				(mois < 10 ? "0" + mois : mois) + "/" + annee;
	}

}
