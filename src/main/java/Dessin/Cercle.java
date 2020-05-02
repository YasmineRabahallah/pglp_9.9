package Dessin;

import java.util.ArrayList;

public class Cercle extends Forme {
    
    /**
     * point2D centre du cercle.
     */
	private Point2D centre ;
	/**
	 * double rayon du cercle.
	 */
    private double rayon ;
    /**
     * construteur Cercle.
     * @param name de la Cercle.
     * @param IdGroupe du groupe.
     * @param centre du cercle.
     * @param rayon du cercle.
     */
    public Cercle(String name, int IdGroupe, Point2D centre , double rayon) {
		super(name, IdGroupe);
		this.centre = centre;
		this.rayon = rayon ;
	}
    /**
     * methode pour retouner le centre du cercle.
     * @return centre.
     */
    public Point2D getCentre() {
		return centre;
	} 
    /**
     * methode pour retourner le rayon.
     * @return le rayon.
     */
	public double getRayon() {
		return rayon;
	}
	/**
	 * methode pour deplacer le cercle.
	 */
	public void deplacer(int x, int y) {
		this.centre.setX(centre.getX()+x);
		this.centre.setY(centre.getY()+y);
	}
    /**
     * methode pour affichage.
     */
	public String print() {
		return "name: " + this.getName()+" , IdGroupe: "+this.getIdGroupe()+" , rayon: "+this.getRayon()+" , point_centre :("+this.centre.getX()+";"+this.centre.getY()+")";
	}
	

}
