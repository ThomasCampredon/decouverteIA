package apprentissage;

import java.util.ArrayList;
import java.util.Collections;

public class Generateur {

	public static ArrayList<ArrayList<Integer>> genererBinaire (int longueur) {
		ArrayList<ArrayList<Integer>> liste = new ArrayList<>();
		int nombreDeValeur = (int) Math.pow(longueur,2);
		
		for (int i = 0 ; i < nombreDeValeur ; i++) {
			ArrayList<Integer> binaire = new ArrayList<>();
			int nombre = i;
			int reste = 0;
			do {
				reste = nombre % 2;
				binaire.add(reste);
				nombre = (nombre - reste)/2;
			}while (nombre!=0);
			
			while (binaire.size()<4) {
				binaire.add(0);
			}
			Collections.reverse(binaire);
			liste.add(binaire);
		}
		
		return liste;
	}
}
