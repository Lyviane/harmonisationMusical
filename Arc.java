package projet;

public class Arc {
	private Sommet depart, arrive;
	
	public Arc(Sommet d, Sommet a){
		depart = d;
		arrive = a;
	}

	public Sommet getDepart() {
		return depart;
	}

	public void setDepart(Sommet depart) {
		this.depart = depart;
	}

	public Sommet getArrive() {
		return arrive;
	}

	public void setArrive(Sommet arrive) {
		this.arrive = arrive;
	}
	
	public String toString(){
		return depart + " -> " + arrive;
	}
}
