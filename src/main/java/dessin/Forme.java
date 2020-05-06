package dessin;

import java.util.ArrayList;

/**
 *  classz abstract Forme.
 * @author rabahallah yasmine.
 *
 */

public abstract class Forme {
  public String getName() {
		return name;
	}
	public int getIdGroupe() {
		return idGroupe;
	}
/**
   * String name nom de la forme.
   */
  protected String name ;
  /**
   * int IdGroupe groupe de la forme.
   */
  protected int idGroupe;
 
  public Forme(String name , int IdGroupe){
	  this.name = name;
	  this.idGroupe = IdGroupe;
  }
  /**
   * 
   * @param x x.
   * @param y y.
   */
  public abstract void deplacer(int x , int y);
  /**
   * methode afficher.
   * @return affichage des parametre de forme.
   */
  public abstract String print();
  
}
