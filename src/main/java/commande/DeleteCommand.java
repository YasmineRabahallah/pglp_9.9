package commande;

import dao.GroupeDaoJdbc;
import dessin.GroupeForme;

/**
 * class DeleteCommand.
 * @author rabahallah yasmine.
 *
 */

public class DeleteCommand implements SpecifiqueCommande {

  /**
   * groupe des formes.
   */
  private GroupeForme groupe;
  private GroupeDaoJdbc gjdbc;

  /**
   * constructeur DeleteCommand.
   * @param g groupe.
   */
  public DeleteCommand(GroupeForme g) {
    this.gjdbc = new GroupeDaoJdbc();
    this.groupe = g;
  }

  @Override
  /**
   * methode pour executer la commande delete.
   */
  public void execute() {
    gjdbc.delete(this.groupe);
  }

}
