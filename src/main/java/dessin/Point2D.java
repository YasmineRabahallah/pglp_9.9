package dessin;

/**
 * class Point2D
 * @author rabahallah yasmine.
 *
 */

public class Point2D {
  /**
   * int x position du point sur l'axe X.
   */

  private int x;

  /**
   * int y position du  point sur l'axe Y.
   */

  private int y;

  public void setX(int x) {
	this.x = x;
}
public void setY(int y) {
	this.y = y;
}
/**
   * 
   * @param x position du  point sur l'axe X.
   * @param y position du  point sur l'axe Y.
   */

  public Point2D(int x,int y) {
    this.x = x;
    this.y = y;
  }
  /**
   * methode getX.
   * @return la position du point sur l'axe X .
   */
  public int getX() {
	return x;
  }

  /**
   * methode getY.
   * @return la position du point sur l'axe Y.
   */
  public int getY() {
	return y;
  }

}
