package dessin;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import dao.Dao;
import dao.DaoFactoryJdbc;
import dessin.Cercle;
import dessin.GroupeForme;
import dessin.Point2D;

public class CercleDaoJdbcTest {
	DaoFactoryJdbc df = new DaoFactoryJdbc();
	Dao<Cercle> daoC = df.createCercleJdbc();
	Dao<GroupeForme> daoG = df.createGroupeJdbc();
	@Before
	public void deleteTable() {
		Statement statement = null;
		Connection conn = daoC.getConnection();
		String delete ="delete from cercle";
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
	public void createtest(){
		GroupeForme g1 = new GroupeForme("groupe1",1);
		assertNotNull(daoG.create(g1)); 
		Cercle c = new Cercle ("cercle1",1,new Point2D(2,4),2);
		assertNotNull(daoC.create(c));
	}
	@Test
	public void retrievetest(){
		GroupeForme g2 = new GroupeForme("groupe2",2);
		assertNotNull(daoG.create(g2)); 
		Cercle c2 = new Cercle ("cercle2",2,new Point2D(20,-4),70);
		assertNotNull(daoC.create(c2));
		Cercle c = daoC.retrieve("cercle2");
		assertEquals(c.getIdGroupe(),2);
		assertEquals(c.getCentre().getX(),20);
		assertEquals(c.getCentre().getY(),-4);
		assertEquals(c.getRayon(),70,0);
	}
	@Test
    public void updatetest(){
		GroupeForme g3 = new GroupeForme("groupe3",3);
		assertNotNull(daoG.create(g3)); 
		Cercle c3 = new Cercle ("cercle3",3,new Point2D(-5,8),10);
		assertNotNull(daoC.create(c3));
		c3.deplacer(5,5);
		Cercle c = daoC.update(c3);
		assertEquals(c.getCentre().getX(),0);
		assertEquals(c.getCentre().getY(),13);
	}
	@Test
    public void deletetest(){
		GroupeForme g4 = new GroupeForme("groupe4",4);
		assertNotNull(daoG.create(g4)); 
		Cercle c4 = new Cercle ("cercle4",4,new Point2D(-10,2),7);
		assertNotNull(daoC.create(c4));
		Cercle c = daoC.retrieve("cercle4");
		assertEquals(c.idGroupe,4);
		daoC.delete(c4);
		assertNull(daoC.retrieve("cercle4"));
		}
}
