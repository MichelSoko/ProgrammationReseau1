package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Dico extends Hashtable<String, String> {

	// Attributs
	private static final long serialVersionUID = 1L;
	URLConnection urlConnection;

	// Constructeur
	public Dico(String unURL) {
		try {
			URL url = new URL(unURL);
			urlConnection = url.openConnection();
		} catch (IOException e) {
			 System.out.println(e.getMessage());
		}
	}

	// Méthodes
	public void info() {
		System.out.println("Type de doc : " + urlConnection.getContentType());
		System.out.println("Taille du doc : " + urlConnection.getContentLength());
		System.out.println("Droit lecture : " + urlConnection.getDoInput());
		System.out.println("Droit écriture: " + urlConnection.getDoOutput());
	}

	public void charger() {
		try {
			info();
			System.out.println("***** Eléments du dictionnaire *****");

			BufferedReader flux = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			String elementDuDico;
			while ((elementDuDico = flux.readLine()) != null) {
				StringTokenizer st;
				st = new StringTokenizer(elementDuDico, "/");
				put(st.nextToken(), st.nextToken());
			}
			flux.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String consulter(String clef) {
		try {
			return get(clef);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}