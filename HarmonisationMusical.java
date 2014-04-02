package projet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class HarmonisationMusical {
	public static String titre = "";

	public static LinkedList<Note> chargerFichierChant(String fichier){
		LinkedList<Note> liste = new LinkedList<Note>();
		LinkedList<String> liste2 = new LinkedList<String>();
		try {
			String ligne, nomNote = "", nom = "";
			int temps = 1, cpt = 0;
			StringTokenizer s, s2;
			Note n = null;
			FileReader entree = new FileReader(fichier);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(entree);
			
			while ((ligne = br.readLine()) != null){
				 cpt ++;
				 if(cpt == 1){
					 titre = ligne;
				 }
				 else{
					s = new StringTokenizer(ligne, " ");//séparation des notes
					while (s.hasMoreTokens()) {
						liste2.add(s.nextToken());//liste des notes séparées
					}
					for (int i = 0; i < liste2.size(); i++){
						nom = liste2.get(i);
						s2 = new StringTokenizer(nom, ":");//séparation des noms de note et leurs octaves
						while (s2.hasMoreTokens()){
							nomNote = s2.nextToken();
							temps = Integer.parseInt(s2.nextToken());
							
							n = new Note(nomNote, temps);
							
						}
						liste.add(n);
					}
				 }
			 }		
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	public static LinkedList<Integer> voixSoprano(LinkedList<Note> soprano){
		LinkedList<Integer> sop = new LinkedList<Integer>();
		int ancienneNote = 0;
		for(Note n : soprano){
			if(n.getNote() != 28){
				for(int i = 0; i < n.getDuree(); i++){
					sop.add(n.getNote());
				}
				ancienneNote = n.getNote();
			}
			else{
				sop.add(ancienneNote);
			}
		}
		return sop;
	}
	
	public static LinkedList<Note> creerVoix(LinkedList<Integer> soprano, int numVoix){//numVoix = 0: alto, = 1: tenor, = 2: basse
		Voix v = new Voix(soprano);
		LinkedList<Integer> listeInt = v.unChemin(numVoix);
		LinkedList<Note> ret = new LinkedList<Note>();
		
		for(Integer i : listeInt){
			ret.add(new Note(i));
		}
		return ret;
	}

	public static void main(String[] args) {
		LinkedList<Note> l = chargerFichierChant("fichier.chant");
		LinkedList<Integer> lInt = voixSoprano(l);
		FichierLylipond ly = new FichierLylipond();
		FichierMidi mi = new FichierMidi();
		ly.sauvegarderEnLilypond(l, creerVoix(lInt, 0), creerVoix(lInt, 1), creerVoix(lInt, 2), titre, titre+".ly");
		mi.sauvegarderEnMidi(l, creerVoix(lInt, 0), creerVoix(lInt, 1), creerVoix(lInt, 2), titre+".mid");
		System.out.println("Il y a " + new Voix(lInt).nombreHarmonisationPossible() + " harmonisations possibles.");
	}

}
