package projet;

public class Accord {
	int[] accord = new int[3];
	
	public Accord(int note){
		String nom = Note.noteIntEnNoteString(note);
		switch(nom){
		case "do":
			accord[0] = 1; //do est dans l'accord 1
			accord[1] = 4; //do est dans l'accord 4
			accord[2] = 5; //do est dans l'accord 5
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
}
