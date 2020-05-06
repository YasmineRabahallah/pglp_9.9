package dessin;

/**
 * class Point2D.
 * @author rabahallah yasmine.
 *
 */

public class Point2D {
  /**
   * int x position du point sur l'axe X.
   */
  private int px;

  /**
   * int y position du  point sur l'axe Y.
   */
  private int py;

  public void setX(int x) {
    this.px = x;
  }

  public void setY(int y) {
    this.py = y;
  }
  
  /**
   * constructeur Point2D.
   * @param x position du  point sur l'axe X.
   * @param y position du  point sur l'axe Y.
   */
  public Point2D(int x,int y) {
    this.px = x;
    this.py = y;
  }

  /**
   * methode getX.
   * @return la position du point sur l'axe X .
   */
  public int getX() {
    return px;
  }

  /**
   * methode getY.
   * @return la position du point sur l'axe Y.
   */
  public int getY() {
    return py;
  }

}
