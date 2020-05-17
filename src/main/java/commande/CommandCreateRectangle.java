package commande;

import dessin.Point2D;
import dessin.Rectangle;

/**
 * class CommandCreateRectangle.
 * @author rabahallah yasmine.
 *
 */
public class CommandCreateRectangle implements CommandCreateForme<Rectangle> {

  /**
   * nom d'un rectangle.
   */
  private String name;

  /**
   * id du groupe.
   */
  private int idGroupe;

  /**
   * point reference.
   */
  private Point2D pointP;

  /**
   * la longueur du rectangle.
   */
  private double lon;

  /**
   * la largeur du rectangle.
   */
  private double lar;

  /**
   * costructeur CommandCreateRectangle.
   * @param name nom du rectangle.
   * @param idGroupe id du groupe.
   * @param p point  reference.
   * @param lon la longueur du rectangle.
   * @param lar la largeur du rectangle.
   */
  public CommandCreateRectangle(String name,int idGroupe,Point2D p,double lon,double lar) {
    this.name = name;
    this.idGroupe = idGroupe;
    this.pointP = p;
    this.lon = lon;
    this.lar = lar;
  }

  @Override
  /**
   * methode pour executer la commande de creation d'un rectangle.
   */
  public Rectangle execute() {
    return new Rectangle(name,idGroupe,pointP,lon,lar);
  }

}
