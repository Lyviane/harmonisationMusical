package projet;

public class Sommet {
	private int positionNoteSoprano, accord;
	
	public Sommet(int pNS, int a){
		positionNoteSoprano = pNS;
		accord = a;
	}

	public int getPositionNoteSoprano() {
		return positionNoteSoprano;
	}

	public void setPositionNoteSoprano(int positionNoteSoprano) {
		this.positionNoteSoprano = positionNoteSoprano;
	}

	public int getAccord() {
		return accord;
	}

	public void setAccord(int accord) {
		this.accord = accord;
	}
	
	public String toString(){
		return "pos : "+positionNoteSoprano + " - acc : "+accord;
	}
}
