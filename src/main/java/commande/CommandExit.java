package commande;

/**
 * class CommandExit.
 * @author rabahallah yasmine.
 *
 */
public class CommandExit implements SpecifiqueCommande  {

  /**
   * methode pour executer la commande exit pour  quitter.
   */
  @Override
  public void execute() {
    Runtime.getRuntime().exit(0);
  }

}
