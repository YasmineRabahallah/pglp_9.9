package commande;

import dessin.Cercle;

/**
 * class CommandMoveCercle.
 * @author rabahallah yasmine.
 *
 */

public class CommandMoveCercle implements CommandMove {
  /**
   * un cercle.
   */
  private Cercle cercle;

  /**
   * deplacemnt sur l'axe x.
   */
  private int depX;

  /**
   * deplacement sur l'axe y.
   */
  private int depY;

  /**
   * constructeur CommandMoveCercle.
   * @param c cercle.
   * @param x deplacement sur l'axe x.
   * @param y deplacement sur l'axe y.
   */
  public CommandMoveCercle(Cercle c,int x,int y) {
    this.cercle = c;
    this.depX = x;
    this.depY = y;
  }

  @Override
  /**
   * methode pour executer la commande du deplacement pour un cercle.
   */
  public void execute() {
    this.cercle.deplacer(depX, depY);
  }
}
