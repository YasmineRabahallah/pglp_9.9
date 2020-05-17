package commande;

import dao.Dao;
import dao.DaoFactoryJdbc;
import dessin.Carre;
import dessin.Cercle;
import dessin.Forme;
import dessin.GroupeForme;
import dessin.Rectangle;
import dessin.Triangle;

public class FindCommandeForme implements Icommande{

	private Forme forme;
    private DaoFactoryJdbc dao; 
    public  FindCommandeForme(Forme f){
    	this.forme=f;
    	this.dao = new DaoFactoryJdbc();
    }
	@Override
	public void execute() {
		 Forme result = null ;
		 if(this.forme instanceof  Carre){
			 Dao<Carre> daoC = dao.createCarreJdbc();
	           result =daoC.retrieve(forme.getName()); 
	     }  else if (this.forme instanceof  Cercle){
	    	 Dao<Cercle> daoCr = dao.createCercleJdbc();
	    	 result = daoCr.retrieve(forme.getName());
	     } else if (this.forme instanceof  Triangle){
	    	 Dao<Triangle> daoT = dao.crateTriangleJdbc();
	    	 result = daoT.retrieve(forme.getName());
	     }else if (this.forme instanceof  Rectangle){
	    	 Dao<Rectangle> daoR = dao.createRectangleJdbc();
	    	 result = daoR.retrieve(forme.getName());
	     }else if (this.forme instanceof  GroupeForme){
	    	 Dao<GroupeForme> daoG = dao.createGroupeJdbc();
	    	 result = daoG.retrieve(forme.getName());
	     }
		 System.out.println(result.print());
		 
		 
		 

}

}
