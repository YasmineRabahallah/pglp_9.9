package commande;

import dessin.Carre;
import dessin.Cercle;
import dessin.Forme;
import dessin.Rectangle;
import dessin.Triangle;

public class AffichageFormeCommand implements AffichageCommand {
    private Forme forme;
    public AffichageFormeCommand(Forme forme){
    	this.forme = forme;
    }
	@Override
	public String execute() {
		if(this.forme instanceof  Carre){
			  return ((Carre)forme).print();
	     } 
		if (this.forme instanceof  Cercle){
	    	return ((Cercle)forme).print();
	     }
		if (this.forme instanceof  Triangle){
	    	 return ((Triangle)forme).print();
	     }
		if (this.forme instanceof  Rectangle){
	    	return ((Triangle)forme).print();
	     }
		return null;
	}

}
