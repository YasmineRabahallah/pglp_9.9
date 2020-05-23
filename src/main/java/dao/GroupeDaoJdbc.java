package dao;

import dessin.Carre;
import dessin.Cercle;
import dessin.Forme;
import dessin.GroupeForme;
import dessin.Point2D;
import dessin.Rectangle;
import dessin.Triangle;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * class GroupeDaoJdbc.
 * @author rabahallah yasmine.
 *
 */

public class GroupeDaoJdbc implements Dao<GroupeForme> {
  private Connection conn = null;

  /**
   * requete sql pour creér la table Groupes.
   */
  String sql = "CREATE TABLE Groupes (idGroupe Integer  PRIMARY KEY NOT NULL ,"
      + " nomGroupe varchar(40) NOT NULL) ";
  private Statement statement;

  /**
   * constructeur GroupeDaoJdbc.
   */
  public GroupeDaoJdbc() {
    conn = this.getConnection();
    try {
      statement = conn.createStatement();
      if (!doesTableExists("Groupes",conn)) {
        statement.execute(sql);
      }
      statement.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * method pour creér des tuples dans la table Groupes.
   */
  public GroupeForme create(GroupeForme obj) {
    PreparedStatement statement = null;
    int rowsInserted = 0;
    conn = this.getConnection();
    String insert = "INSERT INTO Groupes (idGroupe,nomGroupe) VALUES (?,?)";
    try {
      statement = conn.prepareStatement(insert);
      statement.setInt(1, obj.getIdGroupe());
      statement.setString(2, obj.getName());
      rowsInserted = statement.executeUpdate();
      CarreDaoJdbc cj = new CarreDaoJdbc();
      CercleDaoJdbc crj = new CercleDaoJdbc();
      RectangleDaoJdbc rj = new RectangleDaoJdbc();
      TriangleDaoJdbc tj = new TriangleDaoJdbc();
      ArrayList<Forme> l = obj.getFormes();
      for (Forme f :l) {
        if (f instanceof GroupeForme) {
          this.create((GroupeForme)f);
        }
        if (f instanceof Carre) {
          cj.create((Carre) f);
        }
        if (f instanceof Cercle) {
          crj.create((Cercle) f);
        }
        if (f instanceof Rectangle) {
          rj.create((Rectangle) f);
        }
        if (f instanceof Triangle) {
          tj.create((Triangle)f);
        }
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
    if (rowsInserted > 0) {
      System.out.println("Un nouveau groupe a été inséré avec succès!");
      return obj;
    } else {
      return null;
    }
  }

  /**
   * methode pour chercher des tuples dans la table Groupes.
   */
  public GroupeForme retrieve(String id) {
    GroupeForme g = null;
    int idG =  Integer.parseInt(id);
    PreparedStatement statement = null;
    PreparedStatement statementF = null;
    Carre c = null;
    Cercle cl = null;
    Triangle t = null;
    Rectangle r = null;
    try {
      conn = this.getConnection();
      String selectform = "select * from Groupes where idGroupe = (?)";
      statement = conn.prepareStatement(selectform);
      statement.setInt(1, idG);
      statement.execute();
      ResultSet resultG = statement.getResultSet();
      if (resultG.next()) {
        int idGroupe = resultG.getInt("idGroupe");
        String nomGroupe = resultG.getString("nomGroupe");
        g = new GroupeForme(nomGroupe,idGroupe);
        selectform = "select * from carre where idGroupe = (?)";
        statementF = conn.prepareStatement(selectform);
        statementF.setInt(1, idG);
        statementF.execute();
        ResultSet resultCr = statementF.getResultSet();
        while (resultCr.next()) {
          String nom = resultCr.getString("nom");
          int idGroupeC = resultCr.getInt("idGroupe");
          int px = resultCr.getInt("px");
          int py = resultCr.getInt("py");
          double cote = resultCr.getDouble("cote");
          c = new Carre(nom,idGroupeC,new Point2D(px,py),cote);
          g.add(c);
        }
        selectform = "select * from cercle where idGroupe = (?)";
        statementF = conn.prepareStatement(selectform);
        statementF.setInt(1, idG);
        statementF.execute();
        ResultSet resultCl = statementF.getResultSet();
        while (resultCl.next()) {
          String nom = resultCl.getString("nom");
          int idGroupeCl = resultCl.getInt("idGroupe");
          int px = resultCl.getInt("px");
          int py = resultCl.getInt("py");
          double rayon = resultCl.getDouble("rayon");
          cl = new Cercle(nom,idGroupeCl,new Point2D(px,py),rayon);
          g.add(cl);
        }
        selectform = "select * from triangle where idGroupe = (?)";
        statementF = conn.prepareStatement(selectform);
        statementF.setInt(1, idG);
        statementF.execute();
        ResultSet resultT = statementF.getResultSet();
        while (resultT.next()) {
          String nom = resultT.getString("nom");
          int idGroupeT = resultT.getInt("idGroupe");
          int p1x = resultT.getInt("p1x");
          int p1y = resultT.getInt("p1y");
          int p2x = resultT.getInt("p2x");
          int p2y = resultT.getInt("p2y");
          int p3x = resultT.getInt("p3x");
          int p3y = resultT.getInt("p3y");
          t = new Triangle(nom,idGroupeT,new Point2D(p1x,p1y),
              new Point2D(p2x,p2y),new Point2D(p3x,p3y));
          g.add(t);
        }
        selectform = "select * from rectangle where idGroupe = (?)";
        statementF = conn.prepareStatement(selectform);
        statementF.setInt(1, idG);
        statementF.execute();
        ResultSet resultR = statementF.getResultSet();
        while (resultR.next()) {
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
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    try {
      if (statement != null) {
        statement.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if (statementF != null) {
        statementF.close();
      }
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return g;
  }

  /**
   * methode pour modifier des tuples dans la table groupes 
   * modifier les formes du groupe si il y a un changement.
   */
  public GroupeForme update(GroupeForme obj) {
    PreparedStatement statementF = null;
    PreparedStatement statement = null;
    int rowsUpdated = 0;
    conn = this.getConnection();
    String update = "UPDATE Groupes SET nomGroupe=(?) where  idGroupe= (?)";
    try {
      statement = conn.prepareStatement(update);
      statement.setString(1, obj.getName());
      statement.setInt(2, obj.getIdGroupe());
      rowsUpdated = statement.executeUpdate();
      if (rowsUpdated > 0) {
        System.out.println("Un groupe existant a été mis à jour avec succès !");
      }
      ArrayList<Forme> listFormes = obj.getFormes();
      for (Forme f :listFormes) {
        if (f instanceof Carre) {
          conn = this.getConnection();
          String updateCr = "UPDATE carre SET   idGroupe = ?, "
              + "px = ?, py = ?, cote =? WHERE nom=?";
          statementF = conn.prepareStatement(updateCr);
          statementF.setInt(1, ((Carre) f).getIdGroupe());
          statementF.setInt(2, ((Carre) f).getP().getX());
          statementF.setInt(3, ((Carre) f).getP().getY());
          statementF.setDouble(4,((Carre) f).getCote());
          statementF.setString(5, ((Carre) f).getName());
          int rowsUpdatedCr = statementF.executeUpdate();
          if (rowsUpdatedCr > 0) {
            System.out.println("Un carre existant a été mis à jour avec succès !");
          }
          conn.close();
        }
        if (f instanceof Cercle) {
          conn = this.getConnection();
          String updatecercle = "UPDATE cercle SET   idGroupe = ?,"
              + " px = ?, py = ?, rayon =? WHERE nom=?";
          statementF = conn.prepareStatement(updatecercle);
          statementF.setInt(1, ((Cercle) f).getIdGroupe());
          statementF.setInt(2, ((Cercle) f).getCentre().getX());
          statementF.setInt(3, ((Cercle) f).getCentre().getY());
          statementF.setDouble(4, ((Cercle) f).getRayon());
          statementF.setString(5, ((Cercle) f).getName());
          int rowsUpdatedCl = statementF.executeUpdate();
          if (rowsUpdatedCl > 0) {
            System.out.println("Un cercle existant a été mis à jour avec succès !");
          }
          conn.close();
        }
        if (f instanceof Triangle) {
          conn = this.getConnection();
          String updatet = "UPDATE triangle SET   idGroupe = ?, p1x = ?,"
              + " p1y = ?, p2x = ?, p2y = ?, p3x = ?, p3y = ?  WHERE nom=?";
          statementF = conn.prepareStatement(updatet);
          statementF.setInt(1, ((Triangle) f).getIdGroupe());
          statementF.setInt(2, ((Triangle) f).getP1().getX());
          statementF.setInt(3, ((Triangle) f).getP1().getY());
          statementF.setInt(4, ((Triangle) f).getP2().getX());
          statementF.setInt(5, ((Triangle) f).getP2().getY());
          statementF.setInt(6, ((Triangle) f).getP3().getX());
          statementF.setInt(7, ((Triangle) f).getP3().getY());
          statementF.setString(8, ((Triangle) f).getName());
          int rowsUpdatedT = statementF.executeUpdate();
          if (rowsUpdatedT > 0) {
            System.out.println("Un triangle existant a été mis à jour avec succès !");
          }
          conn.close();
        }
        if (f instanceof Rectangle) {
          conn = this.getConnection();
          String updater = "UPDATE rectangle SET   idGroupe = ?, px = ?, py = ?,"
              + " longueur =?, largeur=?  WHERE nom=?";
          statementF = conn.prepareStatement(updater);
          statementF.setInt(1, ((Rectangle) f).getIdGroupe());
          statementF.setInt(2,((Rectangle) f).getP().getX());
          statementF.setInt(3, ((Rectangle) f).getP().getY());
          statementF.setDouble(4, ((Rectangle) f).getLongueur());
          statementF.setDouble(5, ((Rectangle) f).getLargeur());
          statementF.setString(6, ((Rectangle) f).getName());
          int rowsUpdatedR = statementF.executeUpdate();
          if (rowsUpdatedR > 0) {
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
      if (statement != null) {
        statement.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if (statementF != null) {
        statementF.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return obj;
  }

  /**
   * methode pour supprimer un groupe dans la table Groupes.
   */
  public void delete(GroupeForme obj) {
    PreparedStatement statement = null;
    conn = this.getConnection();
    int rowsDeleted = 0;
    String delete = "Delete from Groupes where  idGroupe=?";
    try {
      statement = conn.prepareStatement(delete);
      statement.setInt(1, obj.getIdGroupe());
      rowsDeleted = statement.executeUpdate();
      if (rowsDeleted > 0) {
        System.out.println("Un membre du groupe a été supprimé avec succès!");
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
