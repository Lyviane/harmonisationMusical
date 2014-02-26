package projet;

import java.util.LinkedList;

public class Accord {
	int[][] jeu;//accord possible pour une note
	LinkedList<Integer>[][] suivant;
	
	public Accord(Soprano s){
		remplirJeu(s.note);		
	}
	
	private void remplirAccord(int i, int numAccord){
		if(numAccord == 1){
			jeu[i][1] = 7;//basse
			jeu[i][2] = 11;//tenor
			jeu[i][3] = 16;//alto
		}
		else if(numAccord == 2){
			jeu[i][1] = 8;//basse
			jeu[i][2] = 10;//tenor
			jeu[i][3] = 12;//alto
		}
		else if(numAccord == 3){
			jeu[i][1] = 9;
			jeu[i][2] = 11;
			jeu[i][3] = 13;
		}
		else if(numAccord == 4 || numAccord == 5){
			jeu[i][1] = 3;
			jeu[i][2] = 12;
			jeu[i][3] = 14;
		}
		else if(numAccord == 6){
			jeu[i][1] = 4;
			jeu[i][2] = 13;
			jeu[i][3] = 15;
		}
		else if(numAccord == 7){
			jeu[i][1] = 5;
			jeu[i][2] = 7;
			jeu[i][3] = 16;
		}
		else{
			jeu[i][1] = 6;
			jeu[i][2] = 10;
			jeu[i][3] = 15;
		}
	}
	
	private void remplirJeu(int note){
		//accord I: 1, II: 2, III: 3, IV: 4, IVb: 5, V: 6, VI: 7, VII: 8
		switch (note) {
		case 14:
			jeu = new int[2][4];
			
			//numéro accord
			jeu[0][0] = 4;
			jeu[1][0] = 5;
			
			remplirAccord(0, jeu[0][0]);
			remplirAccord(1, jeu[1][0]);
			
			break;
		case 15:
			jeu = new int[3][4];
			
			//numéro accord
			jeu[0][0] = 2;
			jeu[1][0] = 6;
			jeu[2][0] = 8;
			
			remplirAccord(0, jeu[0][0]);
			remplirAccord(1, jeu[1][0]);
			remplirAccord(2, jeu[2][0]);
			break;
		case 16:
			jeu = new int[3][4];
			
			//numéro accord
			jeu[0][0] = 1;
			jeu[1][0] = 3;
			jeu[2][0] = 7;
			
			remplirAccord(0, jeu[0][0]);
			remplirAccord(1, jeu[1][0]);
			remplirAccord(2, jeu[2][0]);
			break;
		case 17:
			jeu = new int[4][4];
			
			//numéro accord
			jeu[0][0] = 2;
			jeu[1][0] = 4;
			jeu[2][0] = 5;
			jeu[3][0] = 8;
			
			remplirAccord(0, jeu[0][0]);
			remplirAccord(1, jeu[1][0]);
			remplirAccord(2, jeu[2][0]);
			remplirAccord(3, jeu[3][0]);
			break;
		case 18:
			jeu = new int[3][4];
			
			//numéro accord
			jeu[0][0] = 1;
			jeu[1][0] = 3;
			jeu[2][0] = 6;
			
			remplirAccord(0, jeu[0][0]);
			remplirAccord(1, jeu[1][0]);
			remplirAccord(2, jeu[2][0]);
			break;
		case 19:
			jeu = new int[4][4];
			
			//numéro accord
			jeu[0][0] = 2;
			jeu[1][0] = 4;
			jeu[2][0] = 5;
			jeu[3][0] = 7;
			
			remplirAccord(0, jeu[0][0]);
			remplirAccord(1, jeu[1][0]);
			remplirAccord(2, jeu[2][0]);
			remplirAccord(3, jeu[3][0]);
			break;
		case 20:
			jeu = new int[3][4];
			
			//numéro accord
			jeu[0][0] = 3;
			jeu[1][0] = 6;
			jeu[2][0] = 8;
			
			remplirAccord(0, jeu[0][0]);
			remplirAccord(1, jeu[1][0]);
			remplirAccord(2, jeu[2][0]);
			break;
		case 21:
			jeu = new int[4][4];
			
			//numéro accord
			jeu[0][0] = 1;
			jeu[1][0] = 4;
			jeu[2][0] = 5;
			jeu[3][0] = 7;
			
			remplirAccord(0, jeu[0][0]);
			remplirAccord(1, jeu[1][0]);
			remplirAccord(2, jeu[2][0]);
			remplirAccord(3, jeu[3][0]);
			break;
		case 22:
			jeu = new int[3][4];
			
			//numéro accord
			jeu[0][0] = 2;
			jeu[1][0] = 6;
			jeu[2][0] = 8;
			
			remplirAccord(0, jeu[0][0]);
			remplirAccord(1, jeu[1][0]);
			remplirAccord(2, jeu[2][0]);
			break;
		case 23:
			jeu = new int[3][4];
			
			//numéro accord
			jeu[0][0] = 1;
			jeu[1][0] = 3;
			jeu[2][0] = 7;
			
			remplirAccord(0, jeu[0][0]);
			remplirAccord(1, jeu[1][0]);
			remplirAccord(2, jeu[2][0]);
			break;
		case 24:
			jeu = new int[4][4];
			
			//numéro accord
			jeu[0][0] = 2;
			jeu[1][0] = 4;
			jeu[2][0] = 5;
			jeu[3][0] = 8;
			
			remplirAccord(0, jeu[0][0]);
			remplirAccord(1, jeu[1][0]);
			remplirAccord(2, jeu[2][0]);
			remplirAccord(3, jeu[3][0]);
			break;
		case 25:
			jeu = new int[3][4];
			
			//numéro accord
			jeu[0][0] = 1;
			jeu[1][0] = 3;
			jeu[2][0] = 6;
			
			remplirAccord(0, jeu[0][0]);
			remplirAccord(1, jeu[1][0]);
			remplirAccord(2, jeu[2][0]);
			break;
		case 26:
			jeu = new int[4][4];
			
			//numéro accord
			jeu[0][0] = 2;
			jeu[1][0] = 4;
			jeu[2][0] = 5;
			jeu[3][0] = 7;
			
			remplirAccord(0, jeu[0][0]);
			remplirAccord(1, jeu[1][0]);
			remplirAccord(2, jeu[2][0]);
			remplirAccord(3, jeu[3][0]);
			break;
		default:
			break;
		}
	}
	
