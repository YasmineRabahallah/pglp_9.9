package dao;

import dessin.Point2D;
import dessin.Triangle;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * class TriangleDaoJdbc.
 * @author rabahalah yasmine.
 *
 */

public class TriangleDaoJdbc  implements Dao<Triangle> {
  private Connection conn;
  private Statement statement;
  private String sql = "CREATE TABLE  triangle (nom varchar(20) NOT NULL PRIMARY KEY , "
      + "idGroupe integer references Groupes(idGroupe)  ON DELETE SET NULL,"
      + "p1x integer not null , "
      + "p1y integer not null ,"
      + "p2x integer not null , "
      + "p2y integer not null ,"
      + "p3x integer not null , "
      + "p3y integer not null )";

  /**
   * constructeur TriangleDaoJdbc().
   */
  public TriangleDaoJdbc() {
    conn = this.getConnection();
    try {
      statement = conn.createStatement();
      if (!doesTableExists("triangle",conn)) {
        statement.execute(sql);
      }
      conn.close();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * methode pour insérer des tuples dans la table triangle.
   */
  public Triangle create(Triangle obj) {
    PreparedStatement statement = null;
    conn = this.getConnection();
    int rowsInserted = 0;
    String insert = "INSERT INTO triangle (nom, idGroupe, p1x, p1y ,"
        + "p2x,p2y,p3x,p3y) VALUES (?, ?, ?, ?,?,?,?,?)";
    try {
      statement = conn.prepareStatement(insert);
      statement.setString(1, obj.getName());
      statement.setInt(2, obj.getIdGroupe());
      statement.setInt(3, obj.getP1().getX());
      statement.setInt(4, obj.getP1().getY());
      statement.setInt(5, obj.getP2().getX());
      statement.setInt(6, obj.getP2().getY());
      statement.setInt(7, obj.getP3().getX());
      statement.setInt(8, obj.getP3().getY());
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
      System.out.println("Un nouveau triangle a été inséré avec succès!");
      return obj;
    } else {
      return null;
    }
  }

  /**
   * methode pour chercher des tuples dans la table triangle.
   */
  public Triangle retrieve(String s) {
    PreparedStatement statement = null;
    conn = this.getConnection(); 
    Triangle t = null;
    String select = "SELECT * FROM triangle where nom = (?)";
    try {
      statement = conn.prepareStatement(select);
      statement.setString(1, s);
      statement.execute();
      ResultSet result = statement.getResultSet();
      if (result.next()) {
        String nom = result.getString("nom");
        int idGroupe = result.getInt("idGroupe");
        int p1x = result.getInt("p1x");
        int p1y = result.getInt("p1y");
        int p2x = result.getInt("p2x");
        int p2y = result.getInt("p2y");
        int p3x = result.getInt("p3x");
        int p3y = result.getInt("p3y");
        t = new Triangle(nom,idGroupe,new Point2D(p1x,p1y),
            new Point2D(p2x,p2y),new Point2D(p3x,p3y));
      }
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
    return t;
  }

  /**
   * methode pour modifier des tuples dans la table triangle.
   */
  public Triangle update(Triangle obj) {
    PreparedStatement statement = null;
    int rowsUpdated = 0;
    conn = this.getConnection();
    String update = "UPDATE triangle SET   idGroupe = ?, p1x = ?, p1y = ?,"
        + " p2x = ?, p2y = ?, p3x = ?, p3y = ?  WHERE nom=?";
    try {
      statement = conn.prepareStatement(update);
      statement.setInt(1, obj.getIdGroupe());
      statement.setInt(2, obj.getP1().getX());
      statement.setInt(3, obj.getP1().getY());
      statement.setInt(4, obj.getP2().getX());
      statement.setInt(5, obj.getP2().getY());
      statement.setInt(6, obj.getP3().getX());
      statement.setInt(7, obj.getP3().getY());
      statement.setString(8, obj.getName());
      rowsUpdated = statement.executeUpdate();
      if (rowsUpdated > 0) {
        System.out.println("Un triangle existant a été mis à jour avec succès !");
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
   * methode pour supprimer des tuples dans la table triangle.
   */
  public void delete(Triangle obj) {
    PreparedStatement statement = null;
    conn = this.getConnection();
    int rowsDeleted = 0;
    String delete = "delete from triangle where nom=?";
    try {
      statement = conn.prepareStatement(delete);
      statement.setString(1, obj.getName());
      rowsDeleted = statement.executeUpdate();
      if (rowsDeleted > 0) {
        System.out.println("Un membre du rectangle a été supprimé avec succès!");
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
