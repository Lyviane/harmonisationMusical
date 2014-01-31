package projet;

public class Note {
	private String nomNote;
	private int numeroOctave;
	private int note;
	public Note(String nomNote) throws NoteException{
		if((! nomNote.equals("do"))&&(! nomNote.equals("ré"))&&(! nomNote.equals("mi"))&&(! nomNote.equals("fa"))&&(! nomNote.equals("sol"))&&(! nomNote.equals("la"))&&(! nomNote.equals("si"))){
			throw new NoteException();
		}
		else{ 
			this.nomNote = nomNote;
		}
	}
	public Note(String nomNote, int num) throws NoteException, NumberException{
		if((! nomNote.equals("do"))&&(! nomNote.equals("ré"))&&(! nomNote.equals("mi"))&&(! nomNote.equals("fa"))&&(! nomNote.equals("sol"))&&(! nomNote.equals("la"))
				&&(! nomNote.equals("si"))){
			throw new NoteException();
		}else {
			this.nomNote = nomNote;
		}
		if((num<1)||(num>4)){
			throw new NumberException();
		} else {
			numeroOctave = num;
		}
	}
	
	public String getNomNote() {
		return nomNote;
	}

	public void setNomNote(String nomNote) {
		this.nomNote = nomNote;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getNumeroOctave() {
		return numeroOctave;
	}

	public void setNumeroOctave(int numeroOctave) {
		this.numeroOctave = numeroOctave;
	}

	//cette méthode retourne la un entier qui traduit l'octave et la note donnée en entrée
	public int laNote(){
		if(this.getNomNote().equals("do")){
			if(this.getNumeroOctave()==1) note = 0;
			if(this.getNumeroOctave()==2) note = 7;
			if(this.getNumeroOctave()==3) note = 14;
			if(this.getNumeroOctave()==4) note = 21;
		}
		if(this.getNomNote().equals("ré")){
			if(this.getNumeroOctave()==1) note = 1;
			if(this.getNumeroOctave()==2) note = 8;
			if(this.getNumeroOctave()==3) note = 15;
			if(this.getNumeroOctave()==4) note = 22;
		}
		if(this.getNomNote().equals("mi")){
			if(this.getNumeroOctave()==1) note = 2;
			if(this.getNumeroOctave()==2) note = 9;
			if(this.getNumeroOctave()==3) note = 16;
			if(this.getNumeroOctave()==4) note = 23;
		}
		if(this.getNomNote().equals("fa")){
			if(this.getNumeroOctave()==1) note = 3;
			if(this.getNumeroOctave()==2) note = 10;
			if(this.getNumeroOctave()==3) note = 17;
			if(this.getNumeroOctave()==4) note = 24;
		}
		if(this.getNomNote().equals("sol")){
			if(this.getNumeroOctave()==1) note = 4;
			if(this.getNumeroOctave()==2) note = 11;
			if(this.getNumeroOctave()==3) note = 18;
			if(this.getNumeroOctave()==4) note = 25;
		}
		if(this.getNomNote().equals("la")){
			if(this.getNumeroOctave()==1) note = 5;
			if(this.getNumeroOctave()==2) note = 12;
			if(this.getNumeroOctave()==3) note = 19;
			if(this.getNumeroOctave()==4) note = 26;
		}
		if(this.getNomNote().equals("si")){
			if(this.getNumeroOctave()==1) note = 6;
			if(this.getNumeroOctave()==2) note = 13;
			if(this.getNumeroOctave()==3) note = 20;
			if(this.getNumeroOctave()==4) note = 27;
		}
		return note;
	}
	public String toString(){
		return nomNote+numeroOctave;
	}

}
