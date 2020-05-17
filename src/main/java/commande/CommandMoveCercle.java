package commande;

import dessin.Cercle;

public class CommandMoveCercle implements CommandMove {
	private Cercle cercle;
    private int depX;
    private int depY;
    public CommandMoveCercle(Cercle c ,int x,int y){
    	this.cercle=c;
    	this.depX=x;
    	this.depY=y;
    }
	@Override
	public void execute() {
		this.cercle.deplacer(depX, depY);
		
	}
}
