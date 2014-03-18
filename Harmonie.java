package projet;

import java.util.Iterator;
import java.util.LinkedList;

public class Harmonie {
	private	int accord;
	private LinkedList<int[]> jeu = new LinkedList<int[]>();
	
	public Harmonie(int note, int acc){
		accord = acc;
		jeu = remplir(note, Accord.noteDeLAccord(accord));
	}

	private LinkedList<int[]> remplir(int note, int[] tab){
		Regle r = new Regle();
		LinkedList<int[]> ret = new LinkedList<int[]>();
		for(int i = 0; i < tab.length; i++){
			for(int j = 0; j < tab.length; j++){
				for(int k = 0; k < tab.length; k++){
					if(i != j && j != k && i != k){
						if(r.differenceDeHauteurValide(note, tab[i], tab[j], tab[k])){//règle 2
							if(r.estAlto(tab[i]) && r.estTenor(tab[j]) && r.estBasse(tab[k])){//règle 1
								if(r.estTonique(tab[k], accord)){//regle 3
									if(r.reformeAccord(note, tab[i], tab[j], tab[k])){
										int[] jeu = new int[3];
										jeu[0] = tab[i];//alto
										jeu[1] = tab[j];//tenor
										jeu[2] = tab[k]; //basse
										ret.add(jeu);
									}
								}
							}
						}
					}
				}
			}
		}
		return ret;
	}

	public String toString(){
		int[] tab;
		String s = "";
		Iterator<int[]> it = jeu.listIterator();
		while(it.hasNext()){
			tab = it.next();
			s += "[";
			for (int i = 0; i < tab.length; i++){
				if(i != tab.length - 1)
					s += tab[i]+";";
				else
					s += tab[i];
			}
			s += "]\n";
		}
		return s;
	}
	
	public int getAccord() {
		return accord;
	}

	public void setAccord(int accord) {
		this.accord = accord;
	}
	
	public LinkedList<int[]> getJeu() {
		return jeu;
	}

	public int[] noteAltoPossible(){
		int[] tab = new int[jeu.size()];
		for(int i = 0; i < tab.length; i++){
			tab[i] = jeu.get(i)[0];
		}
		return tab;
	}
	
	public int[] noteTenorPossible(){
		int[] tab = new int[jeu.size()];
		for(int i = 0; i < tab.length; i++){
			tab[i] = jeu.get(i)[1];
		}
		return tab;
	}
	
	public int[] noteBassePossible(){
		int[] tab = new int[jeu.size()];
		for(int i = 0; i < tab.length; i++){
			tab[i] = jeu.get(i)[2];
		}
		return tab;
	}

}