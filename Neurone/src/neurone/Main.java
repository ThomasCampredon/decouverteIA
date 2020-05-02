package neurone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		ArrayList<Double> poids = new ArrayList<>(Arrays.asList(0.2, 0.5, 0.6));
		Neurone neurone1 = new Neurone(poids,0.7);
		
		ArrayList<Integer> entrees1 = new ArrayList<>(Arrays.asList(1, 0, 1));
		ArrayList<Integer> entrees2 = new ArrayList<>(Arrays.asList(0, 1, 0));
		
		System.out.println(neurone1.evaluer(entrees1));
		System.out.println(neurone1.evaluer(entrees2));
	}
}
