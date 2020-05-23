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

/**
 * class DrawingTui.
 * @author rabahallah yasmine.
 *
 */
public class DrawingTui {

  /**
   * liste des formes créér par l'utilisateur.
   */
  private List<Forme> listeFormes;

  /**
   * listes des groupes créer par l'utilisateur.
   */
  private List<GroupeForme> listeGroupes;

  /**
   * constructeur DrawingTui. 
   */
  public DrawingTui() {
    listeFormes = new ArrayList<Forme>();
    listeGroupes = new ArrayList<GroupeForme>();
  }

  /**
   * methode pour retouner commande de deplacement d'une forme.
   * @param chaine entréé par l'utilisateur.
   * @return cmd commande poue l'executer.
   */
  public Icommande getDepFormeCmd(String[] chaine) {
    Icommande cmd = null; 
    try {
      if (chaine.length == 4)  {
        Forme forme = getForme(listeFormes,chaine[1]);
        if (forme == null) {
          System.out.println("la forme n'existe pas");
        } else {
          int depX = Integer.parseInt(chaine[2]);
          int depY = Integer.parseInt(chaine[3]);
          if (forme instanceof Carre) {
            cmd = new CommandMoveCarre(((Carre)forme),depX,depY);
          }
          if (forme instanceof Cercle) {
            cmd = new CommandMoveCercle(((Cercle)forme),depX,depY);
          }
          if (forme instanceof Rectangle) {
            cmd = new CommandMoveRectangle(((Rectangle)forme),depX,depY);
          }
          if (forme instanceof Triangle) {
            cmd = new CommandMoveTriangle(((Triangle)forme),depX,depY);
          }
          ((SpecifiqueCommande)cmd).execute();
        }
        return cmd;
      } else {
        System.out.println("commande non valide");
        return null;
      }
    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
      System.out.println("votre description de dessin est erronée.");
      return null;
    }
  }

  /**
   * methode pour retourner la commande de deplacement d'un groupe.
   * @param chaine entrée par l'utilisateur pour la traiter.
   * @return cmd de deplacement a executer.
   */
  public Icommande getDepGroupeCmd(String[] chaine) {
    Icommande cmd = null;
    if (chaine.length == 4)  {
      GroupeForme groupe = getGroupe(listeGroupes,chaine[1]);
      if (groupe == null) {
        System.out.println("la forme n'existe pas"); 
      } else {
        int depX = Integer.parseInt(chaine[2]);
        int depY = Integer.parseInt(chaine[3]);
        cmd = new CommandMoveGroup(groupe,depX,depY);
        ((SpecifiqueCommande)cmd).execute();
      }
      return cmd;
    } else {
      System.out.println("commande non valide");
      return null;
    }
  }
  
  /**
   * methode pour retourner la commande pour charger le dessin.
   * @param idGroupe du groupe.
   * @return cmdF la commande de chargement .
   */
  public Icommande getLoadGroup(String idGroupe) {
    FindCommande  cmdF = new FindCommande(idGroupe);
    GroupeForme gs = cmdF.execute();
    for (Forme f : gs.getFormes()) {
      listeFormes.add(f);
    }
    return cmdF;
  }

