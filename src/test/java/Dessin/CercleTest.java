package Dessin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CercleTest {
	@Test
	public void test1(){
		Cercle c = new Cercle ("c1",1,new Point2D(2,4),2);
		assertEquals(c.IdGroupe,1) ;
		assertEquals(c.name,"c1") ;
		assertEquals(c.getRayon(),2,0) ;
		assertEquals(c.getCentre().getX(),2) ;
		assertEquals(c.getCentre().getY(),4) ;
		c.deplacer(7, 3);
		assertEquals(c.getCentre().getX(),9) ;
		assertEquals(c.getCentre().getY(),7) ;
		}
}
