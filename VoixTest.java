package projet;

import java.util.LinkedList;

import org.junit.Test;

public class VoixTest {

	//@Test
	public void test() {
		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(21);
		liste.add(21);
		liste.add(21);
		liste.add(22);
		liste.add(23);
		liste.add(23);
		liste.add(22);
		Voix v = new Voix(liste);
		System.out.println(v.toString());
	}
	
	@Test
	public void testUnChemin1(){
		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(20);
		liste.add(21);
		liste.add(23);
		Voix v = new Voix(liste);
		LinkedList<Integer> alto;
		alto = v.unChemin(0, 2);
		for(int a : alto){
			System.out.print(a+",");
		}
		System.out.println("");
	}
	
	//@Test
	public void testUnChemin3(){
		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(15);
		liste.add(15);
		Voix v = new Voix(liste);
		LinkedList<Integer> alto;
		alto = v.unChemin(0, 2);
		for(int a : alto){
			System.out.print(a+",");
		}
		System.out.println("");
	}
	
	@Test
	public void testUnChemin2(){
		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(22);
		liste.add(22);
		Voix v = new Voix(liste);
		System.out.println("nombre d'harmonisation possible : "+v.nombreHarmonisationPossible());
	}
	
	//@Test
	public void testUnChemin10(){
		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(22);
		liste.add(22);
		Voix v = new Voix(liste);
		LinkedList<Integer> alto;
		alto = v.unChemin(0, 2);
		for(int a : alto){
			System.out.print(a+",");
		}
		System.out.println("");
	}

}