	private int[] noteDeLAccord(int accord){
		int[] tableau = new int[12];
		switch (accord) {
		case 1:
			tableau[0] = 0;
			tableau[1] = 7;
			tableau[2] = 14;
			tableau[3] = 21;
			tableau[4] = 2;
			tableau[5] = 9; 
			tableau[6] = 16; 
			tableau[7] = 23; 
			tableau[8] = 4;
			tableau[9] = 11; 
			tableau[10] = 18;
			tableau[11] = 25;
			break;
		case 2:
			tableau[0] = 1;
			tableau[1] = 8;
			tableau[2] = 15;
			tableau[3] = 22;
			tableau[4] = 3;
			tableau[5] = 10; 
			tableau[6] = 17; 
			tableau[7] = 24; 
			tableau[8] = 5;
			tableau[9] = 12; 
			tableau[10] = 19;
			tableau[11] = 26;
			break;
		case 3:
			tableau[0] = 2;
			tableau[1] = 9;
			tableau[2] = 16;
			tableau[3] = 23;
			tableau[4] = 4;
			tableau[5] = 11; 
			tableau[6] = 18; 
			tableau[7] = 25; 
			tableau[8] = 6;
			tableau[9] = 13; 
			tableau[10] = 20;
			tableau[11] = 27;
			break;
		case 4: case 5:
			tableau[0] = 3;
			tableau[1] = 10;
			tableau[2] = 17;
			tableau[3] = 24;
			tableau[4] = 5;
			tableau[5] = 12; 
			tableau[6] = 19; 
			tableau[7] = 26; 
			tableau[8] = 0;
			tableau[9] = 7; 
			tableau[10] = 14;
			tableau[11] = 21;
			break;
		case 6:
			tableau[0] = 4;
			tableau[1] = 11;
			tableau[2] = 18;
			tableau[3] = 25;
			tableau[4] = 6;
			tableau[5] = 13; 
			tableau[6] = 20; 
			tableau[7] = 27; 
			tableau[8] = 1;
			tableau[9] = 8; 
			tableau[10] = 15;
			tableau[11] = 22;
			break;
		case 7:
			tableau[0] = 5;
			tableau[1] = 12;
			tableau[2] = 19;
			tableau[3] = 26;
			tableau[4] = 0;
			tableau[5] = 7; 
			tableau[6] = 14; 
			tableau[7] = 21; 
			tableau[8] = 2;
			tableau[9] = 9; 
			tableau[10] = 16;
			tableau[11] = 23;
			break;
		case 8:
			tableau[0] = 6;
			tableau[1] = 13;
			tableau[2] = 20;
			tableau[3] = 27;
			tableau[4] = 1;
			tableau[5] = 8; 
			tableau[6] = 15; 
			tableau[7] = 22; 
			tableau[8] = 3;
			tableau[9] = 10; 
			tableau[10] = 17;
			tableau[11] = 24;
			break;
		default:
			break;
		}
		return tableau;
	}
	
