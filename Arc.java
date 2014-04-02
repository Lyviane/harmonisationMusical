package projet;

public class Arc {
	private Sommet origine, destination;
	
	public Arc(Sommet d, Sommet a){
		origine = d;
		destination = a;
	}
	
	public Sommet getOrigine() {
		return origine;
	}

	public void setOrigine(Sommet origine) {
		this.origine = origine;
	}

	public Sommet getDestination() {
		return destination;
	}

	public void setDestination(Sommet destination) {
		this.destination = destination;
	}
	
	public boolean equals(Arc a){
		return (origine.equals(a.origine) && destination.equals(a.destination));
	}

	public String toString(){
		return origine + " -> " + destination;
	}
}
