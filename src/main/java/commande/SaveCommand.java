package commande;

import dao.GroupeDaoJdbc;
import dessin.GroupeForme;

/**
 * class SaveCommand.
 * @author rabahallah yasmine.
 *
 */

public class SaveCommand implements SpecifiqueCommande {
  private GroupeForme groupe;
  private GroupeDaoJdbc jdbc;

  /**
   * constructeur SaveCommand.
   * @param g groupe.
   */
  public SaveCommand(GroupeForme g) {
    this.jdbc = new GroupeDaoJdbc();
    this.groupe = g;
  }

  @Override
  /**
   * methode pour executer la commande save.
   */
  public void execute() {
    jdbc.create(this.groupe);
  }

}
