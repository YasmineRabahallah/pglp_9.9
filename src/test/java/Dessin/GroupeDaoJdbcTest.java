package Dessin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class GroupeDaoJdbcTest {
	DaoFactoryJdbc df = new DaoFactoryJdbc();
	Dao<Triangle> daoT =df.crateTriangleJdbc();
	Dao<GroupeForme> daoG = df.createGroupeJdbc();
	Dao<Carre> daoCr = df.createCarreJdbc();
	Dao<Cercle> daoCl = df.createCercleJdbc();
	Dao<Rectangle> daoR = df.createRectangleJdbc();
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
	public void createtest(){
		GroupeForme g1 = new GroupeForme("groupe1",1);
		assertNotNull(daoG.create(g1)); 
	}
	@Test
	public void retrievetest(){
		GroupeForme g2 = new GroupeForme("groupe2",2);
		assertNotNull(daoG.create(g2)); 
		Rectangle r1 = new Rectangle ("rectangle1",2,new Point2D(5,4),2,5);
		assertNotNull(daoR.create(r1)); 
		Cercle c1 = new Cercle ("cercle1",2,new Point2D(2,4),2);
		assertNotNull(daoCl.create(c1));
		g2.add(c1);
		g2.add(r1);
		GroupeForme g = daoG.retrieve("2");
		assertEquals(g.getFormes().size(),2);
	}
	@Test
	public void updatetest(){
		GroupeForme g3 = new GroupeForme("groupe3",3);
		assertNotNull(daoG.create(g3)); 
		Carre c1 = new Carre ("carre1",3,new Point2D(-5,4),10);
		assertNotNull(daoCr.create(c1));
		Rectangle r1 = new Rectangle ("rectangle1",3,new Point2D(5,4),2,5);
		assertNotNull(daoR.create(r1));
		Cercle cl1 = new Cercle ("cercle1",3,new Point2D(2,4),2);
		assertNotNull(daoCl.create(cl1));
		Triangle t1 = new Triangle("triangle1",3,new Point2D(2,4),new Point2D(-7,2),new Point2D(-15,-15));
		assertNotNull(daoT.create(t1));
		g3.add(c1);
		g3.add(r1);
		g3.add(cl1);
		g3.add(t1);
		g3.deplacer(1, 1);
		daoG.update(g3);
		GroupeForme g = daoG.retrieve("3");
		assertEquals(g.getFormes().size(),4) ;
		Carre c= daoCr.retrieve("carre1");
		assertEquals(c.getP().getX(),-4);
		Rectangle r = daoR.retrieve("rectangle1");
		assertEquals(r.getP().getX(),6);
	    Cercle cl = daoCl.retrieve("cercle1");
	    assertEquals(cl.getCentre().getX(),3);
	    Triangle t = daoT.retrieve("triangle1");
	    assertEquals(t.getP1().getX(),3);
	    assertEquals(t.getP1().getY(),5);
	    assertEquals(t.getP2().getX(),-6);
	    assertEquals(t.getP2().getY(),3);
	    assertEquals(t.getP3().getX(),-14);
	    assertEquals(t.getP3().getY(),-14);
	}
	@Test
    public void deletetest(){
		GroupeForme g4 = new GroupeForme("groupe4",4);
		assertNotNull(daoG.create(g4)); 
		assertEquals(g4.IdGroupe,4);
		daoG.delete(g4);
		assertNull(daoG.retrieve("4"));
		}
}
