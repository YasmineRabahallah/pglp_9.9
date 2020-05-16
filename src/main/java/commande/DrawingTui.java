package commande;

import dessin.Carre;
import dessin.Cercle;
import dessin.Forme;
import dessin.GroupeForme;
import dessin.Point2D;
import dessin.Rectangle;
import dessin.Triangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DrawingTui {
  private Map<String,Icommande> commandes;
  private List<Forme> listeFormes ;
  private List<GroupeForme> listeGroupes ;
  public DrawingTui(){
    listeFormes = new ArrayList<Forme>();
    listeGroupes = new ArrayList<GroupeForme>();
  }
  public Icommande getDepFormeCmd (String[] chaine){
	    Icommande cmd = null; 
		if (chaine.length == 4)  {
			  Forme forme = getForme(listeFormes,chaine[1]);
			  int depX = Integer.parseInt(chaine[2]);
			  int depY = Integer.parseInt(chaine[3]);
			  cmd = new CommandMoveForme(forme,depX,depY);
			   return cmd;
		} else {
			System.out.println("commande non valide");
			 return null ;
		} 
  }
  public Icommande getDepGroupeCmd (String[] chaine){
	  	Icommande cmd = null;
	  if (chaine.length == 4)  {
		  GroupeForme groupe = getGroupe(listeGroupes,chaine[1]);
		  int depX = Integer.parseInt(chaine[2]);
		  int depY = Integer.parseInt(chaine[3]);
		  cmd = new CommandMoveGroup(groupe,depX,depY);
		   return cmd;
	} else {
		System.out.println("commande non valide");
		 return null ;
	}
	}
  public Icommande getCreationCmd(String[] chaine){
	  Icommande cmd = null;
	  Forme forme = null;
	  switch(chaine[1].toLowerCase()){
	  case"carre":
		  if(chaine.length == 6){
			 String nom = chaine[0] ;
			 int idGroupe = Integer.parseInt(chaine[2]);
			 int px = Integer.parseInt(chaine[3]);
			 int py = Integer.parseInt(chaine[4]);
			 Double cote = Double.parseDouble(chaine[5]);
			 forme = new Carre(nom,idGroupe,new Point2D(px,py),cote);
			 cmd = new CommandCreateCarre(nom,idGroupe,new Point2D(px,py),cote);
			 this.listeFormes.add(forme);
		  } else {
				System.out.println("commande non valide");
				 return null ;
			} 
		break;
	  case"groupe":
		  if(chaine.length == 3){
			 String nom = chaine[0] ;
			 int idGroupe = Integer.parseInt(chaine[2]);
			 GroupeForme g = new GroupeForme(nom,idGroupe);
			 cmd = new CommadCreateGroup(nom,idGroupe);
			 this.listeGroupes.add(g);
	      }
		  else {
				System.out.println("commande non valide");
				 return null ;
			}
	   break;
	  case"cercle":
		  if(chaine.length == 6){
			 String nom = chaine[0] ;
			 int idGroupe = Integer.parseInt(chaine[2]);
			 int px = Integer.parseInt(chaine[3]);
			 int py = Integer.parseInt(chaine[4]);
			 Double rayon = Double.parseDouble(chaine[5]);
			 forme = new Cercle(nom,idGroupe,new Point2D(px,py),rayon);
			 cmd = new CommandCreateCercle(nom,idGroupe,new Point2D(px,py),rayon);
			 this.listeFormes.add(forme);
		  } else {
				System.out.println("commande non valide");
				 return null ;
			}
		  break;
	  case"rectangle":
		  if(chaine.length == 7){
			 String nom = chaine[0] ;
			 int idGroupe = Integer.parseInt(chaine[2]);
			 int px = Integer.parseInt(chaine[3]);
			 int py = Integer.parseInt(chaine[4]);
			 Double lon = Double.parseDouble(chaine[5]);
			 Double lar = Double.parseDouble(chaine[6]);
			 forme = new Rectangle(nom,idGroupe,new Point2D(px,py),lon,lar);
			 cmd = new CommandCreateRectangle(nom,idGroupe,new Point2D(px,py),lon,lar);
			 this.listeFormes.add(forme);
		  } else {
				System.out.println("commande non valide");
				 return null ;
			}
		  break;
	  case"triangle":
		  if(chaine.length == 9){
			 String nom = chaine[0] ;
			 int idGroupe = Integer.parseInt(chaine[2]);
			 int p1x = Integer.parseInt(chaine[3]);
			 int p1y = Integer.parseInt(chaine[4]);
			 int p2x = Integer.parseInt(chaine[5]);
			 int p2y = Integer.parseInt(chaine[6]);
			 int p3x = Integer.parseInt(chaine[7]);
			 int p3y = Integer.parseInt(chaine[8]);
			 forme = new Triangle(nom,idGroupe,new Point2D(p1x,p1y),new Point2D(p2x,p2y),new Point2D(p3x,p3y));
			 cmd = new CommandCreatTriangle(nom,idGroupe,new Point2D(p1x,p1y),new Point2D(p2x,p2y),new Point2D(p3x,p3y));
			 this.listeFormes.add(forme);
		  } else {
				System.out.println("commande non valide");
				 return null ;
			}
		  break;
	     case "exit":
    	  cmd = new CommandExit();
          break;
	  
	   default:
		   return null;
	  }
	 return cmd;
	  
  }
  public Icommande nextCommande(String Text){
	  Icommande commande = null;
	  String TextTraite =Text.replaceAll("[()=,;]"," ");
	  String[] chaine = TextTraite.split("\\s+");
	  switch(chaine[0].toLowerCase()){
	  case"move":
		   commande =  getDepFormeCmd(chaine);
	  break;
	  case"movegroupe":
		  commande =  getDepGroupeCmd(chaine);
	  break;
	  default:
		  commande = getCreationCmd(chaine);
	   }
	return commande;
  }
  public Forme getForme(List<Forme> l,String nomForme){
	  for(Forme f :l){
		  if (f.getName()==nomForme){
			  return f;
		  }
	  }
	return null;
	 }
  public GroupeForme getGroupe(List<GroupeForme> l,String nomGroupe){
	  for(GroupeForme g :l){
		  if (g.getName()==nomGroupe){
			  return g;
		  }
	  }
	return null;
	 }

}
