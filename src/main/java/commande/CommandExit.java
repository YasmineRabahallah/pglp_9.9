package commande;

public class CommandExit implements Icommande  {

	@Override
	public void execute() {
		Runtime.getRuntime().exit(0);	
		
	}

}
