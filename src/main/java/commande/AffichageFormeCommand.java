package commande;

import dessin.Carre;
import dessin.Cercle;
import dessin.Forme;
import dessin.Rectangle;
import dessin.Triangle;

/**
 * class AffichageFormeCommand.
 * @author Hamila
 *
 */

public class AffichageFormeCommand implements AffichageCommand {

  /**
   * une forme pour l'affichage.
   */
  private Forme forme;

  /**
   * methode afffichage d'une forme.
   * @param forme .
   */
  public AffichageFormeCommand(Forme forme) {
    this.forme = forme;
  }

  @Override
  /**
   * methode execute pour executer la commande d'affichage.
   */
  public String execute() {
    if (this.forme instanceof  Carre) {
      return ((Carre)forme).print();
    } 
    if (this.forme instanceof  Cercle) {
      return ((Cercle)forme).print();
    }
    if (this.forme instanceof  Triangle) {
      return ((Triangle)forme).print();
    }
    if (this.forme instanceof  Rectangle) {
      return ((Triangle)forme).print();
    }
    return null;
  }

}
