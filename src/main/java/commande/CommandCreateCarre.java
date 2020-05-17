package commande;

import dessin.Carre;
import dessin.Point2D;

public class CommandCreateCarre implements CommandCreate<Carre>{
  private String nom;
  private int idGroupe;
  private Point2D p;
  private double cote;
  public CommandCreateCarre(String nom, int idGroupe,Point2D p,double cote){
	  this.nom = nom;
	  this.idGroupe=idGroupe;
	  this.p=p;
	  this.cote=cote;
  }
@Override
public Carre execute() {
  return new Carre(nom,idGroupe,p,cote);
}
  
}
