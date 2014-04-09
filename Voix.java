package projet;

import java.util.Collections;
import java.util.LinkedList;

public class Voix {
	private LinkedList<LinkedList<Sommet>> chemins = new LinkedList<LinkedList<Sommet>>();//contient la liste des chemins valide
	private LinkedList<Arc> listeArc = new LinkedList<Arc>();

	public Voix(LinkedList<Integer> noteSoprano) {
		remplirVoix(noteSoprano);
		toutLesChemins(noteSoprano.size());
	}

	private LinkedList<Sommet> chemin(Arc a, LinkedList<Sommet> l) {
		l.add(a.getDestination());
		for(Arc arc : listeArc){
			if(a.getOrigine().equals(arc.getDestination())){
				return chemin(arc, l);
			}
		}
		l.add(a.getOrigine());
		Collections.reverse(l);
		return l;
	}
	
	private void toutLesChemins(int tailleMelodie){	
		for(Arc a : listeArc){
			if(a.getDestination().getPositionNoteSoprano() == tailleMelodie){
				chemins.add(chemin(a, new LinkedList<Sommet>()));
			}
		}
		supprimerCheminIncomplet(tailleMelodie);
	}

	private void remplirVoix(LinkedList<Integer> noteSoprano) {
		RegleHarmonisation r = new RegleHarmonisation();
		int pos = 0;
		int posSuiv = 0;
		for (int i = 0; i < noteSoprano.size(); i++) {
			int note = noteSoprano.get(i);
			Accord acc = new Accord(note);
			pos++;
			posSuiv = pos + 1;
			for (int numAcc : acc.getAccord()) {// pour chaque note de l'accord
				Harmonie h = new Harmonie(note, numAcc);
				for (int[] jeu : h.getJeu()) {// pour chaque jeu de l'harmonie
												// formée
					Sommet sActuel = new Sommet(pos, numAcc, jeu);
					if (i != noteSoprano.size() - 1) {
						for (Sommet som : listeAccordSuivantAAjouter(note,
								numAcc, noteSoprano.get(i + 1), posSuiv)) {// j'ajoute le sommet si il appartient au suivant possible
							if (r.regle6(sActuel, som)) {
								listeArc.add(new Arc(sActuel, som));
							}
						}
					}
				}
			}
		}
	}

	public LinkedList<Integer> unChemin(int numVoix) {
		RegleBelleHarmonie r = new RegleBelleHarmonie();
		int numChemin = r.numPlusBeauChemin(chemins);
		LinkedList<Integer> ret = new LinkedList<Integer>();
		if(chemins.size() == 0){
			System.err.println("Il n'y a pas d'harmonisation possible.");
			return ret;
		}
		LinkedList<Sommet> CheminSelectionne = chemins.get(numChemin);
		for (Sommet s : CheminSelectionne) {
			ret.add(s.getJeu()[numVoix]);
		}
		return ret;
	}

	private void supprimerCheminIncomplet(int tailleMelodie) {
		LinkedList<LinkedList<Sommet>> ch = new LinkedList<LinkedList<Sommet>>();
		for(LinkedList<Sommet> liste : chemins){
			if(liste.size() == tailleMelodie){
				ch.add(liste);
			}
		}
		chemins = ch;
	}

	private LinkedList<Sommet> listeAccordSuivantAAjouter(int n1, int numAcc1,
			int n2, int pos2) {
		LinkedList<Sommet> s = new LinkedList<Sommet>();
		RegleHarmonisation r = new RegleHarmonisation();
		Accord acc2 = new Accord(n2);
		for (int numAcc2 : acc2.getAccord()) {
			if (r.estAccordSuivantValide(numAcc1, numAcc2)) {
				Harmonie h = new Harmonie(n2, numAcc2);
				for (int[] jeu : h.getJeu())
					s.add(new Sommet(pos2, numAcc2, jeu));
			}
		}
		return s;
	}
	
	public int nombreHarmonisationPossible(){
		return chemins.size();
	}

	public LinkedList<LinkedList<Sommet>> getChemins() {
		return chemins;
	}

	public String toString() {
		String s = "";
		s += "Liste des arcs : \n";
		
		for(Arc a : listeArc){
			s += a.toString() + "\n";
		}
		
		s += "\nListe des chemins : \n";
		
		for(LinkedList<Sommet> lS : chemins){
			for(Sommet som : lS){
				s += som + " -> ";
			}
			s += "\n";
		}
		return s;
	}
}