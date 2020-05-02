package apprentissage;

import java.util.ArrayList;
import java.util.List;

public class Neurone {
	private List <Double> poids;
	private double poid0;
	
	public Neurone (List<Double> poids, double poid0) {
		this.poids=poids;
		this.poid0=poid0;
	}
	
	public Neurone (double poid0) {
		this.poids=new ArrayList<Double>();
		this.poid0=poid0;
	}
	
	private double somme(List<Integer> entrees) {
		double somme = 0.0;
		
		for (int i = 0 ; i <entrees.size(); i++) {
			somme+=entrees.get(i)*this.poids.get(i);
		}
		
		return somme-this.poid0;
	}
	
	public int evaluer(List<Integer> entrees) {
		if (somme(entrees)>=0) {
			return 1;
		}
		return 0;
	}
	
	public boolean apprendre(List<Integer> entrees, int resultatAttendu) {
		boolean succes = false;
		
		int resultatObtenu = this.evaluer(entrees);
		if (resultatAttendu == resultatObtenu) {
			succes = true;
		}
		for (int i = 0 ; i < entrees.size() ; i++) {
			double poidCourant = this.poids.get(i);
			poidCourant = poidCourant + (resultatAttendu-resultatObtenu)*entrees.get(i);
		}
		
		return succes;
	}
	
	public List<Double> getPoids() {
		return poids;
	}

	public void setPoids(List<Double> poids) {
		this.poids = poids;
	}

	public double getSeuil() {
		return poid0;
	}

	public void setSeuil(double seuil) {
		this.poid0 = seuil;
	}

	public String toString() {
		return "seuil = "+this.poid0+" || poids : "+this.poids.toString();
	}
}








