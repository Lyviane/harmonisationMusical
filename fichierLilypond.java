package projet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.StringTokenizer;

@SuppressWarnings("serial")
public class fichierLilypond implements Serializable{
	static String titre = "";
	
	public String convertionDureeLilypond(Note n){
		int duree = n.getDuree();
		if(duree == 1)
			return "4";
		else if (duree == 2)
			return "2";
		else if (duree == 3)
			return "2.";
		else if (duree == 4)
			return "1";
		return null;
	}
	
	public String conversionNoteLilypond(LinkedList<Note> note){
		String s = "";
		Note noteActuel;
		
		for(int i = 0; i < note.size(); i++){
			noteActuel = note.get(i);
			
			if(noteActuel.getNomNote().equals("-")){
				s += "r" + convertionDureeLilypond(noteActuel) + " ";
			}
			else{
				if (noteActuel.getNumeroOctave() == 1){//1ere octave
					s += noteActuel.getNomNote() + "," + convertionDureeLilypond(noteActuel) + " ";
				}
				else if(noteActuel.getNumeroOctave() == 2){//2eme octave
					s += noteActuel.getNomNote() + convertionDureeLilypond(noteActuel) + " ";
				}
				else if(noteActuel.getNumeroOctave() == 3){//3eme octave
					s += noteActuel.getNomNote() + "'"  + convertionDureeLilypond(noteActuel) + " ";
				}
				else{//4eme octave
					s += noteActuel.getNomNote() + "''"  + convertionDureeLilypond(noteActuel) + " ";
				}
			}
		}
		return s;
	}
	
	public void sauvegarderEnLilypond(LinkedList<Note> soprano, LinkedList<Note> alto, LinkedList<Note> tenor, LinkedList<Note> basse, String titre, String fichier){//Enregistrer au format lilypond
		try{
			String s = "\\include \"italiano.ly\" \n\\header {\ntitle = \""+titre+"\"\n}\n\\score{\n\\new ChoirStaff <<\n\t\\new Staff \\with { instrumentName = \"Soprano\" }{\\new voice{ ";
			s += conversionNoteLilypond(soprano)+"}}\n";
			s += "\t\\new Staff \\with { instrumentName = \"Alto\" }{\\new voice{";
			s += conversionNoteLilypond(alto)+"}}\n";
			s += "\t\\new Staff \\with { instrumentName = \"Tenor\" }{\\new voice{";
			s += conversionNoteLilypond(tenor)+"}}\n";
			s += "\t\\new Staff \\with { instrumentName = \"Basse\" }{\\new voice{\\clef bass ";
			s += conversionNoteLilypond(basse)+"}}\n";
			s += ">>\n} ";
			
			FileWriter sortie = new FileWriter(fichier);
			sortie.write(s);
			sortie.close();

		}catch(IOException e){
			System.err.println(e.toString());
		}

	}
	
	public LinkedList<Note> chargerFichierChant(String fichier){
		
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
	
}
