package dessin;



import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class GroupeDaoJdbc implements Dao<GroupeForme> {
	private Connection conn = null;
    String sql ="CREATE TABLE Groupes (idGroupe Integer  PRIMARY KEY NOT NULL , nomGroupe varchar(40) NOT NULL) " ;
    private Statement statement ;
    public GroupeDaoJdbc(){
    	conn = this.getConnection();
    	try {
			statement = conn.createStatement();
			if(!doesTableExists("Groupes",conn)){
				statement.execute(sql);
			}
		statement.close();
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
	public GroupeForme create(GroupeForme obj) {
		PreparedStatement statement = null;
		int rowsInserted = 0;
		conn = this.getConnection();
		String insert ="INSERT INTO Groupes (idGroupe,nomGroupe) VALUES (?,?)";
		try {
			statement = conn.prepareStatement(insert);
			statement.setInt(1, obj.getIdGroupe());
			statement.setString(2, obj.getName());
			rowsInserted = statement.executeUpdate();
			ArrayList<Forme> l = obj.getFormes();
			int verifie = 0;
		      while (verifie < l.size()) {
		        if (l.get(verifie) instanceof GroupeForme) {
		          this.create((GroupeForme)l.get(verifie));
		        }
		        verifie++;
		      }
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			try {
				if (statement != null){
				statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(rowsInserted > 0){
			System.out.println("Un nouveau groupe a été inséré avec succès!");
		    return obj;
		} else {
			return null ;
		}
		
	}

	public GroupeForme retrieve(String id) {
		GroupeForme g = null;
		int idG =  Integer.parseInt(id);
		PreparedStatement statementG = null;
		PreparedStatement statementCr = null;
		PreparedStatement statementCl = null;
		PreparedStatement statementT = null;
		PreparedStatement statementR = null;
		Carre c = null ;
		Cercle cl = null;
		Triangle t = null;
		Rectangle r = null;
		conn = this.getConnection();
		String selectG ="select * from Groupes where idGroupe = (?)";
		String selectCr ="select * from carre where idGroupe = (?)";
		String selectCl ="select * from cercle where idGroupe = (?)";
		String selectT ="select * from triangle where idGroupe = (?)";
		String selectR ="select * from rectangle where idGroupe = (?)";
		try {
			statementG = conn.prepareStatement(selectG);
			statementG.setInt(1, idG);
			statementG.execute();
			ResultSet result = statementG.getResultSet();
			if(result.next()){
			int idGroupe = result.getInt("idGroupe");
			String nomGroupe = result.getString("nomGroupe");
			g = new GroupeForme(nomGroupe,idGroupe);
	        statementCr =conn.prepareStatement(selectCr);
	        statementCr.setInt(1, idG);
	        statementCr.execute();
	        ResultSet resultCr = statementCr.getResultSet();
	        while(resultCr.next()){
	        	String nom = resultCr.getString("nom");
				int idGroupeC = resultCr.getInt("idGroupe");
				int px = resultCr.getInt("px");
				int py = resultCr.getInt("py");
				double cote = resultCr.getDouble("cote");
				c = new Carre(nom, idGroupeC ,new Point2D(px,py),cote);
				g.add(c);
	        }
	        statementCl =conn.prepareStatement(selectCl);
	        statementCl.setInt(1, idG);
	        statementCl.execute();
	        ResultSet resultCl = statementCl.getResultSet();
	        while(resultCl.next()){
	        	String nom = resultCl.getString("nom");
				int idGroupeCl = resultCl.getInt("idGroupe");
				int px = resultCl.getInt("px");
				int py = resultCl.getInt("py");
				double rayon = resultCl.getDouble("rayon");
				cl = new Cercle (nom,idGroupeCl,new Point2D(px,py),rayon);
				g.add(cl);
	        }
	        statementT = conn.prepareStatement(selectT);
			statementT.setInt(1, idG);
			statementT.execute();
			ResultSet resultT = statementT.getResultSet();
			while(resultT.next()){
				String nom = resultT.getString("nom");
				int idGroupeT = resultT.getInt("idGroupe");
				int p1x = resultT.getInt("p1x");
				int p1y = resultT.getInt("p1y");
				int p2x = resultT.getInt("p2x");
				int p2y = resultT.getInt("p2y");
				int p3x = resultT.getInt("p3x");
				int p3y = resultT.getInt("p3y");
			t = new Triangle(nom,idGroupeT,new Point2D(p1x,p1y),new Point2D(p2x,p2y),new Point2D(p3x,p3y));
			g.add(t);
			}
			statementR = conn.prepareStatement(selectR);
			statementR.setInt(1, idG);
			statementR.execute();
			ResultSet resultR = statementR.getResultSet();
			while(resultR.next()){
				String nom = resultR.getString("nom");
				int idGroupeR = resultR.getInt("idGroupe");
				int px = resultR.getInt("px");
				int py = resultR.getInt("py");
				double lon = resultR.getDouble("longueur");
				double lar = resultR.getDouble("largeur");
				r = new Rectangle(nom,idGroupeR,new Point2D(px,py),lon,lar);
				g.add(r);
			}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		try {
		if (statementG != null){
				statementG.close();
				}
		if(statementCr != null){
			statementCr.close();
		}
		if (statementCl != null){
			statementCl.close();
			}
		if (statementT != null){
			statementT.close();
			}
		if (statementR != null){
			statementR.close();
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return g;
	}

	public GroupeForme update(GroupeForme obj) {
		PreparedStatement statementCr = null;
		PreparedStatement statementCl = null;
		PreparedStatement statementT = null;
		PreparedStatement statementR = null;
		PreparedStatement statement = null;
		int rowsUpdated = 0;
		conn = this.getConnection();
		String update ="UPDATE Groupes SET nomGroupe=(?) where  idGroupe= (?)";
		try {
			statement = conn.prepareStatement(update);
			statement.setString(1, obj.getName());
			statement.setInt(2, obj.getIdGroupe());
			rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0){
				System.out.println("Un groupe existant a été mis à jour avec succès !");
			}
			ArrayList<Forme> listFormes = obj.getFormes();
			for (Forme f :listFormes){
				if (f instanceof Carre){
					conn = this.getConnection();
					String updateCr = "UPDATE carre SET   idGroupe = ?, px = ?, py = ?, cote =? WHERE nom=?" ;
						statementCr = conn.prepareStatement(updateCr);
						statementCr.setInt(1, ((Carre) f).getIdGroupe());
						statementCr.setInt(2, ((Carre) f).getP().getX());
						statementCr.setInt(3, ((Carre) f).getP().getY());
						statementCr.setDouble(4,((Carre) f).getCote());
						statementCr.setString(5, ((Carre) f).getName());
					int rowsUpdatedCr = statementCr.executeUpdate();
					if(rowsUpdatedCr > 0){
						System.out.println("Un carre existant a été mis à jour avec succès !");
					}
				conn.close();
				}
				if(f instanceof Cercle){
					conn = this.getConnection();
					String updatecercle ="UPDATE cercle SET   idGroupe = ?, px = ?, py = ?, rayon =? WHERE nom=?";
					statementCl = conn.prepareStatement(updatecercle);
					statementCl.setInt(1, ((Cercle) f).getIdGroupe());
					statementCl.setInt(2, ((Cercle) f).getCentre().getX());
					statementCl.setInt(3, ((Cercle) f).getCentre().getY());
					statementCl.setDouble(4, ((Cercle) f).getRayon());
					statementCl.setString(5, ((Cercle) f).getName());
					int rowsUpdatedCl = statementCl.executeUpdate();
					if (rowsUpdatedCl > 0){
						 System.out.println("Un cercle existant a été mis à jour avec succès !");
					}
					conn.close();
				}
				if(f instanceof Triangle){
					conn = this.getConnection();
					String updatetr = "UPDATE triangle SET   idGroupe = ?, p1x = ?, p1y = ?, p2x = ?, p2y = ?, p3x = ?, p3y = ?  WHERE nom=?" ;
					statementT = conn.prepareStatement(updatetr);
					statementT.setInt(1, ((Triangle) f).getIdGroupe());
					statementT.setInt(2, ((Triangle) f).getP1().getX());
					statementT.setInt(3, ((Triangle) f).getP1().getY());
					statementT.setInt(4, ((Triangle) f).getP2().getX());
					statementT.setInt(5, ((Triangle) f).getP2().getY());
					statementT.setInt(6, ((Triangle) f).getP3().getX());
					statementT.setInt(7, ((Triangle) f).getP3().getY());
					statementT.setString(8, ((Triangle) f).getName());
					int rowsUpdatedT = statementT.executeUpdate();
					if(rowsUpdatedT > 0){
						System.out.println("Un triangle existant a été mis à jour avec succès !");
					}
					conn.close();
				}
				if(f instanceof Rectangle){
					conn = this.getConnection();
					String updater = "UPDATE rectangle SET   idGroupe = ?, px = ?, py = ?, longueur =?, largeur=?  WHERE nom=?" ;
						statementR = conn.prepareStatement(updater);
						statementR.setInt(1, ((Rectangle) f).getIdGroupe());
						statementR.setInt(2,((Rectangle) f).getP().getX());
						statementR.setInt(3, ((Rectangle) f).getP().getY());
						statementR.setDouble(4, ((Rectangle) f).getLongueur());
						statementR.setDouble(5, ((Rectangle) f).getLargeur());
						statementR.setString(6, ((Rectangle) f).getName());
						int rowsUpdatedR = statementR.executeUpdate();
						if(rowsUpdatedR > 0){
							System.out.println("Un rectangle existant a été mis à jour avec succès !");
						}
						conn.close();
				}
			
			
			conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			try {
				if(statement != null ){
				statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return obj;
	}

	public void delete(GroupeForme obj) {
		PreparedStatement statement = null;
		conn = this.getConnection();
		int rowsDeleted =0 ;
		String delete ="Delete from Groupes where  idGroupe=?";
		try {
			statement = conn.prepareStatement(delete);
			statement.setInt(1, obj.getIdGroupe());
			rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0){
				System.out.println("Un membre du groupe a été supprimé avec succès!");
			} else {
				 System.out.println("element n'existe pas");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			try {
				if (statement != null){
				statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}

	
	/**
	   * methode pour savoir si la table existe déja ou non.
	   * @param tableName nom de la table.
	   * @param conn la connexion.
	   * @return  renvoie une valeur booléenne  si l'objet ResultSet contient plus de lignes.
	   * @throws SQLException Exception sql.
	   */

	  boolean doesTableExists(String tableName, Connection conn)
	      throws SQLException {
	    DatabaseMetaData meta = conn.getMetaData();
	    ResultSet result = meta.getTables(null, null, tableName.toUpperCase(), null);

	    return result.next();
	  }
	/**
	   * methode pour Connecter à la base de données.
	   * 
	   */

	  public Connection getConnection() {
	    Connection conn = null;
	    try {
	      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	    try {
	      conn = DriverManager.getConnection("jdbc:derby:6;create=true");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return conn;
	  }	
    
}
