package projet;

public class Chant {
	protected Note note;
	protected int duree;
	public Chant(Note note, int duree) throws NumberException{
		if(duree<=0){
			throw new NumberException();
		}else {
			this.note = note;
			this.duree = duree;
		}
	}
	public String toString(){
		return note.toString()+":"+duree;
	}
}
