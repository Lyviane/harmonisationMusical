package projet;

import java.util.LinkedList;

public class RegleHarmonisation{
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
	
	private boolean memeNature(int n1, int n2, int accordN1, int accordN2){
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
	
	private boolean differenceSuperieurA2(int n1, int n2){
		if (n1 >= n2){
			if(n1-n2 > 2)
				return true;
			return false;
		}
		else{
			if(n2-n1 > 2)
				return true;
			return false;
		}
	}
	
	private boolean DiffSup2EtMemeNature(int n1, int n2, int accordN1, int accordN2){
		return differenceSuperieurA2(n1, n2) && memeNature(n1, n2, accordN1, accordN2);
	}
	
	private boolean differenceEntreDeuxNotesValide(int n1, int n2){
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
	
	private boolean differenceEntreNotesJeuValide (int[] jeu1, int[] jeu2){
		return differenceEntreDeuxNotesValide(jeu1[0], jeu2[0]) && differenceEntreDeuxNotesValide(jeu1[1], jeu2[1]) && differenceEntreDeuxNotesValide(jeu1[2], jeu2[2]);
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
	
	private boolean noteChangePas(int n1, int n2, int accordN2){
		return noteAppatientAccordSuivant(n1, accordN2) && (n1 == n2);
	}
	
	public boolean regle6(Sommet s1, Sommet s2){
		if(differenceEntreNotesJeuValide(s1.getJeu(), s2.getJeu())){
			if(noteChangePas(s1.getJeu()[0], s2.getJeu()[0], s2.getAccord()) || (!noteAppatientAccordSuivant(s1.getJeu()[0], s2.getAccord()))){
				if(noteChangePas(s1.getJeu()[1], s2.getJeu()[1], s2.getAccord()) || (!noteAppatientAccordSuivant(s1.getJeu()[1], s2.getAccord()))){
					if((!differenceSuperieurA2(s1.getJeu()[0], s2.getJeu()[0])) || (DiffSup2EtMemeNature(s1.getJeu()[0], s2.getJeu()[0], s1.getAccord(), s2.getAccord()))){
						if((!differenceSuperieurA2(s1.getJeu()[1], s2.getJeu()[1])) || (DiffSup2EtMemeNature(s1.getJeu()[1], s2.getJeu()[1], s1.getAccord(), s2.getAccord()))){
							if((!differenceSuperieurA2(s1.getJeu()[2], s2.getJeu()[2])) || (DiffSup2EtMemeNature(s1.getJeu()[2], s2.getJeu()[2], s1.getAccord(), s2.getAccord()))){
								return true;
							}
						}
					}
					
				}
			}
		}
		return false;
	}
}
