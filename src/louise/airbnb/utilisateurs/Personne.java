package louise.airbnb.utilisateurs;

import java.util.Objects;

public class Personne {
	private String prenom;
	private String nom;
	private int age;

	public Personne(String prenom, String nom, int age) {
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
	}

	public String toString() {
		return prenom + " " + nom + " ( " + age + " ans )";
	}

	public void afficher() {
		System.out.println(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Personne)) {
			return false;
		}
		Personne personne = (Personne) obj;

		if (!Objects.equals(nom, personne.nom) || !Objects.equals(prenom, personne.prenom) || age != personne.age) {
			return false;
		}
		return true;
	}
}
