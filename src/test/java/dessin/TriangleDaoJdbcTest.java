package dessin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import dao.Dao;
import dao.DaoFactoryJdbc;
import dessin.GroupeForme;
import dessin.Point2D;
import dessin.Triangle;

public class TriangleDaoJdbcTest {
	DaoFactoryJdbc df = new DaoFactoryJdbc();
	Dao<Triangle> daoT =df.crateTriangleJdbc();
	Dao<GroupeForme> daoG = df.createGroupeJdbc();
	@Before
	public void deleteTable() {
		Statement statement = null;
		Connection conn = daoT.getConnection();
		String delete ="delete from triangle";
		try {
			statement = conn.createStatement();
			statement.execute(delete);
			conn.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement statement2 = null ;
		Connection conn2 = daoG.getConnection();
		String deleteGroupe ="delete from Groupes";
		try {
			statement2 = conn2.createStatement();
			statement2.execute(deleteGroupe);
			conn2.close();
			statement2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			
 }
	@Test
	public void createtest4(){
		GroupeForme g1 = new GroupeForme("groupe1",1);
		assertNotNull(daoG.create(g1)); 
		Triangle t1 = new Triangle("triangle1",1,new Point2D(2,4),new Point2D(-7,2),new Point2D(-15,-15));
		assertNotNull(daoT.create(t1)); 
	}
	@Test
	public void retrievetest4(){
		GroupeForme g2 = new GroupeForme("groupe2",2);
		assertNotNull(daoG.create(g2)); 
		Triangle t2 = new Triangle("triangle2",2,new Point2D(2,4),new Point2D(-7,2),new Point2D(-15,-15));
		assertNotNull(daoT.create(t2)); 
		Triangle tr = daoT.retrieve("triangle2");
		assertEquals(tr.getIdGroupe(),2);
		assertEquals(tr.getP1().getX(),2);
		assertEquals(tr.getP1().getY(),4);
		assertEquals(tr.getP2().getX(),-7);
		assertEquals(tr.getP2().getY(),2);
		assertEquals(tr.getP3().getX(),-15);
		assertEquals(tr.getP3().getY(),-15);
		}
	@Test
    public void updatetest4(){
		GroupeForme g3 = new GroupeForme("groupe3",3);
		assertNotNull(daoG.create(g3)); 
		Triangle t3 = new Triangle("triangle3",3,new Point2D(2,4),new Point2D(-7,2),new Point2D(-15,-15));
		assertNotNull(daoT.create(t3)); 
		t3.deplacer(6, 4);
		daoT.update(t3);
		Triangle tr= daoT.retrieve("triangle3");
		assertEquals(tr.getIdGroupe(),3);
		assertEquals(tr.getP1().getX(),8);
		assertEquals(tr.getP1().getY(),8);
		assertEquals(tr.getP2().getX(),-1);
		assertEquals(tr.getP2().getY(),6);
		assertEquals(tr.getP3().getX(),-9);
		assertEquals(tr.getP3().getY(),-11);
	}
	@Test
    public void deletetest4(){
		GroupeForme g4 = new GroupeForme("groupe4",4);
		assertNotNull(daoG.create(g4));
		Triangle t4 = new Triangle("triangle4",4,new Point2D(2,4),new Point2D(-7,2),new Point2D(-15,-15));
		assertNotNull(daoT.create(t4)); 
		Triangle tr = daoT.retrieve("triangle4");
		assertEquals(tr.getIdGroupe(),4);
		daoT.delete(t4);
		assertNull(daoT.retrieve("triangle4"));
		
	}
}