  /**
   * methode pour retourner la commande de creation d'un forme.
   * @param chaine entrée par l'utilisateur.
   * @return cmd commande de creation a executer.
   */
  public Icommande getTraitementCmd(String[] chaine) {
    Icommande cmd = null;
    Forme forme = null;
    try {
      switch (chaine[1].toLowerCase()) {
        case"carre":
          if (chaine.length == 6) {
            String nom = chaine[0];
            int idGroupe = Integer.parseInt(chaine[2]);
            int px = Integer.parseInt(chaine[3]);
            int py = Integer.parseInt(chaine[4]);
            Double cote = Double.parseDouble(chaine[5]);
            cmd = new CommandCreateCarre(nom,idGroupe,new Point2D(px,py),cote);
            forme = ((CommandCreateForme<Carre>)cmd).execute();
            this.listeFormes.add((Carre) forme);
            createGroupe(idGroupe,(Carre) forme);
          } else {
            System.out.println("commande non valide");
            return null;
          } 
          break;
        case"groupe":
          if (chaine.length == 3) {
            String nom = chaine[0];
            int idGroupe = Integer.parseInt(chaine[2]);
            cmd = new CommadCreateGroup(nom,idGroupe);
            forme = ((CommandCreateForme<GroupeForme>)cmd).execute();
            this.listeGroupes.add((GroupeForme) forme);
          } else {
            System.out.println("commande non valide");
            return null;
          }
          break;
        case"cercle":
          if (chaine.length == 6) {
            String nom = chaine[0];
            int idGroupe = Integer.parseInt(chaine[2]);
            int px = Integer.parseInt(chaine[3]);
            int py = Integer.parseInt(chaine[4]);
            Double rayon = Double.parseDouble(chaine[5]);
            cmd = new CommandCreateCercle(nom,idGroupe,new Point2D(px,py),rayon);
            forme = ((CommandCreateForme<Cercle>)cmd).execute();
            this.listeFormes.add((Cercle) forme);
            createGroupe(idGroupe,(Cercle) forme);
          } else {
            System.out.println("commande non valide");
            return null;
          }
          break;
        case"rectangle":
          if (chaine.length == 7) {
            String nom = chaine[0];
            int idGroupe = Integer.parseInt(chaine[2]);
            int px = Integer.parseInt(chaine[3]);
            int py = Integer.parseInt(chaine[4]);
            Double lon = Double.parseDouble(chaine[5]);
            Double lar = Double.parseDouble(chaine[6]);
            cmd = new CommandCreateRectangle(nom,idGroupe,new Point2D(px,py),lon,lar);
            forme = ((CommandCreateForme<Rectangle>)cmd).execute();
            this.listeFormes.add((Rectangle) forme);
            createGroupe(idGroupe,(Rectangle) forme);
          } else {
            System.out.println("commande non valide");
            return null;
          }
          break;
        case"triangle":
          if (chaine.length == 9) {
            String nom = chaine[0];
            int idGroupe = Integer.parseInt(chaine[2]);
            int p1x = Integer.parseInt(chaine[3]);
            int p1y = Integer.parseInt(chaine[4]);
            int p2x = Integer.parseInt(chaine[5]);
            int p2y = Integer.parseInt(chaine[6]);
            int p3x = Integer.parseInt(chaine[7]);
            int p3y = Integer.parseInt(chaine[8]);
            cmd = new CommandCreatTriangle(nom,idGroupe,new Point2D(p1x,p1y),
                new Point2D(p2x,p2y),new Point2D(p3x,p3y));
            forme = ((CommandCreateForme<Triangle>)cmd).execute();
            this.listeFormes.add((Triangle) forme);
            createGroupe(idGroupe,(Triangle) forme);
          } else {
            System.out.println("commande non valide");
            return null;
          }
          break;
        case "exit":
          cmd = new CommandExit();
          ((SpecifiqueCommande)cmd).execute();
          break;
        default:
          System.out.println("commande non valide");
          return null;
      }
    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
      return null;
    }
    return cmd;  
  }

