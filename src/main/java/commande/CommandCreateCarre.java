package commande;

import dessin.Carre;
import dessin.Point2D;
/**
 * class CommandCreateCarre une commande pour creation d'un carre.
 * @author rabahallah yasmine.
 *
 */

public class CommandCreateCarre implements CommandCreateForme<Carre> {
  /**
   * nom du carre.
   */
  private String nom;

  /**
   * id du groupe.
   */
  private int idGroupe;

  /**
   * pointP  reference.
   */
  private Point2D pointP;

  /**
   * cote du carre.
   */
  private double cote;

  /**
   * constructeur CommandCreateCarre.
   * @param nom nom du carre.
   * @param idGroupe id du groupe.
   * @param p point  reference.
   * @param cote d'un carre.
   */
  public CommandCreateCarre(String nom, int idGroupe,Point2D p,double cote) {
    this.nom = nom;
    this.idGroupe = idGroupe;
    this.pointP = p;
    this.cote = cote;
  }

  @Override
  /**
   * methode pour executer la commande du reation du carre.
   */
  public Carre execute() {
    return new Carre(nom,idGroupe,pointP,cote);
  }
 
}
