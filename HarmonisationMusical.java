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
							
							if (nomNote.length() == 4){
								if (nomNote.substring(0, 3).equals("sol")){
									n = new Note("sol", Integer.parseInt(nomNote.substring(3)), temps);	
								}
							}
							else if (nomNote.equals("-")){
								n = new Note("-", 1, temps);	
							}
							else if (nomNote.length() == 3)
								n = new Note(nomNote.substring(0, 2), Integer.parseInt(nomNote.substring(2)),temps);
						}
						liste.add(n);
					}
				 }
			 }		
		} catch (IOException | NumberFormatException | NoteException | NumberException e) {
			e.printStackTrace();
		}
		return liste;
	}

	public static void main(String[] args) {
	}

}
