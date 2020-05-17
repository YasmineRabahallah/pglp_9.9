package commande;

import dessin.Carre;

/**
 * class CommandMoveCarre.
 * @author rabahallah yasmine.
 *
 */
public class CommandMoveCarre implements CommandMove {

  /**
   * un carre.
   */
  private Carre carre;

  /**
   * int depX pour deplacement sur l'axe x.
   */
  private int depX;

  /**
   * int depY pour deplacement sur l'axe y.
   */
  private int depY;

  /**
   * constructeur CommandMoveCarre.
   * @param c carre.
   * @param x deplacement sur l'axe x.
   * @param y deplacement sur l'axe y.
   */
  public CommandMoveCarre(Carre c,int x,int y) {
    this.carre = c;
    this.depX = x;
    this.depY = y;
  }

  /**
   * methode pour executer la commande pour deplacement du carre.
   */
  public void execute() {
    this.carre.deplacer(depX, depY);
  }

}
