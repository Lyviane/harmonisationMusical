package projet;

import org.junit.Test;

public class RegleTest {

	//@Test
	public void test() {
		int[] jeu1 = {20, 18, 11};
		int[] jeu2 = {19, 17, 10};
		Sommet s1 = new Sommet(0, 5, jeu1);
		Sommet s2 = new Sommet(1, 4, jeu2);
		Regle r = new Regle();
		
		System.out.println(r.regle6(s1, s2));
	}
	
	@Test
	public void test2() {
		int[] jeu1 = {19, 17, 8};
		int[] jeu2 = {20, 18, 11};
		Sommet s1 = new Sommet(0, 2, jeu1);
		Sommet s2 = new Sommet(1, 5, jeu2);
		Regle r = new Regle();
		
		System.out.println(r.regle6(s1, s2));
	}
	
	@Test
	public void test3() {
		int[] jeu1 = {20, 18, 11};
		Sommet s1 = new Sommet(0, 5, jeu1);
		Sommet s2 = new Sommet(1, 5, jeu1);
		Regle r = new Regle();
		
		System.out.println(r.regle6(s1, s2));
	}
	
}
