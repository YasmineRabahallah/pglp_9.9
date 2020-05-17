package commande;

import java.util.Scanner;

public enum DrawingApp {
	ENVIRONNEMENT;
public void execute(String[] args){
	System.out.println("");
    System.out.println("-------------------------------------------------");
    System.out.println("               Drawing App");
    System.out.println("-------------------------------------------------");
    System.out.println("");
    DrawingTui dt = new DrawingTui();
    System.out.println("Ecrire la Descreption de votre dessin pour créer "
			        + "déplacer une forme géométrique ou pour sortir: ");
	Scanner scan = new Scanner(System.in, "UTF-8");
	String dessin ="";
	while (true) {
	  if (scan.hasNext()) {
	    dessin = scan.next();
	    dt.nextCommande(dessin);
	    System.out.println("vos dessins actuels :");
	    System.out.println(dt.afficheAllFormes());	
	  }
	}
   
    	}
     
    

public static void main( String[] args ) {
	ENVIRONNEMENT.execute(args);
	
}
}
