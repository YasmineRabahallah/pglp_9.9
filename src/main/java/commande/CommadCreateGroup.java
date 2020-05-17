package commande;

import dessin.GroupeForme;

public class CommadCreateGroup implements CommandCreate<GroupeForme>{
	private String name;
	private int idGroupe;
	public CommadCreateGroup(String name ,int idG){
		this.idGroupe = idG;
		this.name = name;
	}
    
	public GroupeForme execute() {
		return new GroupeForme(name,idGroupe);
	}

}
