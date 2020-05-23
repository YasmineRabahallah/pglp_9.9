package commande;

import dao.GroupeDaoJdbc;
import dessin.GroupeForme;

/**
 * class FindCommande. 
 * @author rabahallah yasmine.
 *
 */

public class FindCommande implements CommandCreateForme<GroupeForme> {

  /**
   * id du groupe chercher.
   */
  private String idGroupe;
  private GroupeDaoJdbc jdbc;

  /**
   * constructeur FindCommande.
   * @param id du groupe.
   */
  public FindCommande(String id) {
    this.jdbc = new GroupeDaoJdbc();
    this.idGroupe = id;
  }

  @Override

  /**
   * methode pour execter commande de recherche.
   */
  public GroupeForme execute() {
    return jdbc.retrieve(idGroupe);
  }

}
