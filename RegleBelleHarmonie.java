package projet;

import java.util.LinkedList;

public class RegleBelleHarmonie{
	
	private int tenueNote(LinkedList<Integer> voix){
		int ret = 0;
		int prec = voix.getFirst();
		for(int i = 1; i < voix.size(); i++){
			if(prec != voix.get(i)){
				ret++;
			}
			prec = voix.get(i);
		}
		return ret;
	}
	
	private LinkedList<LinkedList<Integer>> transformeChemin(LinkedList<LinkedList<Sommet>> chemins, int numVoix){
		LinkedList<LinkedList<Integer>> ret = new LinkedList<LinkedList<Integer>>();
		for(int numChemin = 0; numChemin < chemins.size(); numChemin++){
			LinkedList<Sommet> CheminSelectionne = chemins.get(numChemin);
			LinkedList<Integer> aux = new LinkedList<Integer>();
			for (Sommet s : CheminSelectionne) {
				aux.add(s.getJeu()[numVoix]);
			}
			ret.add(aux);
		}
		return ret;
	}
	
	private int posMin2Tableau(int[] tab1, int[] tab2){
		int min1 = tab1[0], min2 = tab2[0];
		int pos = 0;
		for(int i = 1; i < tab1.length; i++){
			if(tab1[i] <= min1 && tab2[i] <= min2){
				min1 = tab1[i];
				min2 = tab2[i];
				pos = i;
			}
		}
		return pos;
	}
	
	private int posMaxTableau(int[] tab){
		int max = tab[0], pos = 0;
		for(int i = 1; i < tab.length; i++){
			if(max < tab[i]){
				max = tab[i];
				pos = i;
			}
		}
		return pos;
	}
	
	private int posMinTableau(int[] tab){
		int min = tab[0], pos = 0;
		for(int i = 1; i < tab.length; i++){
			if(min > tab[i]){
				min = tab[i];
				pos = i;
			}
		}
		return pos;
	}
	
	private int amplitude(LinkedList<Integer> voix){
		int actuel;
		int min = voix.get(0);
		int max = voix.get(0);
		
		for(int i = 1; i < voix.size(); i++){
			actuel = voix.get(i);
			if(actuel < min)
				min = actuel;
			else if(actuel > max)
				max = actuel;
		}
		return max - min;
	}
	
	private int ecart(LinkedList<Integer> voix1, LinkedList<Integer> voix2){
		int ecart = 0;
		for(int i : voix1){
			for(int j : voix2){
				if(i > j)
					ecart += i - j;
				else
					ecart += j - i;
			}
		}
		return ecart;
	}
	
	public int numPlusBeauCheminCritere1(LinkedList<LinkedList<Sommet>> chemins){//critère de beauté 1
		if(chemins.size() != 0){
			LinkedList<LinkedList<Integer>> listeAlto = transformeChemin(chemins, 0);
			LinkedList<LinkedList<Integer>> listeTenor = transformeChemin(chemins, 1);
		
			int taille = listeAlto.size();
			int tab[] = new int[taille];
			for(int i = 0; i < taille; i++){
				tab[i] = ecart(listeAlto.get(i), listeTenor.get(i));
			}
			return posMinTableau(tab);
		}
		return -1;
	}
	
	public int numPlusBeauCheminCritere2(LinkedList<LinkedList<Sommet>> chemins){//critère de beauté 2
		if(chemins.size() != 0){
			LinkedList<LinkedList<Integer>> listeAlto = transformeChemin(chemins, 0);
			LinkedList<LinkedList<Integer>> listeTenor = transformeChemin(chemins, 1);
		
			int taille = listeAlto.size();
			int tabAlto[] = new int[taille];
			int tabTenor[] = new int[taille];
			for(int i = 0; i < taille; i++){
				tabAlto[i] = tenueNote(listeAlto.get(i));
				tabTenor[i] = tenueNote(listeTenor.get(i));
			}
			return (posMin2Tableau(tabAlto, tabTenor));
		}
		return -1;
	}
	
	public int numPlusBeauCheminCritere3(LinkedList<LinkedList<Sommet>> chemins){//critère de beauté 3
		if(chemins.size() != 0){
			LinkedList<LinkedList<Integer>> listeBasse = transformeChemin(chemins, 2);
			int taille = listeBasse.size();
			int tab[] = new int[taille];
			for(int i = 0; i < taille; i++){
				tab[i] = amplitude(listeBasse.get(i));
			}
			return posMaxTableau(tab);
		}
		return -1;
	}
	
	public int numPlusBeauCheminCritere4(LinkedList<LinkedList<Sommet>> chemins){//critère de beauté 4
		
	}
}
