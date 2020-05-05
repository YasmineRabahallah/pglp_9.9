package Dessin;

public interface AbstractFactoryJdbc {
  Dao<Cercle> createCercleJdbc();
  Dao<GroupeForme> createGroupeJdbc();
  Dao<Carre> createCarreJdbc();
  Dao<Rectangle> createRectangleJdbc();
  Dao<Triangle> crateTriangleJdbc();
}
