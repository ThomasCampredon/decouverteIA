package apprentissage;

import java.util.ArrayList;

public class Main {
	static int nombreDeBit = 4; //on choisit la longueur des entrées
	static ArrayList <ArrayList<Integer>> motifs = Generateur.genererBinaire(nombreDeBit); //on génère les motifs 
	
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
			
			
			while (motifs.size()>idMotif) {
				ArrayList<Integer> motifCourant = motifs.get(idMotif);
				int attendu = 0; //on initialise la valeur que le neurone doit renvoyé
				
				// on choisi le modèle qui devra donner 1
				if ((motifCourant.get(0) == 1) && (motifCourant.get(3)==1) && (motifCourant.get(1)==0) && (motifCourant.get(2)==0)){ 
					attendu=1;
				}
				
				boolean result = neurone.apprendre(motifCourant, attendu); //indique le resultat du neurone
				
				// on teste si un result est faux, si c'est le cas, alors on continue à itérer
				if (result == false) {
					end = false;
				}
				
				
				int z = 0;
				
				// on n'a pas accès à la valeur de sortie de la neurone, donc on la déduit
				if ((attendu==1)&&(result==true)){
					z = 1;
				}
				
				// on transmet les valeurs à afficher
				afficherInfo(motifCourant,neurone, iteration, idMotif, attendu, z);
				
				// on incrémente l'identifiant du motif à tester
				idMotif+=1;
			}
			System.out.println("\n");
		}
	}
	
	// méthode qui affiche les résultats
	public static void afficherInfo(ArrayList<Integer>motif, Neurone neurone, int iteration, int idMotif, int d, int z) {
		ArrayList <Double> poids = (ArrayList<Double>) neurone.getPoids();
		String info="";
		
		if (z==d) {
			info+="     ";
		}else {
			info+="---> ";
		}
		
		 info += "E" + iteration + "." + (idMotif+1) + " : " + motif.toString() + " : z= " + z + "  d= " + d
				+ " : ";
		
		for (int i = 0 ; i < poids.size(); i++) {
			info+=poids.get(i)+"  ";
		}
		
		info+=neurone.getPoid0();
		
		System.out.println(info);
	}

}





