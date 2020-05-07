package dao;

import dessin.Carre;
import dessin.Cercle;
import dessin.GroupeForme;
import dessin.Rectangle;
import dessin.Triangle;

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
