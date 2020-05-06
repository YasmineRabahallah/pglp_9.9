package dessin;

import java.util.ArrayList;

/**
 * class Rectangle.
 * @author rabahallah yasmine.
 *
 */

public class Rectangle extends Forme {
  /**
   * Point2D point  point pour creer un rectangle.
   */
  private Point2D point;

  /**
   * double longueur du rectangle.
   */
  private double longueur; 

  /**
   *  double largeur du rectangle.
   */
  private double largeur;

  /**
   * constructeur Rectangle.
   * @param name du rectangle.
   * @param idGroupe du groupe.
   * @param p point pour creer un rectangle.
   * @param lon longueur du rectangle.
   * @param lar largeur du rectangle.
   */
  public Rectangle(String name,int idGroupe,Point2D p,double lon,double lar) {
    super(name,idGroupe);
    this.point = p;
    this.longueur = lon;
    this.largeur = lar;
  }

  /**
   * methode pour retourner le point.
   * @return p.
   */
  public Point2D getP() {
    return point;
  }

  /**
   * methode qui retoune la longueur du rectangle.
   * @return longueur.
   */
  public double getLongueur() {
    return longueur;
  }

  /**
   * methode qui retourne la largeur du rectangle.
   * @return largeur.
   */
  public double getLargeur() {
    return largeur;
  }

  /**
   * methode pour deplacer le rectangle.
   */
  public void deplacer(int x, int y) {
    this.point.setX(point.getX() + x);
    this.point.setY(point.getY() + y);
  }

  /**
   * methode pour afficher le rectangle.
   */
  public String print() {
    return "name: " + this.getName() + " , IdGroupe: " + this.getIdGroupe()
      + " , point_centre :(" + this.point.getX() + ";" + this.point.getY() + ") , longueur: "
      + this.longueur + " , largeur: " + this.largeur;
  }

}
