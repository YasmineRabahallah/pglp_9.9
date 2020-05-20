package commande;

import dessin.Triangle;

/**
 * class CommandMoveTriangle.
 * @author rabahallah yasmine.
 *
 */

public class CommandMoveTriangle implements SpecifiqueCommande {

  /**
   * un triangle.
   */
  private Triangle tr;

  /**
   * deplacemnt sur l'axe x.
   */
  private int depX;

  /**
   * deplacement sur l'axe y.
   */
  private int depY;

  /**
   * constructeur CommandMoveTriangle.
   * @param t triangle.
   * @param x deplacement x.
   * @param y deplacment y.
   */
  public CommandMoveTriangle(Triangle t,int x,int y) {
    this.tr = t;
    this.depX = x;
    this.depY = y;
  }

  /**
   * methode pour executer la commade de deplacement d un triangle.
   */
  @Override
  public void execute() {
    this.tr.deplacer(depX, depY);
  }
}
