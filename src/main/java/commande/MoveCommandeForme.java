package commande;

import dao.Dao;
import dao.DaoFactoryJdbc;
import dessin.Carre;
import dessin.Cercle;
import dessin.Forme;
import dessin.GroupeForme;
import dessin.Rectangle;
import dessin.Triangle;

public class MoveCommandeForme implements Icommande{
    private Forme forme;
    private int depX;
    private int depY;
    private DaoFactoryJdbc dao; 
    public MoveCommandeForme(Forme f, int x ,int y){
    	this.forme=f;
    	this.depX=x;
    	this.depY=y;
    	this.dao = new DaoFactoryJdbc();
    }
	@Override
	public void execute() {
		this.forme.deplacer(depX, depY);
		if(this.forme instanceof  Carre){
			 Dao<Carre> daoC = dao.createCarreJdbc();
	            	daoC.update((Carre) forme); 
	     }  else if (this.forme instanceof  Cercle){
	    	 Dao<Cercle> daoCr = dao.createCercleJdbc();
	    	 daoCr.update((Cercle) forme);
	     } else if (this.forme instanceof  Triangle){
	    	 Dao<Triangle> daoT = dao.crateTriangleJdbc();
	    	 daoT.update((Triangle) forme);
	     }else if (this.forme instanceof  Rectangle){
	    	 Dao<Rectangle> daoR = dao.createRectangleJdbc();
	    	 daoR.update((Rectangle) forme);
	     }else if (this.forme instanceof  GroupeForme){
	    	 Dao<GroupeForme> daoG = dao.createGroupeJdbc();
	    	 daoG.update((GroupeForme) forme);
	     }
		 System.out.println("la forme est déplacée");
	}

}
