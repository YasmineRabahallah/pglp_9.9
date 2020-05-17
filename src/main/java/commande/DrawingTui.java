package commande;

import dessin.Carre;
import dessin.Cercle;
import dessin.Forme;
import dessin.GroupeForme;
import dessin.Point2D;
import dessin.Rectangle;
import dessin.Triangle;
import java.util.ArrayList;
import java.util.List;



public class DrawingTui {
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
			  if(forme==null){
				  System.out.println("la forme n'existe pas");
			  } else {
			  int depX = Integer.parseInt(chaine[2]);
			  int depY = Integer.parseInt(chaine[3]);
			  if(forme instanceof Carre) {
			      cmd = new CommandMoveCarre(((Carre)forme),depX,depY);
			    }
			    if(forme instanceof Cercle) {
			    	 cmd = new CommandMoveCercle(((Cercle)forme),depX,depY);
			      }
			    if(forme instanceof Rectangle) {
			    	 cmd = new CommandMoveRectangle(((Rectangle)forme),depX,depY);
			    }
			    if(forme instanceof Triangle) {
			    	 cmd = new CommandMoveTriangle(((Triangle)forme),depX,depY);
			    }
			    ((CommandMove)cmd).execute();
			  }
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
		  if(groupe == null){
			  System.out.println("la forme n'existe pas"); 
		  } else {
		  int depX = Integer.parseInt(chaine[2]);
		  int depY = Integer.parseInt(chaine[3]);
		  cmd = new CommandMoveGroup(groupe,depX,depY);
		  ((CommandMove)cmd).execute();
		  }
		   return cmd;
	} else {
		System.out.println("commande non valide");
		 return null ;
	}
	}
  public Icommande getCreationCmd(String[] chaine){
	  Icommande cmd = null;
	  Forme forme = null;
	  try{
	  switch(chaine[1].toLowerCase()){
	  case"carre":
		  if(chaine.length == 6){
			 String nom = chaine[0] ;
			 int idGroupe = Integer.parseInt(chaine[2]);
			 int px = Integer.parseInt(chaine[3]);
			 int py = Integer.parseInt(chaine[4]);
			 Double cote = Double.parseDouble(chaine[5]);
			 cmd = new CommandCreateCarre(nom,idGroupe,new Point2D(px,py),cote);
			 forme = ((CommandCreate<Carre>)cmd).execute();
			 this.listeFormes.add((Carre) forme);
			 createGroupe(idGroupe,(Carre) forme);
		  } else {
				System.out.println("commande non valide");
				 return null ;
			} 
		break;
	  case"groupe":
		  if(chaine.length == 3){
			 String nom = chaine[0] ;
			 int idGroupe = Integer.parseInt(chaine[2]);
			 cmd = new CommadCreateGroup(nom,idGroupe);
			 forme = ((CommandCreate<GroupeForme>)cmd).execute();
			 this.listeGroupes.add((GroupeForme) forme);
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
			 cmd = new CommandCreateCercle(nom,idGroupe,new Point2D(px,py),rayon);
			 forme = ((CommandCreate<Cercle>)cmd).execute();
			 this.listeFormes.add((Cercle) forme);
			 createGroupe(idGroupe,(Cercle) forme);
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
			 cmd = new CommandCreateRectangle(nom,idGroupe,new Point2D(px,py),lon,lar);
			 forme = ((CommandCreate<Rectangle>)cmd).execute();
			 this.listeFormes.add((Rectangle) forme);
			 createGroupe(idGroupe,(Rectangle) forme);
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
			 cmd = new CommandCreatTriangle(nom,idGroupe,new Point2D(p1x,p1y),new Point2D(p2x,p2y),new Point2D(p3x,p3y));
			 forme = ((CommandCreate<Triangle>)cmd).execute();
			 this.listeFormes.add((Triangle) forme);
			 createGroupe(idGroupe,(Triangle) forme);
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
	  }catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
	      return null;
	    }
	 return cmd;
	  
  }
  public Icommande nextCommande(String Text){
	  Icommande commande = null;
	  String TextTraite =Text.replaceAll("[()=,;]"," ");
	  String[] chaine = TextTraite.split("\\s+");
	  try{
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
	  }catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
	      return null;
	    }
	return commande;
  }
  public Forme getForme(List<Forme> l,String nomForme){
	  for(Forme f :l){
		  if (f.getName().equals(nomForme)){
			  return f;
		  }
	  }
	return null;
	 }
  public GroupeForme getGroupe(List<GroupeForme> l,String nomGroupe){
	  for(GroupeForme g :l){
		  if (g.getName().equals(nomGroupe)){
			  return g;
		  }
	  }
	return null;
	 }
  public void createGroupe(int idG , Forme f) {
	    Boolean existeG = false;
	    for(GroupeForme g:listeGroupes){
	    	if(g.getIdGroupe()== idG){
	    		g.add(f);
	    		existeG = true;
	    	}
	    }
	    if(existeG.equals(false)) {
	      GroupeForme gr = new GroupeForme("groupe"+idG,idG);
	      listeGroupes.add(gr);
	      gr.add(f);
	    }
	  }
  public List<GroupeForme> getlistGroupes(){
	return listeGroupes;
	  
  }
  public List<Forme> getlistFormes(){
	return listeFormes;
	  
  }
  public String afficheDessin(Forme f) {
	    if(f instanceof Carre) {
	      return ((Carre)f).print();
	    }

	    if(f instanceof Cercle) {
	      return ((Cercle)f).print();
	    }

	    if(f instanceof Rectangle) {
	      return ((Rectangle)f).print();
	    }

	    if(f instanceof Triangle) {
	      return ((Triangle)f).print();
	    }

	    if(f instanceof GroupeForme) {
	      return ((GroupeForme)f).print();
	    }
	    return null;	
	  }
  public String afficheAllFormes() {
		StringBuffer affiche = new StringBuffer();
	    for(Forme forme : this.getlistGroupes()) {
	      affiche.append(this.afficheDessin(forme));
	      affiche.append("\n");
	    }
	    return affiche+"";
	  }

}
