package apprentissage;

import java.util.ArrayList;

public class Main {
	static int nombreDeBit = 4; //on choisit la longueur des entr�es
	static ArrayList <ArrayList<Integer>> motifs = Generateur.genererBinaire(nombreDeBit); //on g�n�re les motifs 
	
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
				int attendu = 0; //on initialise la valeur que le neurone doit renvoy�
				
				// on choisi le mod�le qui devra donner 1
				if ((motifCourant.get(0) == 1) && (motifCourant.get(3)==1) && (motifCourant.get(1)==0) && (motifCourant.get(2)==0)){ 
					attendu=1;
				}
				
				boolean result = neurone.apprendre(motifCourant, attendu); //indique le resultat du neurone
				
				// on teste si un result est faux, si c'est le cas, alors on continue � it�rer
				if (result == false) {
					end = false;
				}
				
				
				int z = 0;
				
				// on n'a pas acc�s � la valeur de sortie de la neurone, donc on la d�duit
				if ((attendu==1)&&(result==true)){
					z = 1;
				}
				
				// on transmet les valeurs � afficher
				afficherInfo(motifCourant,neurone, iteration, idMotif, attendu, z);
				
				// on incr�mente l'identifiant du motif � tester
				idMotif+=1;
			}
			System.out.println("\n");
		}
	}
	
	// m�thode qui affiche les r�sultats
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





