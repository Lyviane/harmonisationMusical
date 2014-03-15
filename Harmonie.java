package projet;

import java.util.Iterator;
import java.util.LinkedList;

public class Harmonie {
	int accord;
	LinkedList<int[]> jeu = new LinkedList<int[]>();
	
	public Harmonie(int note, int acc){
		accord = acc;
		jeu = remplir(note, noteDeLAccord());
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
		return ret;
	}

	private int[] noteDeLAccord(){
		int[] tableau = new int[12];
		switch (accord) {
		case 1:
			tableau[0] = 0;
			tableau[1] = 7;
			tableau[2] = 14;
			tableau[3] = 21;
			tableau[4] = 2;
			tableau[5] = 9; 
			tableau[6] = 16; 
			tableau[7] = 23; 
			tableau[8] = 4;
			tableau[9] = 11; 
			tableau[10] = 18;
			tableau[11] = 25;
			break;
		case 2:
			tableau[0] = 1;
			tableau[1] = 8;
			tableau[2] = 15;
			tableau[3] = 22;
			tableau[4] = 3;
			tableau[5] = 10; 
			tableau[6] = 17; 
			tableau[7] = 24; 
			tableau[8] = 5;
			tableau[9] = 12; 
			tableau[10] = 19;
			tableau[11] = 26;
			break;
		case 3:
			tableau[0] = 2;
			tableau[1] = 9;
			tableau[2] = 16;
			tableau[3] = 23;
			tableau[4] = 4;
			tableau[5] = 11; 
			tableau[6] = 18; 
			tableau[7] = 25; 
			tableau[8] = 6;
			tableau[9] = 13; 
			tableau[10] = 20;
			tableau[11] = 27;
			break;
		case 4:
			tableau[0] = 3;
			tableau[1] = 10;
			tableau[2] = 17;
			tableau[3] = 24;
			tableau[4] = 5;
			tableau[5] = 12; 
			tableau[6] = 19; 
			tableau[7] = 26; 
			tableau[8] = 0;
			tableau[9] = 7; 
			tableau[10] = 14;
			tableau[11] = 21;
			break;
		case 5:
			tableau[0] = 4;
			tableau[1] = 11;
			tableau[2] = 18;
			tableau[3] = 25;
			tableau[4] = 6;
			tableau[5] = 13; 
			tableau[6] = 20; 
			tableau[7] = 27; 
			tableau[8] = 1;
			tableau[9] = 8; 
			tableau[10] = 15;
			tableau[11] = 22;
			break;
		case 6:
			tableau[0] = 5;
			tableau[1] = 12;
			tableau[2] = 19;
			tableau[3] = 26;
			tableau[4] = 0;
			tableau[5] = 7; 
			tableau[6] = 14; 
			tableau[7] = 21; 
			tableau[8] = 2;
			tableau[9] = 9; 
			tableau[10] = 16;
			tableau[11] = 23;
			break;
		case 7:
			tableau[0] = 6;
			tableau[1] = 13;
			tableau[2] = 20;
			tableau[3] = 27;
			tableau[4] = 1;
			tableau[5] = 8; 
			tableau[6] = 15; 
			tableau[7] = 22; 
			tableau[8] = 3;
			tableau[9] = 10; 
			tableau[10] = 17;
			tableau[11] = 24;
			break;
		default:
			break;
		}
		return tableau;
	}


	public String toString(){
		int[] tab;
		String s = "[";
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
			s += "]";
		}
		s += "]";
		return s;
	}

}