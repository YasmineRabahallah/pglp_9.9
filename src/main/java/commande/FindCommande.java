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
   * nom du groupe chercher.
   */
  private String nomGroupe;
  private GroupeDaoJdbc jdbc;

  /**
   * constructeur FindCommande.
   * @param nom du groupe.
   */
  public FindCommande(String nom) {
    this.jdbc = new GroupeDaoJdbc();
    this.nomGroupe = nom;
  }

  @Override

  /**
   * methode pour execter commande de recherche.
   */
  public GroupeForme execute() {
    return jdbc.retrieve(nomGroupe);
  }

}
