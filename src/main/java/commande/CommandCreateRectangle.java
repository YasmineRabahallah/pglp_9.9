package commande;

import dessin.Point2D;
import dessin.Rectangle;

public class CommandCreateRectangle implements CommandCreate<Rectangle> {
	private String name;
	private int idGroupe;
	private Point2D p;
	private double lon;
	private double lar;
	public CommandCreateRectangle(String name,int idGroupe,Point2D p,double lon,double lar){
		this.name = name;
		this.idGroupe = idGroupe;
		this.p = p;
		this.lon = lon;
		this.lar = lar;
	}
	@Override
	public Rectangle execute() {
		return new Rectangle(name,idGroupe,p,lon,lar);
		
	}
	
}
