package projet;

import java.util.LinkedList;

public class Voix {
	private LinkedList<LinkedList<Sommet>> voix = new LinkedList<LinkedList<Sommet>>(); 
	
	public Voix(LinkedList<Integer> noteSoprano){
		voix = remplirVoix(noteSoprano);
	}
	
	private LinkedList<LinkedList<Sommet>> remplirVoix(LinkedList<Integer> noteSoprano){
		LinkedList<LinkedList<Sommet>> liste = new LinkedList<LinkedList<Sommet>>();
		Regle r = new Regle();
		int pos = 0;
		int posSuiv = 0;
		for(int i = 0; i < noteSoprano.size(); i++){
			int note = noteSoprano.get(i);
			LinkedList<Sommet> l = new LinkedList<Sommet>();
			Accord acc = new Accord(note);
			pos++;
			posSuiv = pos + 1;
			for(int numAcc : acc.getAccord()){//pour chaque note de l'accord
				Harmonie h = new Harmonie(note, numAcc);
				for(int[] jeu : h.getJeu()){//pour chaque jeu de l'harmonie form�e
					l = new LinkedList<Sommet>();
					Sommet sActuel = new Sommet(pos, numAcc, jeu);
					l.add(sActuel);
					if (i != noteSoprano.size()-1){
						for(Sommet som : listeAccordSuivantAAjouter(note, numAcc, noteSoprano.get(i+1), posSuiv)){//j'ajoute le sommet si il appartient au suivant possible
							if(r.regle6(sActuel, som)){//TODO: des cas ne passent pas alors qu'ils devraient
								l.add(som);
							}
						}
					}
					liste.add(l);
				}
				
			}
		}
		liste = supprimerCheminIncomplet(liste, noteSoprano);
		return liste;
	}
	
	public LinkedList<Integer> unChemin(int i, int numVoix, int tailleMelodie) throws HarmonisationException{
		LinkedList<Integer> ret = new LinkedList<Integer>();
		LinkedList<LinkedList<Sommet>> v = voix;
		Sommet suiv;
		LinkedList<Sommet> liste = v.get(1);
		
		ret.add(liste.get(0).getJeu()[numVoix]);//je r�cup�re le premier sommet de la liste et j'ajoute la note qui m'int�resse de son jeu
		suiv = liste.get(1);
		for(LinkedList<Sommet> listeS : v){
			if(listeS.get(0).equals(suiv)){//si le premier membre de la liste est �gal a suiv alors la nouvelle liste est listeS
				ret.add(listeS.get(0).getJeu()[numVoix]);
				if(listeS.size() > 1)
					suiv = listeS.get(1);
				else
					break;
			}
		}
		
		if(ret.size() != tailleMelodie && i+1 < tailleMelodie){
			return unChemin(i+1, numVoix, tailleMelodie);
		}
		else if(ret.size() != tailleMelodie && i+1 >= tailleMelodie){
			throw new HarmonisationException("Aucune harmonisation n'est possible.");
		}
		return ret;
	}
	
	private LinkedList<LinkedList<Sommet>> supprimerCheminIncomplet(LinkedList<LinkedList<Sommet>> v, LinkedList<Integer> noteSoprano){//TODO: ne fonctionne pas correctement car il manque des cas
		LinkedList<LinkedList<Sommet>> liste2 = new LinkedList<LinkedList<Sommet>>();
		
		for(int i = 0; i < v.size(); i++){
			LinkedList<Sommet> l = v.get(i);
			if(l.size() > 1){
				liste2.add(l);
			}
		}
		
		for(LinkedList<Sommet> a : v){
			for(Sommet s : a){
				if(s.getPositionNoteSoprano() == noteSoprano.size()){
					if(!liste2.contains(a))
						liste2.add(a);
				}
			}
		}
		
		
		return liste2;
	}
	
	private LinkedList<Sommet> listeAccordSuivantAAjouter(int n1, int numAcc1, int n2, int pos2){
		LinkedList<Sommet> s = new LinkedList<Sommet>();
		Regle r = new Regle();
		Accord acc2 = new Accord(n2);
		
		for(int numAcc2 : acc2.getAccord()){
			if(r.estAccordSuivantValide(numAcc1, numAcc2)){
				Harmonie h = new Harmonie(n2, numAcc2);
				for(int[] jeu : h.getJeu())
				s.add(new Sommet(pos2, numAcc2, jeu));
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
