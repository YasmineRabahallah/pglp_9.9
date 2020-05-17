package commande;

import dessin.GroupeForme;
/**
  * class CommadCreateGroup utiliser une commande pour creér un groupe.
  * @author rabahallah yasmine.
  *
  */

public class CommadCreateGroup implements CommandCreateForme<GroupeForme> {

  /**
   * nom du groupe.
   */
  private String name;

  /**
   * id du groupe.
   */
  private int idGroupe;

  /**
   * constructeur CommadCreateGroup.
   * @param name nom du groupe.
   * @param idG id du groupe.
   */
  public CommadCreateGroup(String name,int idG) {
    this.idGroupe = idG;
    this.name = name;
  }

  /**
   * methode execute pour executer la commande de creation du groupe.
   */
  public GroupeForme execute() {
    return new GroupeForme(name,idGroupe);
  }

}
