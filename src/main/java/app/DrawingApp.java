package app;

import java.util.Scanner;

import commande.DrawingTui;

/**
 * enum DrawingApp.
 * @author rabahallah yasmine.
 *
 */
public enum DrawingApp {
  ENVIRONNEMENT;

  /**
   * methode executer pour traiter les commandes d'utilisateur.
   * @param args l'entrée d'utilisateur.
   */
  public void execute(String[] args) {
    System.out.println("");
    System.out.println("-------------------------------------------------");
    System.out.println("               Drawing App");
    System.out.println("-------------------------------------------------");
    System.out.println("Les formes que vous pouvez créer :Cercle,Carre,Rectangle,Triangle");
    System.out.println("et un groupe qui contient des formes pour construire un dessin");
    System.out.println("-------------------------------------------------");
    System.out.println("pour créer un carre la commande sera : carre1=carre(1,(1,2),7)");
    System.out.println("celà va créer un carre avec un id groupe : 1 et"
        + " point reference (1,2) et un cote :7 ");
    System.out.println("pour déplacer un carre la commande sera : move(carre1,7,-3)");
    System.out.println("pour afficher un cercle la commande sera : afficher carre1");
    System.out.println("-------------------------------------------------");
    System.out.println("pour déplacer un groupe la commande sera : movegroupe(groupe7,8,2)");
    System.out.println("pour afficher un cercle la commande sera : affichergroupe groupe7");
    System.out.println("-------------------------------------------------");
    System.out.println("pour enregistrer un dessin la commande sera : save(groupe7)");
    System.out.println("pour charger un dessin la commande sera laod(7)");
    System.out.println("pour supprimer un dessin la commande sera : delete(groupe7");
    
    System.out.println("");
    DrawingTui dt = new DrawingTui();
    System.out.println("Entrez une valide commande ou exit pour quitter ");
    Scanner sc = new Scanner(System.in, "UTF-8");
    String saisie = "";
    while (true) {
      if (sc.hasNext()) {
        saisie = sc.next();
        if (!saisie.equals("exit")) {
          dt.nextCommande(saisie);
          System.out.println("vos dessins actuels :");
          System.out.println(dt.afficheAllFormes());
        }
        if (saisie.equals("exit")) {
          Runtime.getRuntime().exit(0);
        }
      }
    }
  }

  /**
   * methode main pour executer le programme.
   * @param args entrée pour l'utilisateur.
   */
  public static void main(String[] args) {
    ENVIRONNEMENT.execute(args);
  }
}
