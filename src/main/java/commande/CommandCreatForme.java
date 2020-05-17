package commande;

import dao.Dao;
import dao.DaoFactoryJdbc;
import dessin.Carre;
import dessin.Cercle;
import dessin.Forme;
import dessin.GroupeForme;
import dessin.Rectangle;
import dessin.Triangle;

public class CommandCreatForme implements Icommande {
    private Forme forme;
    private DaoFactoryJdbc dao; 
    public  CommandCreatForme(Forme f){
    	this.forme=f;
    	this.dao = new DaoFactoryJdbc();
    }
	@Override
	public void execute() {
		 if(this.forme instanceof  Carre){
			 Dao<Carre> daoC = dao.createCarreJdbc();
	            	daoC.create((Carre) forme); 
	     }  else if (this.forme instanceof  Cercle){
	    	 Dao<Cercle> daoCr = dao.createCercleJdbc();
	    	 daoCr.create((Cercle) forme);
	     } else if (this.forme instanceof  Triangle){
	    	 Dao<Triangle> daoT = dao.crateTriangleJdbc();
	    	 daoT.create((Triangle) forme);
	     }else if (this.forme instanceof  Rectangle){
	    	 Dao<Rectangle> daoR = dao.createRectangleJdbc();
	    	 daoR.create((Rectangle) forme);
	     }else if (this.forme instanceof  GroupeForme){
	    	 Dao<GroupeForme> daoG = dao.createGroupeJdbc();
	    	 daoG.create((GroupeForme) forme);
	     }
		 System.out.println("la forme est creé");
		 
		 
		 

}
}
