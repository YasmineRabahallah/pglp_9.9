package dessin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dessin.Point2D;
import dessin.Rectangle;

public class RectangleTest {
	@Test
	public void test1(){
		Rectangle r1 = new Rectangle ("R1",1,new Point2D(5,4),2,5);
		assertEquals(r1.idGroupe,1) ;
		assertEquals(r1.name,"R1") ;
		assertEquals(r1.getLongueur(),2,0) ;
		assertEquals(r1.getLargeur(),5,0) ;
		assertEquals(r1.getP().getX(),5) ;
		assertEquals(r1.getP().getY(),4) ;
		r1.deplacer(25, -7);
		assertEquals(r1.getP().getX(),30) ;
		assertEquals(r1.getP().getY(),-3) ;
	}
}
