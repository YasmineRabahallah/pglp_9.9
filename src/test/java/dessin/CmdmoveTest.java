package dessin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import commande.CommandCreateCarre;
import commande.CommandCreateCercle;
import commande.CommandMoveCarre;
import commande.CommandMoveCercle;
import commande.DrawingTui;
import commande.Icommande;

public class CmdmoveTest {
	DrawingTui dt = new DrawingTui();
	@Test 
	  public void moveCarreTest() {
		String st = "carre1=carre(1,(1,1),4)";
		 Icommande cmd = dt.nextCommande(st);
		 assertTrue( cmd instanceof CommandCreateCarre);
		 assertEquals(dt.getlistFormes().size(),1);
		 assertEquals(dt.getlistGroupes().size(),1);
		 st="move(carre1,(4,2))";
		 cmd = dt.nextCommande(st);
		 Carre carre= (Carre) dt.getForme(dt.getlistFormes(), "carre1");
		 assertEquals(carre.getCote(),4,0);
		 assertEquals(carre.getP().getX(),5);
		 assertEquals(carre.getP().getY(),3);
		 assertEquals(carre.getIdGroupe(),1);
	}
	@Test 
	  public void moveCercleTest() {
		String st = "cercle1=cercle(1,(4,-1),40)";
		 Icommande cmd = dt.nextCommande(st);
		 assertTrue( cmd instanceof CommandCreateCercle);
		 st="move(cercle1,(4,4))";
		 cmd = dt.nextCommande(st);
		 Cercle cercle= (Cercle) dt.getForme(dt.getlistFormes(), "cercle1");
		    assertEquals(cercle.getName(),"cercle1");
		    assertEquals(cercle.getRayon(),40,0);
		    assertEquals(cercle.getCentre().getX(),8);
		    assertEquals(cercle.getCentre().getY(),3);
		    assertEquals(cercle.getIdGroupe(),1);
	    
	  }
}
