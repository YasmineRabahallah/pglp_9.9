package dessin;

import java.util.ArrayList;

/**
 * class Carre.
 * @author rabahallah yasmine.
 *
 */

public class Carre  extends Rectangle {
  /**
   * Point2D p point pour creer un carré.
   */
  private Point2D point;

  /**
   * double cote  mesure du cote d'un carré.
   */
  private double cote;

  /**
   * constructeur Carre.
   * @param name de la Carre.
   * @param idGroupe du groupe.
   * @param p point pour creer un carré.
   * @param cote mesure du cote d'un carré.
   */
  public Carre(String name, int idGroupe,Point2D p,double cote) {
    super(name, idGroupe, p, cote, cote);
    this.point = p;
    this.cote = cote;
  }

  /**
   * methode qui retourne le point p.
   * @return point p.
   */
  public Point2D getP() {
    return point;
  }

  /**
   * methode qui retourne  le cote.
   * @return cote.
   */

  public double getCote() {
    return cote;
  }

  /**
   * methode pour deplacer le carré.
   */
  public void deplacer(int x, int y) {
    this.point.setX(point.getX() + x);
    this.point.setY(point.getY() + y);
  }

  /**
   * methode pour affichage.
   */
  public String print() {
    return "name: " + this.getName() + " , IdGroupe: " + this.getIdGroupe() + ""
      + ", point_centre :(" + this.point.getX() + ";"
      + this.point.getY() + ") , coté: " + this.cote;
  }



}
