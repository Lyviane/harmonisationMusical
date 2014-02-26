package projet;

public class Accord {
	int[][] jeu;//accord possible pour une note
	
	public Accord(Soprano s){
		//accord I: 1, II: 2, III: 3, IV: 4, IVb: 5, V: 6, VI: 7, VII: 8
		
		switch (s.note) {
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
	
	public boolean differenceDeHauteurValide(Note soprano, Note alto, Note tenor, Note basse){
		if (soprano.superieur(alto) && alto.superieur(tenor) && tenor.superieur(basse))
			return true;
		return false;
	}
	
	public boolean differenceEntreDeuxNotesValide(Note n1, Note n2){
		if (n1.getNote() >= n2.getNote()){
			if(n1.getNote()-n2.getNote() > 6)
				return false;
			return true;
		}
		else{
			if(n2.getNote()-n1.getNote() > 6)
				return false;
			return true;
		}
	}
}
