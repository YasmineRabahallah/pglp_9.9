package commande;

import dessin.Forme;

public class CommandMoveForme implements Icommande{
 private Forme f;
 private int depX;
 private int depY;
 public CommandMoveForme(Forme f,int x,int y){
	 this.depX = x;
	 this.depY = y;
 }
@Override
public void execute() {
	this.f.deplacer(depX, depY);
}
}
