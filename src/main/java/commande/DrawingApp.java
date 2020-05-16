package commande;

import java.util.Scanner;

public enum DrawingApp {
	ENVIRONNEMENT;
public void execute(String[] args){
	Scanner sc = new Scanner(System.in,"UTF8");
	DrawingTui dw = new DrawingTui();
	System.out.println("");
    System.out.println("-------------------------------------------------");
    System.out.println("               Drawing App");
    System.out.println("-------------------------------------------------");
    System.out.println("");
   
    System.out.println("Entrez votre commande ");
    String saisie = sc.next();;
    while(true){
    	if(saisie.equals("exit")){
    		sc.close();
    	} else {
    Icommande commande = dw.nextCommande(saisie);
     if(commande != null){
    	 commande.execute();
    	 
    	 
     } else {
    	 System.out.println("commande non valide entrez une valide commande!!!!");
    	 saisie = sc.next();
    	 
     }
    	}
     
    }
}
public static void main( String[] args ) {
	ENVIRONNEMENT.execute(args);
	
}
}
