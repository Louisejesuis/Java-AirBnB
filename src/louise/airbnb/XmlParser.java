package louise.airbnb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import louise.airbnb.logements.Appartement;
import louise.airbnb.logements.Logement;
import louise.airbnb.logements.Maison;
import louise.airbnb.utilisateurs.Hote;

public class XmlParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.parse(new File("src/louise/airbnb/logements.xml"));

		document.getDocumentElement().normalize();

		List<Logement> logements = new ArrayList<Logement>();
		List<Hote> hotes = new ArrayList<Hote>();

		NodeList nodeList = document.getDocumentElement().getChildNodes();

		for (int index = 0; index < nodeList.getLength(); index++) {

			Node node = nodeList.item(index);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element element = (Element) node;

				// Nom de l'élément
				String codeName = element.getNodeName();

				// Création de l'hote
				String nomHote = getElement(element, "nom");
				String prenomHote = getElement(element, "prenom");
				int ageHote = Integer.parseInt(getElement(element, "age"));
				int delaiDeReponseHote = Integer.parseInt(getElement(element, "delaiReponse"));

				Hote tempHote = new Hote(prenomHote, nomHote, ageHote, delaiDeReponseHote);

				Hote hote = getHote(tempHote, hotes);

				// Début création logement
				String nom = element.getAttribute("name");
				int tarifParNuit = Integer.parseInt(getElement(element, "tarifParNuit"));
				String adresse = getElement(element, "adresse");
				int superficie = Integer.parseInt(getElement(element, "superficie"));
				int nbVoyageursMax = Integer.parseInt(getElement(element, "nbVoyageursMax"));

				if (codeName == "Appartement") {
					// Création d'un appartement
					int numeroEtage = Integer.parseInt(getElement(element, "numeroEtage"));
					int superficieBalcon = Integer.parseInt(getElement(element, "superficieBalcon"));
					Appartement appart = new Appartement(hote, tarifParNuit, adresse, superficie, nbVoyageursMax,
							numeroEtage, superficieBalcon, nom);
					logements.add(appart);
				} else {
					// Création d'une maison
					int superficieJardin = Integer.parseInt(getElement(element, "superficieJardin"));
					boolean possedePiscine = Boolean.parseBoolean(getElement(element, "possedePiscine"));

					Maison maison = new Maison(hote, tarifParNuit, adresse, superficie, nbVoyageursMax,
							superficieJardin, possedePiscine, nom);
					logements.add(maison);
				}
			}
		}

		System.out.println("Logements : ");
		for (Logement logement : logements) {
			System.out.println(logement);
			System.out.println("**********");
		}

		System.out.println("--------------------------------");

		System.out.println("Hôte : ");
		for (Hote hote : hotes) {
			System.out.println(hote);
			System.out.println("**********");
		}

	}

	/**
	 * Retourne l'hote à lié au logement Ajoute le bon hote unique à la liste hotes
	 * 
	 * @param currentHote
	 * @param hotes
	 * @return hote
	 */
	private static Hote getHote(Hote currentHote, List<Hote> hotes) {
		for (Hote hote : hotes) {
			if (currentHote.equals(hote)) {
				return hote;
			}
		}
		hotes.add(currentHote);
		return currentHote;

	}

	/**
	 * Retourne la valeur d'un element
	 * 
	 * @param element
	 * @param tagName
	 * @return
	 */
	private static String getElement(Element element, String tagName) {
		String value = null;
		try {
			value = element.getElementsByTagName(tagName).item(0).getTextContent();
		} catch (Exception e) {
			System.out.println("Probleme");
		}
		return value;
	}
}