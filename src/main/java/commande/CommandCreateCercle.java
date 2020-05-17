package commande;

import dessin.Cercle;
import dessin.Point2D;

public class CommandCreateCercle implements CommandCreate<Cercle>{
	private String name;
	private int idGroupe;
	private Point2D centre;
	private double rayon;
	public CommandCreateCercle(String name,int idGroupe,Point2D centre,double rayon) {
		this.name = name;
		this.idGroupe = idGroupe;
		this.centre = centre;
		this.rayon = rayon;
	}
	@Override
	public Cercle execute() {
	 return new Cercle(name,idGroupe,centre,rayon);
	}

}
