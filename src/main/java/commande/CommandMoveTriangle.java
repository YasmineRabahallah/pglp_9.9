package commande;


import dessin.Triangle;

public class CommandMoveTriangle implements CommandMove {
	private Triangle tr;
    private int depX;
    private int depY;
    public CommandMoveTriangle(Triangle t ,int x,int y){
    	this.tr=t;
    	this.depX=x;
    	this.depY=y;
    }
	@Override
	public void execute() {
		this.tr.deplacer(depX, depY);
		
	}
}
