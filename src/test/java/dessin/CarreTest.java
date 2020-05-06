package dessin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dessin.Carre;
import dessin.Point2D;

public class CarreTest {
	@Test
	public void test1(){
		Carre c1 = new Carre ("c1",2,new Point2D(-5,4),10);
		assertEquals(c1.idGroupe,2) ;
		assertEquals(c1.name,"c1") ;
		assertEquals(c1.getCote(),10,0);
		assertEquals(c1.getP().getX(),-5);
		assertEquals(c1.getP().getY(),4);
		c1.deplacer(-7, -25);
		assertEquals(c1.getP().getX(),-12);
		assertEquals(c1.getP().getY(),-21);
		
		
	}
}
