package projet;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

public class fichierLilypond implements Serializable{
	
	public static void sauvegarder(LinkedList<Note> note){//Enregistrer au format lilypond
		try{
			String s = "\\include \"italiano.ly\" \\score{{";
			//problème sur les octaves quand il y a plusieurs note
			for(int i = 0; i < note.size(); i++){
				if ((note.get(i)).getNumeroOctave() == 1){//1ere octave
					s += (note.get(i)).getNomNote() + " ";
				}
				else if((note.get(i)).getNumeroOctave() == 2){//2eme octave
					s += (note.get(i)).getNomNote() + "' ";
				}
				else if((note.get(i)).getNumeroOctave() == 3){//3eme octave
					s += (note.get(i)).getNomNote() + "'' ";
				}
				else{//4eme octave
					s += (note.get(i)).getNomNote() + "''' ";
				}
			}
			s += " }} ";
			
			FileWriter sortie = new FileWriter("test.ly");
			sortie.write(s);
			sortie.close();

		}catch(IOException e){
			System.err.println(e.toString());
		}

	}
