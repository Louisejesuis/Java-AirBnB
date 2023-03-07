package louise.airbnb.reservations;

import java.util.Date;

import louise.airbnb.logements.Logement;

public class SejourCourt extends Sejour implements ConditionsTarifairesInterface {

	SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
		super(dateArrivee, nbNuits, logement, nbVoyageurs);
	}

	@Override
	public boolean beneficiePromotion() {
		return false;
	}

	public String toString() {
		return super.toString() + "\nLe prix de ce sejour court est " + tarif + "€.";
	}

	@Override
	public boolean verificationNombreDeNuits() {
		return (nbNuits >= 1 && nbNuits < 6);
	}

	@Override
	public void miseAJourDuTarif() {
		tarif = getTarifInitial();
	}

}
