package louise.airbnb.reservations;

import java.util.Date;

import louise.airbnb.logements.Logement;

public class SejourLong extends Sejour implements ConditionsTarifairesInterface {

	private int promotion;
	private static final int PROMOTION_EN_POURCENTAGE = 20;

	SejourLong(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
		super(dateArrivee, nbNuits, logement, nbVoyageurs);
	}

	@Override
	public boolean beneficiePromotion() {
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "\nLe prix de ce sejour long est " + tarif + "€ (" + promotion + "€ de promotion).";
	}

	@Override
	public boolean verificationNombreDeNuits() {
		return (nbNuits >= 6 && nbNuits <= 31);
	}

	@Override
	public void miseAJourDuTarif() {
		this.promotion = (getTarifInitial() * PROMOTION_EN_POURCENTAGE) / 100;
		this.tarif = getTarifInitial() - promotion;

	}

}
