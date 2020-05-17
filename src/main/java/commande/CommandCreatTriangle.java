package commande;

import dessin.Point2D;

import dessin.Triangle;

/**
 * class CommandCreatTriangle.
 * @author rabahallah yasmine.
 *
 */
public class CommandCreatTriangle implements CommandCreateForme<Triangle> {

  /**
   * non du triangle.
   */
  private String name;

  /**
   * id du groupe.
   */
  private int idGroupe;

  /**
   * le premier  point  reference.
   */
  private Point2D p1;

  /**
   * le deuxième point reference.
   */
  private Point2D p2;

  /**
   * le  troisième ponit du reference.
   */
  private Point2D p3;

  /**
   * constructeur CommandCreatTriangle.
   * @param name nom du triangle.
   * @param idGroupe id gu groupe.
   * @param p1 ponit reference1.
   * @param p2 ponit reference2.
   * @param p3 point reference3.
   */
  public CommandCreatTriangle(String name,int idGroupe,Point2D p1,Point2D p2,Point2D p3) {
    this.name = name;
    this.idGroupe = idGroupe;
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }

  @Override
  /**
   * methode pour executer la commande de creation d'un triangle.
   */
  public Triangle execute() {
    return new Triangle(name,idGroupe,p1,p2,p3);
  }

}
