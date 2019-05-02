/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Riemann.java
 *  Purpose       :  Calculates the Riemann sum (integral) of a function
 *  @author       :  Ona Igbinedion
 *  Date written  :  2019-03-21
 *  Description   :  This class calculates the Riemann sum of a polynomial function to an arbitrary
 *                   degree, trig functions, natural log and exponentiation functions and composite
 *                   functions.
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are inapropriate
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Riemann {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_PRECISION_VALUE = .01;
   private static String function;
   private static double[] arguments;
   private static double[] bounds = new double[2];
   private static double precision;
   private static int offset;
   private static int divisions = 1;

  /**
   *  Constructor goes here
   */
   public Riemann() {
   }

   public static void handleInitialArguments( String args[] ) {
      System.out.println( "\n   Hello world, from the Riemann Sum program!!\n\n" +
                          "    This is a Integral calculator using the average of a left and right Riemann sum.\n" +
                          "    SUPPORTED FUNCTIONS: sin, cos, poly \n"+
                          "    NOTE: This program does not accept composite functions.\n" +
                          "    Therefore, only poly accepts arguments, while sin and cos do not\n\n\n" ) ;
      try {
        if( 3 > args.length) {
          System.out.println( "   Sorry you must enter at least 3 arguments \n");
          throw new Exception();
        } else {
          offset = Functions.percentSignTest(args[args.length - 1]);
          if (offset == 0) {
            precision = DEFAULT_PRECISION_VALUE;
          } else {
            precision = Functions.percentValue(args[args.length -1]);
          }
          function = args[0];
          bounds[0] = Double.parseDouble(args[args.length-2-offset]);
          bounds[1] = Double.parseDouble(args[args.length-1-offset]);
          arguments = new double [args.length - 3 - offset];
          if (function.equals("poly") && arguments.length > 1) {
            for (int i=1; i<args.length-2-offset; i++){
              arguments[i-1] = Double.parseDouble(args[i]);
            }
          } else if (function != "poly" && arguments.length > 1 ) {
            System.out.println("   Sorry, only the polynomial function accepts arguments \n");
            throw new Exception();
          } else if (function.equals("poly") && arguments.length < 1 ) {
            System.out.println("   Sorry, the polynomial function requires at least one arguments \n");
            throw new Exception();
          }
        }

      }catch (Exception e) {
        System.out.println( "   Usage: java Riemann [Function Type] {arg1} ... {argN} [Lower Bounds] [Upper Bounds] {(optional) percent difference %} \n" +
                            "   Please try again..........." );
        System.out.println(e);
        System.exit( 1 );
    }
  }
  public static double callFunction() {
    double value = 0;
    switch(function) {
      case "poly":
        System.out.println("Doing Poly");
        value = Functions.polyIntegrate(arguments, bounds, divisions);
        break;
      case "sin":
        System.out.println("Doing Sin");
        value = Functions.sinIntegrate(bounds, divisions);
        break;
      case "cos":
        System.out.println("Doing Cos");
        value = Functions.cosIntegrate(bounds, divisions);
        break;
    }
    return value;
  }


   public static void main(String[] args) {
     handleInitialArguments(args);
     double previous = callFunction();
     divisions ++;
     double current = callFunction();
     double precisionCalc = (current - previous)/previous;

     while(Math.abs(precisionCalc) > Math.abs(precision)) {
       previous = current;
       divisions++;
       current = callFunction();
       precisionCalc = (current - previous)/previous;
       System.out.println("Current = " + current);
       System.out.println("Previous = " + previous);
       System.out.println("Precision = " + precisionCalc);
       System.out.println("Divisons = " + divisions);
     }

   }
 }
