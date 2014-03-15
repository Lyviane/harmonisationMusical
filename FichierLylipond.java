package projet;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class FichierLylipond implements Serializable{
	
	private String convertionDureeLilypond(Note n){
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
	
	private String conversionNoteLilypond(LinkedList<Note> note){
		String s = "";
		Note noteActuel;
		
		for(int i = 0; i < note.size(); i++){
			noteActuel = note.get(i);
			int n = noteActuel.getNote();
			
			if(n == 28){
				s += "r" + convertionDureeLilypond(noteActuel) + " ";
			}
			else{
				if(n == 0 || n == 1 || n == 2 || n == 3 || n == 4 || n == 5 || n == 6){//1ere octave
					s += Note.noteIntEnNoteString(noteActuel.getNote()) + "," + convertionDureeLilypond(noteActuel) + " ";
				}
				else if(n == 7 || n == 8 || n == 9 || n == 10 || n == 11 || n == 12 || n == 13){//2eme octave
					s += Note.noteIntEnNoteString(noteActuel.getNote()) + convertionDureeLilypond(noteActuel) + " ";
				}
				else if(n == 14 || n == 15 || n == 16 || n == 17 || n == 18 || n == 19 || n == 20){//3eme octave
					s += Note.noteIntEnNoteString(noteActuel.getNote()) + "'"  + convertionDureeLilypond(noteActuel) + " ";
				}
				else{//4eme octave
					s += Note.noteIntEnNoteString(noteActuel.getNote()) + "''"  + convertionDureeLilypond(noteActuel) + " ";
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
}
