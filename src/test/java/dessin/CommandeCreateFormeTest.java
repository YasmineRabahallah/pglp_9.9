package dessin;

import static org.junit.Assert.*;

import org.junit.Test;

import commande.CommadCreateGroup;
import commande.CommandCreatTriangle;
import commande.CommandCreateCarre;
import commande.CommandCreateCercle;
import commande.CommandCreateRectangle;
import dessin.Carre;
import dessin.Cercle;
import dessin.GroupeForme;
import dessin.Point2D;
import dessin.Rectangle;
import dessin.Triangle;

public class CommandeCreateFormeTest {
	 CommandCreateCarre cmd = new CommandCreateCarre("carre1",2,new Point2D(4,4),7);
	 CommandCreateRectangle cmdR = new CommandCreateRectangle("rectangle1",2,new Point2D(8,-4),7,8);
	 CommandCreatTriangle cmdT = new CommandCreatTriangle("trinagle1",2,new Point2D(8,-4),new Point2D(2,-7),new Point2D(8,-18));
	 CommandCreateCercle cmdCr = new CommandCreateCercle("cercle1",2,new Point2D(7,40),7);
	 CommadCreateGroup cmdG = new CommadCreateGroup("groupe1",2);
	  @Test 
	  public void createTest1() {
	    Carre carre = cmd.execute();
	    assertEquals(carre.getName(),"carre1");
	    assertEquals(carre.getCote(),7,0);
	    assertEquals(carre.getP().getX(),4);
	    assertEquals(carre.getP().getY(),4);
	    assertEquals(carre.getIdGroupe(),2);
	    
	  }
	  @Test 
	  public void createTest2() {
	    Rectangle r = cmdR.execute();
	    assertEquals(r.getName(),"rectangle1");
	    assertEquals(r.getLongueur(),7,0);
	    assertEquals(r.getLargeur(),8,0);
	    assertEquals(r.getP().getX(),8);
	    assertEquals(r.getP().getY(),-4);
	    assertEquals(r.getIdGroupe(),2);
	    
	  }
	  @Test 
	  public void createTest3() {
	    Triangle t = cmdT.execute();
	    assertEquals(t.getName(),"trinagle1");
	    assertEquals(t.getP1().getX(),8);
	    assertEquals(t.getP1().getY(),-4);
	    assertEquals(t.getP2().getX(),2);
	    assertEquals(t.getP2().getY(),-7);
	    assertEquals(t.getP3().getX(),8);
	    assertEquals(t.getP3().getY(),-18);
	    assertEquals(t.getIdGroupe(),2);
	    
	  }
	  @Test 
	  public void createTest4() {
	    Cercle cercle = cmdCr.execute();
	    assertEquals(cercle.getName(),"cercle1");
	    assertEquals(cercle.getRayon(),7,0);
	    assertEquals(cercle.getCentre().getX(),7);
	    assertEquals(cercle.getCentre().getY(),40);
	    assertEquals(cercle.getIdGroupe(),2);
	    
	  }
	  @Test 
	  public void createTest5() {
	    GroupeForme g = cmdG.execute();
	    assertEquals(g.getName(),"groupe1");
	    assertEquals(g.getIdGroupe(),2);
	    
	  }
	  
	  
}
