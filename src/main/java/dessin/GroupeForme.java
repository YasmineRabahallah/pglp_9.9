package dessin;

import java.util.ArrayList;

/**
 * class GroupeForme.
 * @author rabahallah yasmine.
 *
 */

public class GroupeForme extends Forme {
  /**
   * formes liste des formes du groupe.
   */
  private ArrayList<Forme> formes;

  /**
   * constructeur du GroupeForme.
   * @param name nom du groupe.
   * @param idGroupe id du groupe.
   */
  public GroupeForme(String name,int idGroupe) {
    super(name,idGroupe);
    this.formes = new ArrayList<Forme>();
  }

  /**
   * methode pour ajouter une forme dans un groupe.
   * @param f forme.
   */
  public void add(Forme f) {
    this.formes.add(f);
  }

  /**
   * methode pour supprimer une forme dans un groupe.
   * @param f une forme.
   */
  public void remove(Forme f) {
    if (formes.contains(f)) {
      this.formes.remove(f);
    } else {
      System.out.println("l'element n'existe pas ");
    }
  }

  /**
   * methode pour retourner la liste des formes d'un groupe.
   * @return formes.
   */
  public ArrayList<Forme> getFormes() {
    return this.formes;
  }

  /**
   * methode pour declacer les formes du groupe.
   */
  public void deplacer(int x, int y) {
    for (Forme f :formes) {
      f.deplacer(x, y);
    }
  }

  /**
   * methode pour afficher les formes du groupe.
   */
  public String print() {
    StringBuffer sb = new StringBuffer();
    for (Forme f :formes) {
      sb.append(" ");
      sb.append(f.print());
    }
    return "nom du groupe :" + this.name + "id du groupe:"
        + this.idGroupe + " les elements du groupe sont : " + sb;
  }

}
