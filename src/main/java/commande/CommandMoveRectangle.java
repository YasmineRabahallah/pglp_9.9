package commande;

import dessin.Rectangle;

public class CommandMoveRectangle implements SpecifiqueCommande {

  /**
   * une reclange .
   */
  private Rectangle rec;

  /**
   * deplacement sur l'axe x.
   */
  private int depX;

  /**
   * deplacement sur l'axe y.
   */
  private int depY;

  /**
   * constructeur CommandMoveRectangle. 
   * @param rec un rectangle
   * @param x deplacemnt x.
   * @param y deplacement y.
   */
  public CommandMoveRectangle(Rectangle rec,int x,int y) {
    this.rec = rec;
    this.depX = x;
    this.depY = y;
  }

  @Override
  /**
   * methode pour executer la commande de deplacement du rectangle.
   */
  public void execute() {
    this.rec.deplacer(depX, depY);
  }
}
