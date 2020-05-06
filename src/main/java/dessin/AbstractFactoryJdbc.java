package dessin;

/**
 * interface AbstractFactoryJdbc.
 * @author rabahallah yasmine.
 *
 */

public interface AbstractFactoryJdbc {

  Dao<Cercle> createCercleJdbc();

  Dao<GroupeForme> createGroupeJdbc();

  Dao<Carre> createCarreJdbc();

  Dao<Rectangle> createRectangleJdbc();

  Dao<Triangle> crateTriangleJdbc();

}
