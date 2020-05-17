package commande;

public class CommandExit implements Icommande {

	@Override
	public void execute() {
		 System.out.println(" vous avez quitter !");
		 Runtime.getRuntime().exit(0);	
		
	}

}
