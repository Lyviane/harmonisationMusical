package projet;

public class Note {
	private int note;
	private int duree = 1; //par défaut c'est la durée d'une noire

	public Note(String nomNote) throws NoteException{
		switch (nomNote){
		case "do1":
			note = 0;
			break;
		case "do2":
			note = 7;
			break;
		case "do3":
			note = 14;
			break;
		case "do4":
			note = 21;
			break;
		case "re1":
			note = 1;
			break;
		case "re2":
			note = 8;
			break;
		case "re3":
			note = 15;
			break;
		case "re4":
			note = 22;
			break;
		case "mi1":
			note = 2;
			break;
		case "mi2":
			note = 9;
			break;
		case "mi3":
			note = 16;
			break;
		case "mi4":
			note = 23;
			break;
		case "fa1":
			note = 3;
			break;
		case "fa2":
			note = 10;
			break;
		case "fa3":
			note = 17;
			break;
		case "fa4":
			note = 24;
			break;
		case "sol1":
			note = 4;
			break;
		case "sol2":
			note = 11;
			break;
		case "sol3":
			note = 18;
			break;
		case "sol4":
			note = 25;
			break;
		case "la1":
			note = 5;
			break;
		case "la2":
			note = 12;
			break;
		case "la3":
			note = 19;
			break;
		case "la4":
			note = 26;
			break;
		case "si1":
			note = 6;
			break;
		case "si2":
			note = 13;
			break;
		case "si3":
			note = 20;
			break;
		case "si4":
			note = 27;
			break;
		case "-":
			note = 28;//silence
			break;
		default:
			throw new NoteException();
		}
	}
	
	public Note(String nomNote, int temps) throws NoteException{
		duree = temps;
		
		switch (nomNote){
		case "do1":
			note = 0;
			break;
		case "do2":
			note = 7;
			break;
		case "do3":
			note = 14;
			break;
		case "do4":
			note = 21;
			break;
		case "re1":
			note = 1;
			break;
		case "re2":
			note = 8;
			break;
		case "re3":
			note = 15;
			break;
		case "re4":
			note = 22;
			break;
		case "mi1":
			note = 2;
			break;
		case "mi2":
			note = 9;
			break;
		case "mi3":
			note = 16;
			break;
		case "mi4":
			note = 23;
			break;
		case "fa1":
			note = 3;
			break;
		case "fa2":
			note = 10;
			break;
		case "fa3":
			note = 17;
			break;
		case "fa4":
			note = 24;
			break;
		case "sol1":
			note = 4;
			break;
		case "sol2":
			note = 11;
			break;
		case "sol3":
			note = 18;
			break;
		case "sol4":
			note = 25;
			break;
		case "la1":
			note = 5;
			break;
		case "la2":
			note = 12;
			break;
		case "la3":
			note = 19;
			break;
		case "la4":
			note = 26;
			break;
		case "si1":
			note = 6;
			break;
		case "si2":
			note = 13;
			break;
		case "si3":
			note = 20;
			break;
		case "si4":
			note = 27;
			break;
		case "-":
			note = 28;//silence
			break;
		default:
			throw new NoteException();
		}
	}
	
	public Note(int nom){
		note = nom;
	}
	
	public Note(int nom, int temps){
		note = nom;
		duree = temps;
	}

	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
	
	public String nomNote(){
		switch (note){
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
		case 28:
			return "-";
		default:
			return "";
		}
	}

	public String toString(){
		String nomNote = "";
		switch (note){
		case 0:
			nomNote = "do1";
			break;
		case 7:
			nomNote = "do2";
			break;
		case 14:
			nomNote = "do3";
			break;
		case 21:
			nomNote = "do4";
			break;
		case 1:
			nomNote = "re1";
			break;
		case 8:
			nomNote = "re2";
			break;
		case 15:
			nomNote = "re3";
			break;
		case 22:
			nomNote = "re4";
			break;
		case 2:
			nomNote = "mi1";
			break;
		case 9:
			nomNote = "mi2";
			break;
		case 16:
			nomNote = "mi3";
			break;
		case 23:
			nomNote = "mi4";
			break;
		case 3:
			nomNote = "fa1";
			break;
		case 10:
			nomNote = "fa2";
			break;
		case 17:
			nomNote = "fa3";
			break;
		case 24:
			nomNote = "fa4";
			break;
		case 4:
			nomNote = "sol1";
			break;
		case 11:
			nomNote = "sol2";
			break;
		case 18:
			nomNote = "sol3";
			break;
		case 25:
			nomNote = "sol4";
			break;
		case 5:
			nomNote = "la1";
			break;
		case 12:
			nomNote = "la2";
			break;
		case 19:
			nomNote = "la3";
			break;
		case 26:
			nomNote = "la4";
			break;
		case 6:
			nomNote = "si1";
			break;
		case 13:
			nomNote = "si2";
			break;
		case 20:
			nomNote = "si3";
			break;
		case 27:
			nomNote = "si4";
			break;
		case 28:
			nomNote = "-";
			break;
		}
		
		return nomNote;
	}

}
