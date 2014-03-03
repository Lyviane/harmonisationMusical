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
					s = new StringTokenizer(ligne, " ");//s�paration des notes
					while (s.hasMoreTokens()) {
						liste2.add(s.nextToken());//liste des notes s�par�es
					}
					for (int i = 0; i < liste2.size(); i++){
						nom = liste2.get(i);
						s2 = new StringTokenizer(nom, ":");//s�paration des noms de note et leurs octaves
						while (s2.hasMoreTokens()){
							nomNote = s2.nextToken();
							temps = Integer.parseInt(s2.nextToken());
							
							n = new Soprano(nomNote, temps);
							
						}
						liste.add(n);
					}
				 }
			 }		
		} catch (IOException | NumberFormatException | NoteException e) {
			e.printStackTrace();
		}
		return liste;
	}

	public static void main(String[] args) {
		LinkedList<Note> l = chargerFichierChant("fichier.chant");
		FichierLylipond ly = new FichierLylipond();
		ly.sauvegarderEnLilypond(l, l, l, l, titre, titre+".ly");
	}

}
