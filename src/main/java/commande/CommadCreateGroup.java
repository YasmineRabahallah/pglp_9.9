package commande;

import dessin.GroupeForme;

public class CommadCreateGroup implements Icommande{
	private String name;
	private int idGroupe;
	public CommadCreateGroup(String name ,int idG){
		this.idGroupe = idG;
		this.name = name;
	}
	@Override
	public void execute() {
		new GroupeForme(name,idGroupe);
	}

}
