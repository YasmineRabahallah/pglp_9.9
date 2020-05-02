package Dessin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TriangleTest {
	@Test
	public void test1(){
		Triangle t = new Triangle("t1",3,new Point2D(2,4),new Point2D(-7,2),new Point2D(-15,-15));
		assertEquals(t.IdGroupe,3) ;
		assertEquals(t.name,"t1") ;
		assertEquals(t.getP1().getX(),2);
		assertEquals(t.getP1().getY(),4);
		assertEquals(t.getP2().getX(),-7);
		assertEquals(t.getP2().getY(),2);
		assertEquals(t.getP3().getX(),-15);
		assertEquals(t.getP3().getY(),-15);
		t.deplacer(-5, -5);
		assertEquals(t.getP1().getX(),-3);
		assertEquals(t.getP1().getY(),-1);
		assertEquals(t.getP2().getX(),-12);
		assertEquals(t.getP2().getY(),-3);
		assertEquals(t.getP3().getX(),-20);
		assertEquals(t.getP3().getY(),-20);
	}
}
