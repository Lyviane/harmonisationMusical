package projet;

import java.util.LinkedList;

public class Regle {

	private String typeNote(int note, int numAccord){
		switch(numAccord){
		case 1:
			if(Note.noteIntEnNoteString(note).equals("do")){
				return "tonique";
			}
			else if(Note.noteIntEnNoteString(note).equals("mi")){
				return "tierce";
			}
			else if(Note.noteIntEnNoteString(note).equals("sol")){
				return "quinte";
			}
			break;
		case 2:
			if(Note.noteIntEnNoteString(note).equals("re")){
				return "tonique";
			}
			else if(Note.noteIntEnNoteString(note).equals("fa")){
				return "tierce";
			}
			else if(Note.noteIntEnNoteString(note).equals("la")){
				return "quinte";
			}
			break;
		case 3:
			if(Note.noteIntEnNoteString(note).equals("mi")){
				return "tonique";
			}
			else if(Note.noteIntEnNoteString(note).equals("sol")){
				return "tierce";
			}
			else if(Note.noteIntEnNoteString(note).equals("si")){
				return "quinte";
			}
			break;
		case 4:
			if(Note.noteIntEnNoteString(note).equals("fa")){
				return "tonique";
			}
			else if(Note.noteIntEnNoteString(note).equals("la")){
				return "tierce";
			}
			else if(Note.noteIntEnNoteString(note).equals("do")){
				return "quinte";
			}
			break;
		case 5:
			if(Note.noteIntEnNoteString(note).equals("sol")){
				return "tonique";
			}
			else if(Note.noteIntEnNoteString(note).equals("si")){
				return "tierce";
			}
			else if(Note.noteIntEnNoteString(note).equals("re")){
				return "quinte";
			}
			break;
		case 6:
			if(Note.noteIntEnNoteString(note).equals("la")){
				return "tonique";
			}
			else if(Note.noteIntEnNoteString(note).equals("do")){
				return "tierce";
			}
			else if(Note.noteIntEnNoteString(note).equals("mi")){
				return "quinte";
			}
			break;
		case 7:
			if(Note.noteIntEnNoteString(note).equals("si")){
				return "tonique";
			}
			else if(Note.noteIntEnNoteString(note).equals("re")){
				return "tierce";
			}
			else if(Note.noteIntEnNoteString(note).equals("fa")){
				return "quinte";
			}
			break;
		}
		return "";
	}
	
	public boolean estTonique(int note, int numAccord){
		if(typeNote(note, numAccord).equals("tonique"))
			return true;
		return false;
	}
	
	private boolean estTierce(int note, int numAccord){
		if(typeNote(note, numAccord).equals("tierce"))
			return true;
		return false;
	}
	
	private boolean estQuinte(int note, int numAccord){
		if(typeNote(note, numAccord).equals("quinte"))
			return true;
		return false;
	}
	
	public boolean memeNature(int n1, int n2, int accordN1, int accordN2){
		if (estTonique(n1, accordN1) && estTonique(n2, accordN2))
			return true;
		else if (estTierce(n1, accordN1) && estTierce(n2, accordN2))
			return true;
		else if (estQuinte(n1, accordN1) && estQuinte(n2, accordN2))
			return true;
		else
			return false;
	}
	
	public boolean differenceDeHauteurValide(int soprano, int alto, int tenor, int basse){
		return (soprano > alto && alto > tenor && tenor > basse);
	}
	
	public boolean differenceSuperieurA2(int n1, int n2){
		if (n1 >= n2){
			if(n1-n2 > 2)
				return false;
			return true;
		}
		else{
			if(n2-n1 > 2)
				return false;
			return true;
		}
	}
	
	public boolean differenceEntreDeuxNotesValide(int n1, int n2){
		if (n1 >= n2){
			if(n1-n2 > 6)
				return false;
			return true;
		}
		else{
			if(n2-n1 > 6)
				return false;
			return true;
		}
	}
	
	public boolean estAlto(int note){
		return (note >= 11 && note <= 22);
	}
	
	public boolean estTenor(int note){
		return (note >= 7 && note <= 19);
	}
	
	public boolean estBasse(int note){
		return (note >= 3 && note <= 15);
	}
	
	public boolean noteAppatientAccordSuivant(int note, int AccordSuivant){
		int[] noteAccordSuivant = Accord.noteDeLAccord(AccordSuivant);
		for(int i = 0; i < noteAccordSuivant.length; i++){
			if(noteAccordSuivant[i] == note)
				return true;
		}
		return false;
	}
	
	public boolean estAccordSuivantValide(int acc, int accSuiv){
		Accord a = new Accord(0);
		LinkedList<Integer> listeAcc = a.accordSuivant(acc);
		for(int i = 0; i < listeAcc.size(); i++){
			if(accSuiv == listeAcc.get(i)){
				return true;
			}
		}
		return false;
	}

	public boolean reformeAccord(int note1, int note2, int note3, int note4) {
		String n1 = Note.noteIntEnNoteString(note1), n2 = Note.noteIntEnNoteString(note2), n3 = Note.noteIntEnNoteString(note3), n4 = Note.noteIntEnNoteString(note4);
		if(n1.equals(n2) && n1.equals(n3) || n1.equals(n2) && n1.equals(n4) || n1.equals(n3) && n1.equals(n4))
			return false;
		else if(n1.equals(n2) || n1.equals(n3) || n1.equals(n4)){
			if(n2.equals(n3) || n2.equals(n4) || n3.equals(n2) || n3.equals(n4) || n4.equals(n2) || n4.endsWith(n3))
				return false;
		}
		else if(n2.equals(n3) && n2.equals(n4))
			return false;
		return true;
	}
	
}
