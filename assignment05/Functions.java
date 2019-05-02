/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Functions.java
 *  Purpose       :  Provides a class defining methods for the Functions class
 *  @author       :  Ona Igbinedion
 *  Date written  :  2019-03-15
 *  Description   :  This class provides a bunch of methods (ie the functions) to be integrated in Riemann.java
 *                   for Homework 5.
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  None at the moment
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.lang.Math;
public class Functions {
  /**
   *  Class field definintions go here
   */
   private static final double INVALID_ARG = -1;

   public static double integral, left, right, delta, yVal;

  /**
   *  Constructor goes here
   *
   */
   public Functions() {
   }

  /**
   *  Method to validate the integral bounds
   *  @return -1 for an invalid bounds, and 1 for a valid bounds
   */
   public static Double validatebounds (double upperBounds, double lowerBounds){
     return INVALID_ARG;
   }
   /**
    *  Method to get the current speed of the ball
    *  @return double-precision value of the current x speed
    */
    public static Double validateArgs (double upperBounds, double lowerBounds){
      return INVALID_ARG;
    }
   public static double poly(double[] args, double val) {
     yVal = 0;
     for (int i = 0; i < args.length; i++){
       yVal += args[i]* Math.pow(val, i);
     }
     return yVal;
   }

   public static double polyIntegrate(double[] args, double[] bounds, double divisions) {
     delta = (bounds[1] - bounds[0])/divisions;
     // left Riemann
     left = 0;
     for (int i = 0; i < divisions; i++){
       left += delta * poly(args,(bounds[0]+delta*i));
     }
     // right Riemann
     right = 0;
     for (int i = 1; i < divisions+1; i++){
       right += delta* poly(args, bounds[0]+(delta*i));
     }
     integral = (left+right)/2;
     return integral;
   }
   public static double sinIntegrate(double[] bounds, double divisions) {
     delta = (bounds[1] - bounds[0])/divisions;
     // left Riemann
     left = 0;
     for (int i = 0; i < divisions; i++){
       left += delta* Math.sin(Math.toRadians(bounds[0])+ (delta*i));
     }
     // right Riemann
     right = 0;
     for (int i = 1; i < divisions+1; i++){
       right += delta* Math.sin(Math.toRadians(bounds[0])+ (delta*i));
     }
     integral = (left+right)/2;
     return integral;
   }
   public static double cosIntegrate( double[] bounds, double divisions) {
     delta = (bounds[1] - bounds[0])/divisions;
     // left Riemann
     left = 0;
     for (int i = 0; i < divisions; i++){
       left += delta* Math.cos(Math.toRadians(bounds[0])+ (delta*i));
     }
     // right Riemann
     right = 0;
     for (int i = 1; i < divisions+1; i++){
       right += delta* Math.cos(Math.toRadians(bounds[0])+ (delta*i));
     }
     integral = (left+right)/2;
     return integral;
   }
   public static int percentSignTest(String percent) {
     int offset;
     if (percent.charAt(percent.length()-1) == '%') {
       offset = 1;
     }else {
       offset = 0;
     }
     return offset;
   }
   public static double percentValue(String percent) {
     String substr = percent.substring(0, percent.length() - 1);
     return (Double.parseDouble(substr)/100);

   }

   public static void main(String[] args) {
     double[] argz = new double [3];
     double boundz[] = new double [2];
     argz[0] = 1;
     argz[1] = 1;
     argz[2] = 1;
     boundz[0] = 0;
     boundz[1] = 6;

}
}
