package dao;

import dessin.Carre;
import dessin.Point2D;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * class CarreDaoJdbc.
 * @author rabahallah yasmine.
 *
 */

public class CarreDaoJdbc implements Dao<Carre> {
  /**
   * attribut connection.
   */
  private Connection conn = null;

  /**
   * requete sql pour crrér la table carre.
   */
  private String sql = "CREATE TABLE  carre (nom varchar(20) NOT NULL PRIMARY KEY , "
      + "idGroupe integer references Groupes(idGroupe)  ON DELETE SET NULL,"
      + "px integer not null , "
      + "py integer not null ,"
      + "cote double not null ) ";
  private Statement statement;

  /**
   * constructeur CarreDaoJdbc. 
   */
  public CarreDaoJdbc() {
    conn = this.getConnection();
    try {
      statement = conn.createStatement();
      if (!doesTableExists("carre",conn)) {
        statement.execute(sql);
      }
      statement.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * mathode create pour insérer des tuples dans la table carre.
   */
  public Carre create(Carre obj) {
    PreparedStatement statement = null;
    conn = this.getConnection();
    int rowsInserted = 0;
    String insert = "INSERT INTO carre (nom, idGroupe, px, py , cote) VALUES (?, ?, ?, ?,?)";
    try {
      statement = conn.prepareStatement(insert);
      statement.setString(1, obj.getName());
      statement.setInt(2, obj.getIdGroupe());
      statement.setInt(3, obj.getP().getX());
      statement.setInt(4, obj.getP().getY());
      statement.setDouble(5, obj.getCote());
      rowsInserted = statement.executeUpdate();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      if (statement != null) {
        statement.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    if (rowsInserted > 0) {
      System.out.println("Un nouveau carre a été inséré avec succès!");
      return obj;
    } else {
      return null;
    }
  }

  /**
   * methode retreive pour chercher des tuples dans la table carre.
   */
  public Carre retrieve(String s) {
    Carre c = null;
    PreparedStatement statement = null;
    conn = this.getConnection();
    String select = "SELECT * FROM carre where nom = (?)";
    try {
      statement = conn.prepareStatement(select);
      statement.setString(1,s);
      statement.execute();
      ResultSet result = statement.getResultSet();
      if (result.next()) {
        String nom = result.getString("nom");
        int idGroupe = result.getInt("idGroupe");
        int px = result.getInt("px");
        int py = result.getInt("py");
        double cote = result.getDouble("cote");
        c = new Carre(nom,idGroupe,new Point2D(px,py),cote);
      }
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if (statement != null) {
        statement.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return c;
  }

  /**
   * methode update pour modifier des tuples dans la table carre.
   */
  public Carre update(Carre obj) {
    int rowsUpdated = 0;
    PreparedStatement statement = null;
    conn = this.getConnection();
    String update = "UPDATE carre SET   idGroupe = ?, px = ?, py = ?, cote =? WHERE nom=?";
    try {
      statement = conn.prepareStatement(update);
      statement.setInt(1, obj.getIdGroupe());
      statement.setInt(2, obj.getP().getX());
      statement.setInt(3, obj.getP().getY());
      statement.setDouble(4, obj.getCote());
      statement.setString(5, obj.getName());
      rowsUpdated = statement.executeUpdate();
      if (rowsUpdated > 0) {
        System.out.println("Un carre existant a été mis à jour avec succès !");
      }
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if (statement != null) {
        statement.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return obj;
  }

  /**
   * methode delete pour supprimer des tuples dans la tables carre.
   */
  public void delete(Carre obj) {
    PreparedStatement statement = null;
    conn = this.getConnection();
    int rowsDeleted = 0;
    String delete = "delete from carre where nom=?";
    try {
      statement = conn.prepareStatement(delete);
      statement.setString(1, obj.getName());
      rowsDeleted = statement.executeUpdate();
      if (rowsDeleted > 0) {
        System.out.println("Un membre du carre a été supprimé avec succès!");
      } else {
        System.out.println("element n'existe pas");
      }
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if (statement != null) {
        statement.close();
      }
    } catch (SQLException e) {
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
