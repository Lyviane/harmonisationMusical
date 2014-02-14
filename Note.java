package projet;

public class Note {
	private String nomNote;
	private int numeroOctave;
	private int duree = 1; //par défaut c'est la durée d'une noire
	
	public Note(String nomNote) throws NoteException{
		if((! nomNote.equals("do"))&&(! nomNote.equals("re"))&&(! nomNote.equals("mi"))&&(! nomNote.equals("fa"))&&(! nomNote.equals("sol"))&&(! nomNote.equals("la"))&&(! nomNote.equals("si"))){
			throw new NoteException();
		}
		else{ 
			this.nomNote = nomNote;
		}
	}
	
	public Note(String nomNote, int num) throws NoteException, NumberException{
		if((! nomNote.equals("do"))&&(! nomNote.equals("re"))&&(! nomNote.equals("mi"))&&(! nomNote.equals("fa"))&&(! nomNote.equals("sol"))&&(! nomNote.equals("la"))
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
	
	public Note(String nomNote, int num, int temps) throws NoteException, NumberException{
		if((! nomNote.equals("do"))&&(! nomNote.equals("re"))&&(! nomNote.equals("mi"))&&(! nomNote.equals("fa"))&&(! nomNote.equals("sol"))&&(! nomNote.equals("la"))
				&&(! nomNote.equals("si") && (!nomNote.equals("silence")))){
			throw new NoteException();
		}else {
			this.nomNote = nomNote;
		}
		
		if((num<1)||(num>4)){
			throw new NumberException();
		} else {
			numeroOctave = num;
		}
		
		duree = temps;
	}
	
	public String getNomNote() {
		return nomNote;
	}

	public void setNomNote(String nomNote) {
		this.nomNote = nomNote;
	}

	public int getNumeroOctave() {
		return numeroOctave;
	}

	public void setNumeroOctave(int numeroOctave) {
		this.numeroOctave = numeroOctave;
	}
	
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	public String toString(){
		return nomNote+numeroOctave;
	}

}
