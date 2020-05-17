package commande;

import dessin.Cercle;
import dessin.Point2D;
/**
 * class CommandCreateCercle.
 * @author rabahallah yasmine.
 *
 */

public class CommandCreateCercle implements CommandCreateForme<Cercle> {
  /**
   * nom d un cercle.
   */
  private String name;

  /**
   * id du groupe.
   */
  private int idGroupe;

  /**
   * point centre d'un cercle.
   */
  private Point2D centre;

  /**
   * le rayon d'un cercle.
   */
  private double rayon;

  /**
   * constructeur CommandCreateCercle.
   * @param name nom du cercle.
   * @param idGroupe id du groupe.
   * @param centre centre.
   * @param rayon d un cercle.
   */
  public CommandCreateCercle(String name,int idGroupe,Point2D centre,double rayon) {
    this.name = name;
    this.idGroupe = idGroupe;
    this.centre = centre;
    this.rayon = rayon;
  }

  @Override
  /**
   * methode pour executer la commande du creation d'un cercle.
   */
  public Cercle execute() {
    return new Cercle(name,idGroupe,centre,rayon);
  }

}
