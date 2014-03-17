package projet;

import java.util.LinkedList;

public class Voix {
	private LinkedList<LinkedList<Sommet>> voix = new LinkedList<LinkedList<Sommet>>(); 
	
	public Voix(LinkedList<Integer> noteSoprano){
		voix = remplirVoix(noteSoprano);
	}
	
	private LinkedList<LinkedList<Sommet>> remplirVoix(LinkedList<Integer> noteSoprano){
		LinkedList<LinkedList<Sommet>> liste = new LinkedList<LinkedList<Sommet>>();
		int pos = 0;
		int posSuiv = 0;
		for(int i = 0; i < noteSoprano.size(); i++){
			int note = noteSoprano.get(i);
			LinkedList<Sommet> l = new LinkedList<Sommet>();
			Accord acc = new Accord(note);
			pos++;
			posSuiv = pos + 1;
			for(int numAcc : acc.getAccord()){
				l = new LinkedList<Sommet>();
				l.add(new Sommet(pos, numAcc));
				if (i != noteSoprano.size()-1){
					for(Sommet som : listeAccordSuivantAAjouter(note, numAcc, noteSoprano.get(i+1), posSuiv)){
						l.add(som);
					}
				}
				liste.add(l);
			}
		}
		return liste;
	}
	
	private LinkedList<Sommet> listeAccordSuivantAAjouter(int n1, int numAcc1, int n2, int pos2){
		LinkedList<Sommet> s = new LinkedList<Sommet>();
		Regle r = new Regle();
		Accord acc2 = new Accord(n2);
		
		for(int numAcc2 : acc2.getAccord()){
			if(r.estAccordSuivantValide(numAcc1, numAcc2)){
				s.add(new Sommet(pos2, numAcc2));
			}
		}
		
		return s;
	}

	public LinkedList<LinkedList<Sommet>> getVoix() {
		return voix;
	}

	public String toString(){
		String s = "";
		for(LinkedList<Sommet> listeSommet : voix){
			for(Sommet som : listeSommet){
				s += "(" + som.toString() + ")->";
			}
			s += "\n";
		}
		return s;
	}
}
