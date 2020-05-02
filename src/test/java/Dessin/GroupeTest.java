package Dessin;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class GroupeTest {
	@Test
	public void test1(){
     GroupeForme g1 = new GroupeForme("groupe1",1);
     
     Carre c1 = new Carre ("c1",1,new Point2D(-5,4),10);
     Rectangle r1 = new Rectangle ("R1",1,new Point2D(5,4),2,5);
     g1.add(c1);
     g1.add(r1);
     assertEquals(g1.getName(),"groupe1") ;
     assertEquals(g1.getIdGroupe(),1) ;
     g1.deplacer(2, 2);
     assertEquals(c1.getP().getX(),-3);
	 assertEquals(c1.getP().getY(),6);
	 assertEquals(r1.getP().getX(),7) ;
	 assertEquals(r1.getP().getY(),6) ;
     
	}
	@Test
	public void test2(){
     GroupeForme g2 = new GroupeForme("groupe2",2);
     
     Carre c2 = new Carre ("c2",2,new Point2D(-5,4),10);
     Rectangle r2 = new Rectangle ("R2",2,new Point2D(5,4),2,5);
     assertEquals(g2.getFormes().size(),0) ;
     g2.add(c2);
     g2.add(r2);
     assertEquals(g2.getFormes().size(),2) ;
     g2.remove(c2);
     assertEquals(g2.getFormes().size(),1) ;
     
	}
}
