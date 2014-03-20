package projet;

import java.util.LinkedList;

import org.junit.Test;

public class VoixTest {

	@Test
	public void test() {
		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(14);
		liste.add(15);
		liste.add(16);
		Voix v = new Voix(liste);
		System.out.println(v.toString());
	}
	
	@Test
	public void testUnChemin(){
		LinkedList<Integer> liste = new LinkedList<Integer>();
		liste.add(14);
		liste.add(15);
		liste.add(16);
		Voix v = new Voix(liste);
		LinkedList<Integer> alto = v.unChemin(0);
		for(int a : alto){
			System.out.print(a+",");
		}
	}

}
