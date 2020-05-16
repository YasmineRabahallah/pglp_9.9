package dao;

import dessin.Point2D;
import dessin.Rectangle;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * class RectangleDaoJdbc.
 * @author rabahallah yasmine.
 *
 */

public class RectangleDaoJdbc  implements Dao<Rectangle> {
  /**
   * attribut connection.
   */
  private Connection conn;
  private Statement statement;
  /**
   * requete sql pour créer la table rectangle.
   */
  private String sql = "CREATE TABLE  rectangle (nom varchar(20) NOT NULL PRIMARY KEY , "
        + "idGroupe integer references Groupes(idGroupe)  ON DELETE SET NULL,"
        + "px integer not null , "
        + "py integer not null ,"
        + "longueur double not null,"
        + "largeur double not null ) ";

  /**
   * constructeur RectangleDaoJdbc.
   */
  public RectangleDaoJdbc() {
    conn = this.getConnection();
    try {
      statement = conn.createStatement();
      if (!doesTableExists("rectangle",conn)) {
        statement.execute(sql);
      }
      conn.close();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * methode pour insérer des tuples dans la table rectangle.
   */
  public Rectangle create(Rectangle obj) {
    PreparedStatement statement = null;
    conn = this.getConnection();
    int rowsInserted = 0;
    String insert = "INSERT INTO rectangle (nom, idGroupe, px, py ,longueur , largeur)"
        + " VALUES (?, ?, ?, ?,?,?)";
    try {
      statement = conn.prepareStatement(insert);
      statement.setString(1, obj.getName());
      statement.setInt(2, obj.getIdGroupe());
      statement.setInt(3,obj.getP().getX());
      statement.setInt(4, obj.getP().getY());
      statement.setDouble(5,obj.getLongueur());
      statement.setDouble(6, obj.getLargeur());
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
      System.out.println("Un nouveau rectangle a été inséré avec succès!");
      return obj;
    } else {
      return null;
    }
  }

  /**
   * methode pour chercher des tuples du la table rectangle.
   */
  public Rectangle retrieve(String s) {
    PreparedStatement statement = null;
    Rectangle r = null;
    conn = this.getConnection();
    String select = "SELECT * FROM rectangle where nom = (?)";
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
        double lon = result.getDouble("longueur");
        double lar = result.getDouble("largeur");
        r = new Rectangle(nom,idGroupe,new Point2D(px,py),lon,lar);
        conn.close();
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
    return r;
  }

  /**
   * methode pour modifier des tuples du la table rectangle.
   */
  public Rectangle update(Rectangle obj) {
    PreparedStatement statement = null;
    int rowsUpdated = 0;
    conn = this.getConnection();
    String update = "UPDATE rectangle SET   idGroupe = ?, px = ?, py = ?,"
        + " longueur =?, largeur=?  WHERE nom=?";
    try {
      statement = conn.prepareStatement(update);
      statement.setInt(1, obj.getIdGroupe());
      statement.setInt(2, obj.getP().getX());
      statement.setInt(3, obj.getP().getY());
      statement.setDouble(4, obj.getLongueur());
      statement.setDouble(5, obj.getLargeur());
      statement.setString(6, obj.getName());
      rowsUpdated = statement.executeUpdate();
      if (rowsUpdated > 0) {
        System.out.println("Un rectangle existant a été mis à jour avec succès !");
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
   * methode pour supprimer des tupes du la table rectangle.
   */
  public void delete(Rectangle obj) {
    PreparedStatement statement = null;
    int rowsDeleted = 0;
    conn = this.getConnection();
    String delete = "delete from rectangle where nom=?";
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
