package projet;

import java.util.LinkedList;

import org.junit.Test;

public class VoixTest {

	@Test
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
	public void testUnCheminf(){
		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(22);
		liste.add(22);
		Voix v = new Voix(liste);
		LinkedList<Integer> alto;
		alto = v.unChemin(0);
		for(int a : alto){
			System.out.print(a+",");
		}
		System.out.println("");
	}
	
	@Test
	public void testUnChemin(){
		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(14);
		liste.add(15);
		liste.add(16);
		liste.add(17);
		Voix v = new Voix(liste);
		LinkedList<Integer> alto;
		alto = v.unChemin(0);
		for(int a : alto){
			System.out.print(a+",");
		}
		System.out.println("");
	}

}
