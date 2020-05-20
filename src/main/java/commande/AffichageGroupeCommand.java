package commande;

import dessin.GroupeForme;

public class AffichageGroupeCommand implements AffichageCommand{
    private GroupeForme groupe;
    public AffichageGroupeCommand(GroupeForme g){
    	this.groupe = g;
    }
	@Override
	public String execute() {
		return groupe.print();
	}

}
