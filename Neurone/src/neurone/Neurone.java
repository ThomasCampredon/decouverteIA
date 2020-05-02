package neurone;

import java.util.ArrayList;
import java.util.List;

public class Neurone {
	private List <Double> poids;
	private double seuil;
	
	public Neurone (List<Double> poids, double seuil) {
		this.poids=poids;
		this.seuil=seuil;
	}
	
	public Neurone (double seuil) {
		this.poids=new ArrayList<Double>();
		this.seuil=seuil;
	}
	
	public double somme(List<Integer> entrees) {
		double somme = 0;
		
		for (int i = 0 ; i <entrees.size(); i++) {
			somme+=entrees.get(i)*this.poids.get(i);
		}
		
		return somme;
	}
	
	public int evaluer(List<Integer> entrees) {
		if (somme(entrees)>=this.seuil) {
			return 1;
		}
		return 0;
	}
	
	
	
	public List<Double> getPoids() {
		return poids;
	}

	public void setPoids(List<Double> poids) {
		this.poids = poids;
	}

	public double getSeuil() {
		return seuil;
	}

	public void setSeuil(double seuil) {
		this.seuil = seuil;
	}

	public String toString() {
		return "seuil = "+this.seuil+" || poids : "+this.poids.toString();
	}
}









