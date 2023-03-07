package louise.airbnb.reservations;

import java.util.Date;

import louise.airbnb.logements.Logement;
import louise.airbnb.outils.MaDate;

public class SejourSpecialCarnaval extends Sejour implements ConditionsTarifairesInterface {

	private static final int PROMOTION_EN_EUROS = 50;

	SejourSpecialCarnaval(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
		super(dateArrivee, nbNuits, logement, nbVoyageurs);
	}

	@Override
	public boolean verificationNombreDeNuits() {
		return (nbNuits == 2);
	}

	@Override
	public boolean beneficiePromotion() {
		return true;
	}

	@Override
	public void miseAJourDuTarif() {
		this.tarif = Math.max(getTarifInitial() - PROMOTION_EN_EUROS, 0);
	}

	@Override
	public boolean verificationDateArrivee() {
		Date debutWE = new MaDate(25, 02, 2023);
		return (dateArrivee.equals(debutWE) && nbNuits == 1);
	}

	@Override
	public String toString() {
		return super.toString() + "\nLe prix de ce sejour spécial carnaval est " + tarif + "€ (50€ de promotion).";
	}
}
