package commande;

import dao.GroupeDaoJdbc;
import dessin.GroupeForme;

public class FindCommande implements CommandCreateForme<GroupeForme>{
	 private String nomGroupe;
	  private GroupeDaoJdbc gJdbc;
	  public FindCommande(String nom){
		  this.gJdbc = new GroupeDaoJdbc();
		  this.nomGroupe = nom;
	  }
	@Override
	public GroupeForme execute() {
		return gJdbc.retrieve(nomGroupe) ;
	}

}
