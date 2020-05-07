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
import dessin.Carre;
import dessin.GroupeForme;
import dessin.Point2D;

public class CarreDaoJdbcTest {
	DaoFactoryJdbc df = new DaoFactoryJdbc();
	Dao<Carre> daoC = df.createCarreJdbc();
	Dao<GroupeForme> daoG = df.createGroupeJdbc();
	@Before
	public void deleteTable() {
		Statement statement = null;
		Connection conn = daoC.getConnection();
		String deleteCarre ="delete from carre";
		try {
			statement = conn.createStatement();
			statement.execute(deleteCarre);
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
	public void createtest2(){
		GroupeForme g5 = new GroupeForme("groupe5",5);
		assertNotNull(daoG.create(g5)); 
		Carre c1 = new Carre ("carre1",5,new Point2D(-5,4),10);
		assertNotNull(daoC.create(c1));
	}
	@Test
	public void retrievetest2(){
		GroupeForme g6 = new GroupeForme("groupe6",6);
		assertNotNull(daoG.create(g6));
		Carre c2 = new Carre ("carre2",6,new Point2D(20,-4),70);
		assertNotNull(daoC.create(c2));
		Carre carre = daoC.retrieve("carre2");
		assertEquals(carre.getIdGroupe(),6);
		assertEquals(carre.getCote(),70,0);
		assertEquals(carre.getP().getX(),20);
		assertEquals(carre.getP().getY(),-4);
		}
	@Test
    public void updatetest(){
		GroupeForme g7 = new GroupeForme("groupe7",7);
		assertNotNull(daoG.create(g7));
		Carre c3 = new Carre ("carre3",7,new Point2D(20,-4),70);
		assertNotNull(daoC.create(c3));
		c3.deplacer(-10,-10);
		Carre c = daoC.update(c3);
	}
	@Test
    public void deletetest(){
		GroupeForme g8 = new GroupeForme("groupe8",8);
		assertNotNull(daoG.create(g8));
		Carre c4 = new Carre ("carre4",8,new Point2D(10,10),10);
		assertNotNull(daoC.create(c4));
		Carre c = daoC.retrieve("carre4");
		assertEquals(c.idGroupe,8);
		daoC.delete(c4);
		assertNull(daoC.retrieve("carre4"));
	}
	
	
	
	
}
