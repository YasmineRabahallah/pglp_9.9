package Dessin;

import java.util.ArrayList;
/**
 * class Rectangle.
 * @author rabahallah yasmine.
 *
 */
public class Rectangle extends Forme{
	/**
	 * Point2D p point pour creer un rectangle.
	 */
    private Point2D p;
    /**
     * double longueur du rectangle.
     */
    private double longueur; 
    /**
     *  double largeur du rectangle.
     */
    private double largeur ;
    /**
     * constructeur Rectangle.
     * @param name du rectangle.
     * @param IdGroupe du groupe.
     * @param p point pour creer un rectangle.
     * @param lon longueur du rectangle.
     * @param lar largeur du rectangle.
     */
	public Rectangle(String name, int IdGroupe , Point2D p , double lon , double lar) {
		super(name, IdGroupe);
		this.p = p;
		this.longueur = lon;
		this.largeur = lar ;
	}
    /**
     * methode pour retourner le point.
     * @return p.
     */
	public Point2D getP() {
		return p;
	}
    /**
     * methode qui retoune la longueur du rectangle.
     * @return longueur.
     */
	public double getLongueur() {
		return longueur;
	}
    /**
     * methode qui retourne la largeur du rectangle.
     * @return
     */
	public double getLargeur() {
		return largeur;
	}

	/**
	 * methode pour deplacer le rectangle.
	 */
	public void deplacer(int x, int y) {
		this.p.setX(p.getX() + x);
		this.p.setY(p.getY()  +y);
	}

	/**
	 * methode pour afficher le rectangle.
	 */
	public String print() {
		
		 return "name: " + this.getName()+"IdGroupe: "+this.getIdGroupe()+"point_centre :("+this.p.getX()+";"+this.p.getY()+"longueur: "+this.longueur+"largeur: "+this.largeur+")";
	}

	

}
