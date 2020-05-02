package Dessin;

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
		return IdGroupe;
	}
/**
   * String name nom de la forme.
   */
  protected String name ;
  /**
   * int IdGroupe groupe de la forme.
   */
  protected int IdGroupe;
  /**
   * methode deplacer.
   * @param x position sur l'axe X pour déplacer la forme.
   * @param y position sur l'axe Y pour déplacer la forme.
   */
  public Forme(String name , int IdGroupe){
	  this.name = name;
	  this.IdGroupe = IdGroupe;
  }
  public abstract void deplacer(int x , int y);
  /**
   * methode afficher.
   * @return affichage des parametre de forme.
   */
  public abstract String print();
  
}
