package commande;


import dessin.Point2D;
import dessin.Triangle;

public class CommandCreatTriangle implements CommandCreate<Triangle> {
	private String name;
	private int idGroupe;
	private Point2D p1;
	private Point2D p2;
	private Point2D p3;
	public CommandCreatTriangle(String name,int idGroupe,Point2D p1,Point2D p2,Point2D p3){
		this.name = name;
		this.idGroupe = idGroupe;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	@Override
	public Triangle execute() {
		return new Triangle(name,idGroupe,p1,p2,p3);
		
	}

}
