package commande;

import static org.junit.Assert.*;

import org.junit.Test;

import commande.CommandCreatTriangle;
import commande.CommandCreateCarre;
import commande.DrawingTui;
import commande.Icommande;

public class CmdCreateFormeTest {
	 DrawingTui dt = new DrawingTui();
	 @Test 
	  public void createTest() {
		 String st = "carre1=carre(1,(1,1),4)";
		 Icommande cmd = dt.nextCommande(st);
		 assertTrue( cmd instanceof CommandCreateCarre);
		 assertEquals(dt.getlistFormes().size(),1);
		 assertEquals(dt.getlistGroupes().size(),1);
		  st = "triangle1=triangle(2,(7,1),(14,8),(8,-12))";
		 Icommande cmd2 = dt.nextCommande(st);
		 assertTrue( cmd2 instanceof CommandCreatTriangle);
		 assertEquals(dt.getlistFormes().size(),2);
		 assertEquals(dt.getlistGroupes().size(),2);
		  st = "triangle2=triangle(2,(3,1),(1,18),(28,-2))";
		  Icommande cmd3 = dt.nextCommande(st);
		  assertTrue( cmd3 instanceof CommandCreatTriangle);
		  assertEquals(dt.getlistFormes().size(),3);
		  assertEquals(dt.getlistGroupes().size(),2);
		 
	 }
	 
	 
	 
}
