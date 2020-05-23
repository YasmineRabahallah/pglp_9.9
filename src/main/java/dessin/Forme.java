package dessin;

import java.util.ArrayList;

/**
 * class abstract Forme.
 * @author rabahallah yasmine.
 *
 */

public abstract class Forme {
  /**
   * retourner le nom.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * retourner id du groupe.
   * @return idGroupe.
   */
  public int getIdGroupe() {
    return idGroupe;
  }

  /**
   * String name nom de la forme.
   */
  public String name;

  /**
   * int IdGroupe groupe de la forme.
   */
  public int idGroupe;

  /**
   * constructeur Forme.
   * @param name nom de la forme.
   * @param idGroupe id du groupe.
   */
  public Forme(String name,int idGroupe) {
    this.name = name;
    this.idGroupe = idGroupe;
  }

  /**
   * methode pour deplacer une forme.
   * @param x position du x.
   * @param y position du y.
   */
  public abstract void deplacer(int x,int y);

  /**
   * methode afficher.
   * @return affichage des parametre de forme.
   */
  public abstract String print();
  
}
