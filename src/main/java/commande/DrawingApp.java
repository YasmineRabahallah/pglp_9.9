package commande;

import java.util.Scanner;

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
    System.out.println("Vous avis les choix  des commandes suivantes :");
    System.out.println("Dessiner une Forme (Cercle,Carre,Rectangle,Triangle)");
    System.out.println("pour un Cercle de type: **cercle1 = Cercle ((0, 0), 50) **");
    System.out.println("Dessiner un groupe de Forme **g1 = Groupe (groupe1,4)** ");
    System.out.println("Deplacer une forme ou un groupe si ils existent ");
    System.out.println("pour un Cercle de type: **move(cercle1(2,1)) **");
    System.out.println("pour un Groupe de type: **movegroupe(g1(7,3))**");
    System.out.println("pout quiter entree exit ");
    System.out.println("");
    DrawingTui dt = new DrawingTui();
    System.out.println("Entrez une valide commande ou exit pour quitter ");
    Scanner sc = new Scanner(System.in, "UTF-8");
    String saisie = "";
    while (true) {
      if (sc.hasNext()) {
        saisie = sc.next();
        if (saisie.equals("exit")) {
          Runtime.getRuntime().exit(0);
        } else {
          dt.nextCommande(saisie);
          System.out.println("vos dessins actuels :");
          System.out.println(dt.afficheAllFormes());
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
