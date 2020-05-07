package dao;

import dessin.Carre;
import dessin.Cercle;
import dessin.GroupeForme;
import dessin.Rectangle;
import dessin.Triangle;

/**
 * class DaoFactoryJdbc.
 * @author rabahallah yasmine.
 *
 */

public class DaoFactoryJdbc implements AbstractFactoryJdbc {

  public Dao<Cercle> createCercleJdbc() {
    return  new CercleDaoJdbc();
  }

  public Dao<GroupeForme> createGroupeJdbc() {
    return new GroupeDaoJdbc();
  }

  public Dao<Carre> createCarreJdbc() {
    return new CarreDaoJdbc();
  }

  public Dao<Rectangle> createRectangleJdbc() {
    return new  RectangleDaoJdbc();
  }

  public Dao<Triangle> crateTriangleJdbc() {
    return new TriangleDaoJdbc();
  }

}
