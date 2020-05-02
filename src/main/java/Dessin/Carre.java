package Dessin;

import java.util.ArrayList;
/**
 * class Carre.
 * @author rabahallah yasmine.
 *
 */
public class Carre  extends Forme{
	/**
	 * Point2D p point pour creer un carré.
	 */
    private Point2D p ;
    /**
     * double cote  mesure du cote d'un carré.
     */
    private double cote ;
    /**
     * constructeur 	Carre.
     * @param name de la Carre.
     * @param IdGroupe du groupe.
     * @param p point pour creer un carré.
     * @param cote mesure du cote d'un carré.
     */
	public Carre(String name, int IdGroupe , Point2D p , double cote) {
		super(name, IdGroupe);
		this.p = p;
		this.cote = cote;
		
	}
    /**
     * methode qui retourne le point p.
     * @return point p.
     */
	public Point2D getP() {
		return p;
	}
    /**
     * methode qui retourne  le cote.
     * @return
     */
	public double getCote() {
		return cote;
	}

	/**
	 * methode pour deplacer le carré.
	 */
	public void deplacer(int x, int y) {
		this.p.setX(p.getX() + x);
		this.p.setY(p.getY() + y);
		
	}

	/**
	 * methode pour affichage.
	 */
	public String print() {
		return "name: " + this.getName()+"IdGroupe: "+this.getIdGroupe()+"point_centre :("+this.p.getX()+";"+this.p.getY()+"coté: "+this.cote+")";
	}

	

}
