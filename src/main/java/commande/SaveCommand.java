package commande;

import dao.GroupeDaoJdbc;
import dessin.GroupeForme;

public class SaveCommand implements SpecifiqueCommande {
  private GroupeForme groupe;
  private GroupeDaoJdbc gJdbc;
  public SaveCommand(GroupeForme g){
	  this.gJdbc = new GroupeDaoJdbc();
	  this.groupe = g;
  }
	@Override
	public void execute() {
	 gJdbc.create(this.groupe);
		
	}

}
