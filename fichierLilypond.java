package projet;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class fichierLilypond implements Serializable{
	
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
			
			if(noteActuel.getNomNote().equals("silence")){
				s += "r" + convertionDureeLilypond(noteActuel);
			}
			
			if (noteActuel.getNumeroOctave() == 1){//1ere octave
				s += noteActuel.getNomNote() + convertionDureeLilypond(noteActuel) + " ";
			}
			else if(noteActuel.getNumeroOctave() == 2){//2eme octave
				s += noteActuel.getNomNote() + "'" + convertionDureeLilypond(noteActuel) + " ";
			}
			else if(noteActuel.getNumeroOctave() == 3){//3eme octave
				s += noteActuel.getNomNote() + "''"  + convertionDureeLilypond(noteActuel) + " ";
			}
			else{//4eme octave
				s += noteActuel.getNomNote() + "'''"  + convertionDureeLilypond(noteActuel) + " ";
			}
		}
		return s;
	}
	
	public void sauvegarderEnLilypond(LinkedList<Note> soprano, LinkedList<Note> alto, LinkedList<Note> tenor, LinkedList<Note> basse){//Enregistrer au format lilypond
		try{
			String s = "\\include \"italiano.ly\" \n\\score{\n\\new ChoirStaff <<\n\t\\new Staff \\with { instrumentName = \"Soprano\" }{\\new voice{ ";
			s += conversionNoteLilypond(soprano)+"}}\n";
			s += "\t\\new Staff \\with { instrumentName = \"Alto\" }{\\new voice{";
			s += conversionNoteLilypond(alto)+"}}\n";
			s += "\t\\new Staff \\with { instrumentName = \"Tenor\" }{\\new voice{";
			s += conversionNoteLilypond(tenor)+"}}\n";
			s += "\t\\new Staff \\with { instrumentName = \"Basse\" }{\\new voice{\\clef bass ";
			s += conversionNoteLilypond(basse)+"}}\n";
			s += ">>\n} ";
			
			FileWriter sortie = new FileWriter("test.ly");
			sortie.write(s);
			sortie.close();

		}catch(IOException e){
			System.err.println(e.toString());
		}

	}
	
}
