package dessin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import commande.CommandMoveCarre;
import commande.CommandMoveCercle;
import commande.CommandMoveGroup;
import commande.CommandMoveRectangle;
import commande.CommandMoveTriangle;
import dessin.Carre;
import dessin.Cercle;
import dessin.GroupeForme;
import dessin.Point2D;
import dessin.Rectangle;
import dessin.Triangle;

public class CommandemoveTest {
	
	@Test 
	  public void moveCarreTest() {
		Carre carre= new Carre("carre1",2,new Point2D(4,4),7);
		CommandMoveCarre cmdC = new CommandMoveCarre(carre,2,2);
	    cmdC.execute();
	    assertEquals(carre.getName(),"carre1");
	    assertEquals(carre.getCote(),7,0);
	    assertEquals(carre.getP().getX(),6);
	    assertEquals(carre.getP().getY(),6);
	    assertEquals(carre.getIdGroupe(),2);
	    
	  }
	@Test 
	  public void moveCercleTest() {
		Cercle cercle= new Cercle("cercle1",2,new Point2D(7,40),7);
		CommandMoveCercle cmdCr = new CommandMoveCercle(cercle,2,2);
	    cmdCr.execute();
	    assertEquals(cercle.getName(),"cercle1");
	    assertEquals(cercle.getRayon(),7,0);
	    assertEquals(cercle.getCentre().getX(),9);
	    assertEquals(cercle.getCentre().getY(),42);
	    assertEquals(cercle.getIdGroupe(),2);
	    
	  }
	@Test 
	  public void moveRectangleTest() {
		Rectangle rec= new Rectangle("rectangle1",2,new Point2D(8,-4),7,8);
		CommandMoveRectangle cmdR = new CommandMoveRectangle(rec,2,2);
	    cmdR.execute();
	    assertEquals(rec.getName(),"rectangle1");
	    assertEquals(rec.getLongueur(),7,0);
	    assertEquals(rec.getLargeur(),8,0);
	    assertEquals(rec.getP().getX(),10);
	    assertEquals(rec.getP().getY(),-2);
	    assertEquals(rec.getIdGroupe(),2);
	    
	  }
	@Test 
	  public void moveTriangleTest() {
		Triangle t = new Triangle("trinagle1",2,new Point2D(8,-4),new Point2D(2,-7),new Point2D(8,-18));
		CommandMoveTriangle cmdT = new CommandMoveTriangle(t,2,2);
	    cmdT.execute();
	    assertEquals(t.getName(),"trinagle1");
	    assertEquals(t.getP1().getX(),10);
	    assertEquals(t.getP1().getY(),-2);
	    assertEquals(t.getP2().getX(),4);
	    assertEquals(t.getP2().getY(),-5);
	    assertEquals(t.getP3().getX(),10);
	    assertEquals(t.getP3().getY(),-16);
	    assertEquals(t.getIdGroupe(),2);
	    
	  }
	@Test 
	  public void moveGroupeeTest() {
		Triangle t = new Triangle("trinagle1",2,new Point2D(8,-4),new Point2D(2,-7),new Point2D(8,-18));
		GroupeForme g = new GroupeForme("groupe2",2);
		g.add(t);
		CommandMoveGroup cmdG = new CommandMoveGroup(g,2,2);
	    cmdG.execute();
	    assertEquals(t.getName(),"trinagle1");
	    assertEquals(t.getP1().getX(),10);
	    assertEquals(t.getP1().getY(),-2);
	    assertEquals(t.getP2().getX(),4);
	    assertEquals(t.getP2().getY(),-5);
	    assertEquals(t.getP3().getX(),10);
	    assertEquals(t.getP3().getY(),-16);
	    assertEquals(t.getIdGroupe(),2);
	    
	  }
	
}
