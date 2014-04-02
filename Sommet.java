package projet;

import java.util.LinkedList;

public class Sommet implements java.lang.Comparable{
	private int positionNoteSoprano, accord;
	private int[] jeu;
	private LinkedList<Sommet> suivants = null;
	private boolean visite = false;
	
	public Sommet(int pNS, int a, int[] j){
		positionNoteSoprano = pNS;
		accord = a;
		jeu  = j;
	}

	public int getPositionNoteSoprano() {
		return positionNoteSoprano;
	}

	public void setPositionNoteSoprano(int positionNoteSoprano) {
		this.positionNoteSoprano = positionNoteSoprano;
	}
	
	public int alto(){
		return jeu[0];
	}
	
	public int tenor(){
		return jeu[1];
	}
	
	public int basse(){
		return jeu[2];
	}

	public int getAccord() {
		return accord;
	}

	public void setAccord(int accord) {
		this.accord = accord;
	}
	
	public int[] getJeu() {
		return jeu;
	}

	public void setJeu(int[] jeu) {
		this.jeu = jeu;
	}
	
	public LinkedList<Sommet> getSuivants() {
		return suivants;
	}

	public void setSuivants(LinkedList<Sommet> suivants) {
		this.suivants = suivants;
	}

	public boolean isVisite() {
		return visite;
	}

	public void setVisite(boolean visite) {
		this.visite = visite;
	}

	public boolean equals(Sommet s1){
		return s1.getAccord() == accord && java.util.Arrays.equals(s1.getJeu(),jeu) && s1.getPositionNoteSoprano() == positionNoteSoprano;
	}
	
	public int compareTo(Object other) { 
	      int nombre1 = ((Sommet) other).getPositionNoteSoprano(); 
	      int nombre2 = this.getPositionNoteSoprano(); 
	      if (nombre1 > nombre2)  return -1; 
	      else if(nombre1 == nombre2) return 0; 
	      else return 1; 
	   } 

	public String toString(){
		String s = "("+positionNoteSoprano;
		if (accord == 1)
			s += " - I - [";
		else if (accord == 2)
			s += " - II - [";
		else if (accord == 3)
			s += " - III - [";
		else if (accord == 4)
			s += " - IV - [";
		else if (accord == 5)
			s += " - V - [";
		else if (accord == 6)
			s += " - VI - [";
		else if (accord == 7)
			s += " - VII - [";
		else
			s += " - acc : " + accord +  " - [";
		for(int i : jeu){
			if(jeu[2] == i)
				s += i;
			else
				s += i+",";
		}
		s += "])";
		return s;
	}
}
