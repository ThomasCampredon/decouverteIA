package apprentissage;

import java.util.ArrayList;

public class Main {
	static int nombreDeBit = 4;
	static ArrayList <ArrayList<Integer>> motifs = Generateur.genererBinaire(nombreDeBit);
	
	public static void main(String[] args) {
		Neurone neurone = new Neurone(2);
		neurone.initialiserLesPoids(nombreDeBit);
		apprentissage(motifs, neurone);
	}
	
	
	
	
	public static void apprentissage(ArrayList<ArrayList<Integer>>motifs, Neurone neurone) {
		int iteration = 0; //nombre de passage sur tous les motifs
		int idMotif; // identifiant du motif testé
		boolean end = false; //indique si l'apprentissage est terminé
		
		while (!end) {
			end = true;
			iteration+=1;
			idMotif=0;
			boolean result; //indique si le neuronne à donner la bonne réponse
			
			while (motifs.size()>idMotif) {
				ArrayList<Integer> motifCourant = motifs.get(idMotif);
				int attendu = 0;
				
				// on choisi le modèle qui devra donner 1
				if (motifCourant.get(0) == motifCourant.get(3)){ 
					attendu=1;
				}
				result = neurone.apprendre(motifCourant, attendu);
				if (result == false) {
					end = false;
				}
				
				int z = 1;
				if ((attendu==1)&&(result==true)){
					z = 0;
				}
				afficherInfo(motifCourant,neurone, iteration, idMotif, attendu, z);
				idMotif+=1;
			}
			System.out.println("\n");
		}
	}
	
	public static void afficherInfo(ArrayList<Integer>motif, Neurone neurone, int iteration, int idMotif, int d, int z) {
		ArrayList <Double> poids = (ArrayList<Double>) neurone.getPoids();
		String info = "E" + iteration + "." + idMotif + " : " + motif.toString() + " : z= " + z + "  d= " + d
				+ " : ";
		
		for (int i = 0 ; i < poids.size(); i++) {
			info+=poids.get(i)+" ";
		}
		
		info+=neurone.getPoid0()+"\n";
		
		System.out.println(info);
	}

}





