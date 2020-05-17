package commande;

import dao.Dao;
import dao.DaoFactoryJdbc;
import dessin.Carre;
import dessin.Cercle;
import dessin.Forme;
import dessin.GroupeForme;
import dessin.Rectangle;
import dessin.Triangle;

public class DeleteCommandeForme implements Icommande{
	private Forme forme;
    private DaoFactoryJdbc dao; 
    public  DeleteCommandeForme(Forme f){
    	this.forme=f;
    	this.dao = new DaoFactoryJdbc();
    }
	@Override
	public void execute() {
		 if(this.forme instanceof  Carre){
			 Dao<Carre> daoC = dao.createCarreJdbc();
	            	daoC.delete((Carre) forme); 
	     }  else if (this.forme instanceof  Cercle){
	    	 Dao<Cercle> daoCr = dao.createCercleJdbc();
	    	 daoCr.delete((Cercle) forme);
	     } else if (this.forme instanceof  Triangle){
	    	 Dao<Triangle> daoT = dao.crateTriangleJdbc();
	    	 daoT.delete((Triangle) forme);
	     }else if (this.forme instanceof  Rectangle){
	    	 Dao<Rectangle> daoR = dao.createRectangleJdbc();
	    	 daoR.delete((Rectangle) forme);
	     }else if (this.forme instanceof  GroupeForme){
	    	 Dao<GroupeForme> daoG = dao.createGroupeJdbc();
	    	 daoG.delete((GroupeForme) forme);
	     }
		 System.out.println("la forme est supprimé");
		 
		 
		 

}
}


