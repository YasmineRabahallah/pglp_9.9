package dessin;

import java.util.ArrayList;

/**
 * class Triangle.
 * @author rabahallah yasmine.
 *
 */

public class Triangle extends Forme {
  /**
   * le 3 Point2D pour creer un triangle.
   */
  private Point2D p1;
  private Point2D p2;
  private Point2D p3;

  /**
   * constructeur Triangle.
   * @param name nom du triangle.
   * @param idGroupe du groupe.
   * @param p1 le premier  Point2D pour creer un triangle.
   * @param p2 le deuxième  Point2D pour creer un triangle.
   * @param p3 le troisième Point2D pour creer un triangle.
   */
  public Triangle(String name,int idGroupe,Point2D p1,Point2D p2,Point2D p3) {
    super(name,idGroupe);
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }

  /**
   * methode qui retourne le premier  Point2D pour creer un triangle.
   * @return p1.
   */
  public Point2D getP1() {
    return p1;
  }

  /**
   * methode qui retourne le deuxième  Point2D pour creer un triangle.
   * @return p2.
   */
  public Point2D getP2() {
    return p2;
  }

  /**
   * le troisième Point2D pour creer un triangle.
   * @return p3.
   */
  public Point2D getP3() {
    return p3;
  }

  /**
   * methode pour deplacer le triangle.
   */
  public void deplacer(int x, int y) {
    this.p1.setX(p1.getX() + x);
    this.p1.setY(p1.getY() + y);
    this.p2.setX(p2.getX() + x);
    this.p2.setY(p2.getY() + y);
    this.p3.setX(p3.getX() + x);
    this.p3.setY(p3.getY() + y);
  }

  /**
   * methode pour afficher le triangle.
   */
  public String print() {
    return "Triangle (name: " + this.getName()
      + " , point1(" + this.p1.getX() + ";" + this.p1.getY()
      + ") , point2(" + this.p2.getX() + ";" + this.p2.getY()
      + ") , point3(" + this.p3.getX() + ";" + this.p3.getY() + ") )";
  }

  
}
