package dessin;

import java.util.ArrayList;

/**
 * class Cercle.
 * @author rabahallah yasmine.
 *
 */
public class Cercle extends Forme {

  /**
   * point2D centre du cercle.
   */
  private Point2D centre;

  /**
   * double rayon du cercle.
   */
  private double rayon;

  /**
   * construteur Cercle.
   * @param name de la Cercle.
   * @param idGroupe du groupe.
   * @param centre du cercle.
   * @param rayon du cercle.
   */
  public Cercle(String name,int idGroupe,Point2D centre,double rayon) {
    super(name,idGroupe);
    this.centre = centre;
    this.rayon = rayon;
  }

  /**
   * methode pour retouner le centre du cercle.
   * @return centre.
   */
  public Point2D getCentre() {
    return centre;
  }

  /**
   * methode pour retourner le rayon.
   * @return le rayon.
   */
  public double getRayon() {
    return rayon;
  }

  /**
   * methode pour deplacer le cercle.
   */
  public void deplacer(int x, int y) {
    this.centre.setX(centre.getX() + x);
    this.centre.setY(centre.getY() + y);
  }

  /**
   * methode pour affichage.
   */
  public String print() {
    return "Cercle(name: " + this.getName() + " , point_centre("
      + this.centre.getX() + ";" + this.centre.getY() + "), rayon= "
      + this.getRayon() + ")";
  }

}