	private boolean noteAppatientAccordSuivant(int note, int accordSuivant){
		int[] noteAccordSuivant = noteDeLAccord(accordSuivant);
		for(int i = 0; i < noteAccordSuivant.length; i++){
			if(noteAccordSuivant[i] == note)
				return true;
		}
		return false;
	}
	
	private String typeNote(int note, int numAccord){
		switch(numAccord){
		case 1:
			if(noteIntEnNoteString(note).equals("do")){
				return "tonique";
			}
			else if(noteIntEnNoteString(note).equals("mi")){
				return "tierce";
			}
			else if(noteIntEnNoteString(note).equals("sol")){
				return "quinte";
			}
			break;
		case 2:
			if(noteIntEnNoteString(note).equals("re")){
				return "tonique";
			}
			else if(noteIntEnNoteString(note).equals("fa")){
				return "tierce";
			}
			else if(noteIntEnNoteString(note).equals("la")){
				return "quinte";
			}
			break;
		case 3:
			if(noteIntEnNoteString(note).equals("mi")){
				return "tonique";
			}
			else if(noteIntEnNoteString(note).equals("sol")){
				return "tierce";
			}
			else if(noteIntEnNoteString(note).equals("si")){
				return "quinte";
			}
			break;
		case 4: case 5:
			if(noteIntEnNoteString(note).equals("fa")){
				return "tonique";
			}
			else if(noteIntEnNoteString(note).equals("la")){
				return "tierce";
			}
			else if(noteIntEnNoteString(note).equals("do")){
				return "quinte";
			}
			break;
		case 6:
			if(noteIntEnNoteString(note).equals("sol")){
				return "tonique";
			}
			else if(noteIntEnNoteString(note).equals("si")){
				return "tierce";
			}
			else if(noteIntEnNoteString(note).equals("re")){
				return "quinte";
			}
			break;
		case 7:
			if(noteIntEnNoteString(note).equals("la")){
				return "tonique";
			}
			else if(noteIntEnNoteString(note).equals("do")){
				return "tierce";
			}
			else if(noteIntEnNoteString(note).equals("mi")){
				return "quinte";
			}
			break;
		case 8:
			if(noteIntEnNoteString(note).equals("si")){
				return "tonique";
			}
			else if(noteIntEnNoteString(note).equals("re")){
				return "tierce";
			}
			else if(noteIntEnNoteString(note).equals("fa")){
				return "quinte";
			}
			break;
		}
		return "";
	}
	
	private boolean estTonique(int note, int numAccord){
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
	
	private LinkedList<Integer> accordSuivant(int accord){
		LinkedList<Integer> liste = new LinkedList<Integer>();
		switch (accord) {
		case 1: case 4:
			liste.add(1);
			liste.add(2);
			liste.add(3);
			liste.add(4);
			liste.add(6);
			liste.add(7);
			liste.add(8);
			break;
		case 2:
			liste.add(6);
			liste.add(8);
			break;
		case 3:
			liste.add(2);
			liste.add(3);
			liste.add(4);
			liste.add(6);
			liste.add(7);
			liste.add(8);
			break;
		case 5:
			liste.add(1);
			break;
		case 6:
			liste.add(1);
			liste.add(3);
			liste.add(4);
			liste.add(5);
			break;
		case 7:
			liste.add(2);
			liste.add(3);
			liste.add(4);
			liste.add(6);
			break;
		case 8:
			liste.add(1);
			liste.add(3);
			break;
		default:
			break;
		}
		return liste;
	}
	
	private boolean differenceDeHauteurValide(Note soprano, Note alto, Note tenor, Note basse){
		if (soprano.superieur(alto) && alto.superieur(tenor) && tenor.superieur(basse))
			return true;
		return false;
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
	
	public String noteIntEnNoteString(int nomNote){
		switch (nomNote) {
		case 0: case 7: case 14: case 21:
			return "do";
		case 1: case 8: case 15: case 22:
			return "re";
		case 2: case 9: case 16: case 23:
			return "mi";
		case 3: case 10: case 17: case 24:
			return "fa";
		case 4: case 11: case 18: case 25:
			return "sol";
		case 5: case 12: case 19: case 26:
			return "la";
		case 6: case 13: case 20: case 27:
			return "si";
		default:
			System.err.println("Erreur de note");
			return "";
		}
	}
}
