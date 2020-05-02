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
		int idMotif; // identifiant du motif test�
		boolean end = false; //indique si l'apprentissage est termin�
		
		while (!end) {
			end = true;
			iteration+=1;
			idMotif=0;
			
			
			while (motifs.size()>idMotif) {
				ArrayList<Integer> motifCourant = motifs.get(idMotif);
				int attendu = 0;
				
				// on choisi le mod�le qui devra donner 1
				if ((motifCourant.get(0) == 1) && (motifCourant.get(3)==1) && (motifCourant.get(1)==0) && (motifCourant.get(2)==0)){ 
					attendu=1;
				}
				
				boolean result = neurone.apprendre(motifCourant, attendu); //indique le resultat du neurone
				if (result == false) {
					end = false;
				}
				
				int z = 0;
				if ((attendu==1)&&(result==true)){
					z = 1;
				}
				
				afficherInfo(motifCourant,neurone, iteration, idMotif, attendu, z);
				idMotif+=1;
			}
			System.out.println("\n");
		}
	}
	
	public static void afficherInfo(ArrayList<Integer>motif, Neurone neurone, int iteration, int idMotif, int d, int z) {
		ArrayList <Double> poids = (ArrayList<Double>) neurone.getPoids();
		String info="";
		
		if (z==d) {
			info+="TRUE ";
		}else {
			info+="     ";
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





