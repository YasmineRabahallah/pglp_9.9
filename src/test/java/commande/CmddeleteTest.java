package commande;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import dao.Dao;
import dao.DaoFactoryJdbc;
import dessin.Carre;
import dessin.Cercle;
import dessin.GroupeForme;
import dessin.Point2D;
import dessin.Rectangle;
import dessin.Triangle;

public class CmddeleteTest {
	DaoFactoryJdbc df = new DaoFactoryJdbc();
	Dao<Triangle> daoT =df.crateTriangleJdbc();
	Dao<GroupeForme> daoG = df.createGroupeJdbc();
	Dao<Carre> daoCr = df.createCarreJdbc();
	Dao<Cercle> daoCl = df.createCercleJdbc();
	Dao<Rectangle> daoR = df.createRectangleJdbc();
	DrawingTui dt = new DrawingTui();
	@Before
	public void deleteTable() {
		Connection conn = daoG.getConnection();
		String deletecarre = "delete from carre";
		String deletecercle = "delete from cercle";
		String deletetriangle = "delete from triangle";
		String deleterec = "delete from rectangle";
		String deleteGroupe ="delete from Groupes";
		try {
			conn.createStatement().execute(deletecarre);
			conn.createStatement().execute(deletecercle);
			conn.createStatement().execute(deletetriangle);
			conn.createStatement().execute(deleterec);
			conn.createStatement().execute(deleteGroupe);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Test 
	  public void deleteTest() {
		
		String st = "carre1=carre(2,(1,1),4)";
		Icommande cmd = dt.nextCommande(st);
		 assertTrue( cmd instanceof CommandCreateCarre);
		 assertEquals(dt.getlistFormes().size(),1);
		 assertEquals(dt.getlistGroupes().size(),1);
		 st ="save(groupe2)";
		 dt.nextCommande(st);
		 st = "delete(groupe2)";
		dt.nextCommande(st);
		assertNull(daoG.retrieve("2"));
		
		 
		 
		}

}
