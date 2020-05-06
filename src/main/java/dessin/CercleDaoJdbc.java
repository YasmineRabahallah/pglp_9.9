package dessin;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CercleDaoJdbc implements Dao<Cercle>{
	/**
	 *  un attribut  connexion.
	 */
	private Connection conn = null;
	 /**
	   * la requte da creation de la table cercle.
	   */
	private String sql ="CREATE TABLE  cercle (nom varchar(20) NOT NULL PRIMARY KEY , "
			+ "idGroupe integer references Groupes(idGroupe) ON DELETE CASCADE,"
			+ "px integer not null , "
			+ "py integer not null ,"
			+ "rayon double not null ) ";
	private Statement statement ;
	public CercleDaoJdbc(){
		conn = this.getConnection();
		try {
			statement = conn.createStatement();
			if(!doesTableExists("cercle",conn)){
				statement.execute(sql);
			}
		statement.close();
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Cercle create(Cercle obj) {
		PreparedStatement statement = null;
		int rowsInserted = 0;
		conn = this.getConnection();
		String insert = "INSERT INTO cercle (nom, idGroupe, px, py , rayon) VALUES (?, ?, ?, ?,?)";
		try {
			statement = conn.prepareStatement(insert);
			statement.setString(1, obj.getName());
			statement.setInt(2, obj.getIdGroupe());
			statement.setInt(3, obj.getCentre().getX());
			statement.setInt(4, obj.getCentre().getY());
			statement.setDouble(5, obj.getRayon());
			rowsInserted = statement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			try {
				if (statement != null){
				statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(rowsInserted  > 0 ){
			System.out.println("Un nouveau cercle a été inséré avec succès!");
			return obj;
		} else {
			return null ;
		}
		
	}

	public Cercle retrieve(String s) {
		Cercle c = null ;
		PreparedStatement statement = null;
		conn = this.getConnection();
		String select ="SELECT * FROM cercle where nom = (?)";
		try {
			statement = conn.prepareStatement(select);
			statement.setString(1,s);
			statement.execute();
			ResultSet result = statement.getResultSet();
			if(result.next()){
				String nom = result.getString("nom");
				int idGroupe = result.getInt("idGroupe");
				int px = result.getInt("px");
				int py = result.getInt("py");
				double rayon = result.getDouble("rayon");
				c = new Cercle (nom,idGroupe,new Point2D(px,py),rayon);
			}
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			try {
				if(statement != null){
				statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
		return c;
	}

	public Cercle update(Cercle obj) {
		PreparedStatement statement = null ;
		int rowsUpdated = 0;
		conn = this.getConnection();
		String update ="UPDATE cercle SET   idGroupe = ?, px = ?, py = ?, rayon =? WHERE nom=?";
		try {
			statement = conn.prepareStatement(update);
			statement.setInt(1, obj.getIdGroupe());
			statement.setInt(2, obj.getCentre().getX());
			statement.setInt(3, obj.getCentre().getY());
			statement.setDouble(4, obj.getRayon());
			statement.setString(5, obj.getName());
			rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0){
				 System.out.println("Un cercle existant a été mis à jour avec succès !");
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
				e.printStackTrace();
			}
		
		return obj;
	}

	public void delete(Cercle obj) {
		PreparedStatement statement = null ;
		conn = this.getConnection();
		int rowsDeleted = 0;
		String delete = "delete from cercle where nom=?";	
		try {
			statement = conn.prepareStatement(delete);
			statement.setString(1, obj.getName());
			rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0){
				System.out.println("Un membre du cercle a été supprimé avec succès!");
			} else {
				 System.out.println("element n'existe pas");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			try {
				if(statement != null){
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
