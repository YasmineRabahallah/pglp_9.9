package commande;


import dao.GroupeDaoJdbc;
import dessin.GroupeForme;

public class DeleteCommand implements SpecifiqueCommande {
	 private GroupeForme groupe;
	  private GroupeDaoJdbc gJdbc;
	  public DeleteCommand(GroupeForme g){
		  this.gJdbc = new GroupeDaoJdbc();
		  this.groupe = g;
	  }
		@Override
		public void execute() {
		 gJdbc.delete(this.groupe);
			
		}

}
