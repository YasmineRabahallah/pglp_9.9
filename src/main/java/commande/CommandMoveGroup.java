package commande;

import dessin.GroupeForme;

public class CommandMoveGroup implements CommandMove{
 private GroupeForme g;
 private int depX;
 private int depY;
 public CommandMoveGroup(GroupeForme g ,int x,int y){
	 this.g = g;
	 this.depX = x;
	 this.depY = y;
 }
@Override
public void execute() {
	this.g.deplacer(depX, depY);
}
}
