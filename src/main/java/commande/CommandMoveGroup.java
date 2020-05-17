package commande;

import dessin.GroupeForme;

/**
 * class CommandMoveGroup.
 * @author rabahallah yasmine.
 *
 */

public class CommandMoveGroup implements CommandMove {

  /**
   * un grouep.
   */
  private GroupeForme groupe;

  /**
   * deplacement sur l'axe x.
   */
  private int depX;

  /**
   * deplacement sur l'axe y.
   */
  private int depY;

  /**
   * constructeur CommandMoveGroup.
   * @param g un groupe pour le deplacer.
   * @param x deplacement sur l'axe x.
   * @param y deplacemnt sur l'axe y.
   */
  public CommandMoveGroup(GroupeForme g,int x,int y) {
    this.groupe = g;
    this.depX = x;
    this.depY = y;
  }

  @Override
  /**
   * methode poue executer la commande du deplacement pour un groupe.
   */
  public void execute() {
    this.groupe.deplacer(depX, depY);
  }
}
