package louise.airbnb.utilisateurs;

import java.util.Objects;

public class Hote extends Personne {

	private int delaiDeReponse;

	public Hote(String prenom, String nom, int age, int delaiDeReponse) {
		super(prenom, nom, age);
		this.delaiDeReponse = delaiDeReponse;
	}

	public String toString() {
		return super.toString() + getDelaiDeReponseToString();
	}

	private String getDelaiDeReponseToString() {
		return " qui s'engage à répondre dans les " + delaiDeReponse + (delaiDeReponse == 1 ? " heure." : " heures.");
	}

	@Override
	public void afficher() {
		System.out.println(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(delaiDeReponse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj) || !(obj instanceof Hote)) {
			return false;
		}
		Hote hote = (Hote) obj;
		if (!Objects.equals(hote.delaiDeReponse, delaiDeReponse)) {
			return false;
		}
		return true;
	}

}
