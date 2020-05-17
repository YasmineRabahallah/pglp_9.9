package commande;

import dessin.Rectangle;

public class CommandMoveRectangle implements CommandMove{
	private Rectangle rec;
    private int depX;
    private int depY;
    public CommandMoveRectangle(Rectangle rec ,int x,int y){
    	this.rec=rec;
    	this.depX=x;
    	this.depY=y;
    }
	@Override
	public void execute() {
		this.rec.deplacer(depX, depY);
		
	}
}
