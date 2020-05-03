package apprentissage;

import java.util.ArrayList;
import java.util.Collections;

public class Generateur {

	// méthode qui génère tous les binaire de longueur longueur
	public static ArrayList<ArrayList<Integer>> genererBinaire (int longueur) {
		ArrayList<ArrayList<Integer>> liste = new ArrayList<>();
		int nombreDeValeur = (int) Math.pow(2, longueur); //calcul du nombre de valeurs différentes
		
		//pour chaque valeur de 0 au nombre de valeur possible
		for (int i = 0 ; i < nombreDeValeur ; i++) {
			ArrayList<Integer> binaire = new ArrayList<>(); //liste qui contiendra le binaire
			int nombre = i;
			int reste = 0;
			
			// on définit chaque bit
			do {
				reste = nombre % 2;
				binaire.add(reste);
				nombre = (nombre - reste)/2;
			}while (nombre!=0);
			
			// on complete avec des zeros tant que notre binaire n'a pas la taille souhaitée
			while (binaire.size()<longueur) {
				binaire.add(0);
			}
			
			// on inverse le binaire pour le mettre dans le bon sens
			Collections.reverse(binaire);
			
			// on l'ajoute à la liste finale
			liste.add(binaire);
		}
		
		return liste;
	}
}
