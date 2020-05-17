package commande;

public class CommandExit implements CommandMove  {

	@Override
	public void execute() {
		Runtime.getRuntime().exit(0);	
		
	}

}