  /**
   * methode nextCommande pour traiter la commande du l'utilisateur.
   * @param text chiane entrée.
   * @return commande a executer.
   */
  public Icommande nextCommande(String text) {
    Icommande commande = null;
    String textTraite = text.replaceAll("[()=,;]"," ");
    String[] chaine = textTraite.split("\\s+");
    Forme forme = null;
    try {
      switch (chaine[0].toLowerCase()) {
        case "afficher":
          forme = getForme(listeFormes,chaine[1]);
          commande = new AffichageFormeCommand(forme);
          System.out.println(((AffichageCommand)commande).execute());
          break;
        case "affichergroupe":
          GroupeForme groupe = getGroupe(listeGroupes,chaine[1]);
          commande = new AffichageGroupeCommand(groupe);
          System.out.println(((AffichageCommand)commande).execute());
          break;
        case "save":
          GroupeForme groupeSave = getGroupe(listeGroupes,chaine[1]);
          commande = new SaveCommand(groupeSave);
          ((SpecifiqueCommande )commande).execute();
          System.out.println("votre dessin a éte sauvgardé");
          break;
        case "load" :
          commande = getLoadGroup(chaine[1]);
          System.out.println("votre dessin a éte chargé");
          break;
        case "delete" :
          GroupeForme groupedelete = getGroupe(listeGroupes,chaine[1]);
          commande = new DeleteCommand(groupedelete);
          ((SpecifiqueCommande )commande).execute();
          System.out.println("votre dessin a éte supprimé");
          break;
        case"move":
          commande =  getDepFormeCmd(chaine);
          break;
        case"movegroupe":
          commande =  getDepGroupeCmd(chaine);
          break;
        default:
          commande = getTraitementCmd(chaine);
      }
    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
      return null;
    }
    return commande;
  }

  /**
   * methode pour retrouver une forme dans une liste.
   * @param l la liste.
   * @param nomForme nom de la forme.
   * @return la forme avec le nom chercher.
   */
  public Forme getForme(List<Forme> l,String nomForme) {
    for (Forme f :l) {
      if (f.getName().equals(nomForme)) {
        return f;
      }
    }
    return null;
  }

  /**
   * methode pour retrouver un groupe dans une liste.
   * @param l la liste des groupes.
   * @param nomGroupe nom du groupe.
   * @return le groupe rechercher.
   */
  public GroupeForme getGroupe(List<GroupeForme> l,String nomGroupe) {
    for (GroupeForme g :l) {
      if (g.getName().equals(nomGroupe)) {
        return g;
      }
    }
    return null;
  }

  /**
   * methode pour creation un groupe s'existe pas et ajouter la forme a ce groupe.
   * si le groupe existe on ajoute seulement la forme a ce groupe.
   * @param idG id du groupe.
   * @param f forme a ajouter dans le groupe
   */
  public void createGroupe(int idG,Forme f) {
    Boolean existeG = false;
    for (GroupeForme g:listeGroupes) {
      if (g.getIdGroupe() == idG) {
        g.add(f);
        existeG = true;
      }
    }
    if (existeG.equals(false)) {
      GroupeForme gr = new GroupeForme("groupe" + idG,idG);
      listeGroupes.add(gr);
      gr.add(f);
    }
  }

  /**
   * methode pour retourner la liste des groupes créer.
   * @return listeGroupes.
   */
  public List<GroupeForme> getlistGroupes() {
    return listeGroupes;  
  }

  /**
   * methodes pour retourner la liste des formes créer.
   * @return listeFormes.
   */
  public List<Forme> getlistFormes() {
    return listeFormes;  
  }

  /**
   * methode pour affichage d'une forme.
   * @param f une forme.
   * @return affichage d'une forme.
   */
  public String afficheDessin(Forme f) {
    if (f instanceof Carre) {
      return ((Carre)f).print();
    }
    if (f instanceof Cercle) {
      return ((Cercle)f).print();
    }
    if (f instanceof Rectangle) {
      return ((Rectangle)f).print();
    }
    if (f instanceof Triangle) {
      return ((Triangle)f).print();
    }
    if (f instanceof GroupeForme) {
      return ((GroupeForme)f).print();
    }
    return null;
  }

  /**
   * methode pour retourner tous les formes créer.
   * @return sb.
   */
  public String afficheAllFormes() {
    StringBuffer sb = new StringBuffer();
    for (Forme forme : this.getlistGroupes()) {
      sb.append(this.afficheDessin(forme));
      sb.append("\n");
    }
    return sb  + "";
  }

}
