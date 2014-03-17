package projet;

import java.util.LinkedList;

public class Accord {
	int[] accord = new int[3];
	
	public Accord(int note){
		String nom = Note.noteIntEnNoteString(note);
		switch(nom){
		case "do":
			accord[0] = 1; //do est dans l'accord 1
			accord[1] = 4; //do est dans l'accord 4
			accord[2] = 6; //do est dans l'accord 5
			break;
		case "re":
			accord[0] = 2; 
			accord[1] = 5; 
			accord[2] = 7;
			break;
		case "mi":
			accord[0] = 1; 
			accord[1] = 3; 
			accord[2] = 6;
			break;
		case "fa":
			accord[0] = 2; 
			accord[1] = 4; 
			accord[2] = 7;
			break;
		case "sol":
			accord[0] = 1; 
			accord[1] = 3; 
			accord[2] = 5;
			break;
		case "la":
			accord[0] = 2; 
			accord[1] = 4; 
			accord[2] = 6;
			break;
		case "si":
			accord[0] = 3; 
			accord[1] = 5; 
			accord[2] = 7;
			break;
		}
	}

	public int[] getAccord() {
		return accord;
	}

	public void setAccord(int[] accord) {
		this.accord = accord;
	}
	
	public static int[] noteDeLAccord(int accord){
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
		case 4:
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
		case 5:
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
		case 6:
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
		case 7:
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
	
	public LinkedList<Integer> accordSuivant(int acc){
		LinkedList<Integer> liste = new LinkedList<Integer>();
		switch (acc) {
		case 1: case 4:
			liste.add(1);
			liste.add(2);
			liste.add(3);
			liste.add(4);
			liste.add(5);
			liste.add(6);
			liste.add(7);
			break;
		case 2:
			liste.add(5);
			liste.add(7);
			break;
		case 3:
			liste.add(2);
			liste.add(3);
			liste.add(4);
			liste.add(5);
			liste.add(6);
			liste.add(7);
			break;
		case 5:
			liste.add(1);
			liste.add(3);
			liste.add(4);
			liste.add(6);
			break;
		case 6:
			liste.add(2);
			liste.add(3);
			liste.add(4);
			liste.add(5);
			break;
		case 7:
			liste.add(1);
			liste.add(3);
			break;
		}
		return liste;
	}
}
