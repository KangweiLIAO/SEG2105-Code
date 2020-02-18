package design6;
// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public interface InterfacePointCP<C, P>
{
  //abstract methods **************************************************
 
  public double getX();
  
  public double getY();
  
  public double getRho();
  
  public double getTheta();
	
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public P convertStorageToPolar();
  
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public C convertStorageToCartesian();

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString();
}
