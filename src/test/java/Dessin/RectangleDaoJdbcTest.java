package Dessin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

public class RectangleDaoJdbcTest {
	DaoFactoryJdbc df = new DaoFactoryJdbc();
	Dao<Rectangle> daoR = df.createRectangleJdbc();
	Dao<GroupeForme> daoG = df.createGroupeJdbc();
	@Before
	public void deleteTable() {
		Statement statement = null;
		Connection conn = daoR.getConnection();
		String delete ="delete from rectangle";
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
	public void createtest3(){
		GroupeForme g1 = new GroupeForme("groupe1",1);
		assertNotNull(daoG.create(g1)); 
		Rectangle r1 = new Rectangle ("rectangle1",1,new Point2D(5,4),2,5);
		assertNotNull(daoR.create(r1)); 
	}
	@Test
	public void retrievetest3(){
		GroupeForme g2 = new GroupeForme("groupe2",2);
		assertNotNull(daoG.create(g2)); 
		Rectangle r2 = new Rectangle ("rectangle2",2,new Point2D(5,4),2,5);
		assertNotNull(daoR.create(r2)); 
		Rectangle rec = daoR.retrieve("rectangle2");
		assertEquals(rec.getIdGroupe(),2);
		assertEquals(rec.getP().getX(),5);
		assertEquals(rec.getP().getY(),4);
		assertEquals(rec.getLongueur(),2,0);
		assertEquals(rec.getLargeur(),5,0);
	}
	@Test
    public void updatetest3(){
		GroupeForme g3 = new GroupeForme("groupe3",3);
		assertNotNull(daoG.create(g3)); 
		Rectangle r3 = new Rectangle ("rectangle3",3,new Point2D(10,4),20,15);
		assertNotNull(daoR.create(r3)); 
		r3.deplacer(6, 4);
		daoR.update(r3);
		Rectangle rec = daoR.retrieve("rectangle3");
		assertEquals(rec.getIdGroupe(),3);
		assertEquals(rec.getP().getX(),16);
		assertEquals(rec.getP().getY(),8);
		assertEquals(rec.getLongueur(),20,0);
		assertEquals(rec.getLargeur(),15,0);
	}
	@Test
    public void deletetest3(){
		GroupeForme g4 = new GroupeForme("groupe4",4);
		assertNotNull(daoG.create(g4));
		Rectangle r4 = new Rectangle ("rectangle4",4,new Point2D(-8,4),7,3);
		assertNotNull(daoR.create(r4));
		Rectangle rec = daoR.retrieve("rectangle4");
		assertEquals(rec.getIdGroupe(),4);
		daoR.delete(r4);
		assertNull(daoR.retrieve("rectangle4"));
		
	}
}
