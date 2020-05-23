package commande;

import dessin.GroupeForme;

/**
 * class AffichageGroupeCommand.
 * @author rabahallah yasmine.
 *
 */

public class AffichageGroupeCommand implements AffichageCommand {

  /**
   * Groupe de formes.
   */
  private GroupeForme groupe;

  /**
   * constructeur AffichageGroupeCommand.
   * @param g groupe pour l'afficher.
   */
  public AffichageGroupeCommand(GroupeForme g) {
    this.groupe = g;
  }

  @Override
  /**
   * methode pour executer la commande affichage groupe.
   */
  public String execute() {
    return groupe.print();
  }

}
