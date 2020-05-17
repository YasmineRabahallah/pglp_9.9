package commande;

import dessin.Carre;

public class CommandMoveCarre implements CommandMove{
    private Carre carre;
    private int depX;
    private int depY;
    public CommandMoveCarre(Carre c ,int x,int y){
    	this.carre=c;
    	this.depX=x;
    	this.depY=y;
    }
	@Override
	public void execute() {
		this.carre.deplacer(depX, depY);
		
	}

}
