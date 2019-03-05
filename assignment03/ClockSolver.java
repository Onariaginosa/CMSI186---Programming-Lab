/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @author       :  Ona Igbinedion
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
  *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class ClockSolver {
  /**
   *  Class field definintions go here
   */
   private static final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
   private static final double DEFAULT_TIME_SLICE_SECONDS = 60.0;
   private static final double EPSILON_VALUE              = 0.1;      // small value for double-precision comparisons
   private static double angle = 0.0;
   private static double timeSlice = 60.0;
   private static double angleWindow = 0.1;

  /**
   *  Constructor
   *  This just calls the superclass constructor, which is "Object"
   */
   public ClockSolver() {
      super();
   }

  /**
   *  Method to handle all the input arguments from the command line
   *   this sets up the variables for the simulation
   *  @param  args  String array of the arguments from the command line
   *                args[0] is the angle for which we are looking
   *                args[1] is the time slice; this is optional and defaults to 60 seconds
   *                args[2] is the angleWindow; this is optional and defaults to 0.1
   */
   public static void handleInitialArguments( String args[] ) {
     // args[0] specifies the angle for which you are looking
     //  your simulation will find all the angles in the 12-hour day at which those angles occur
     // args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
     // you may want to consider using args[2] for an "angle window"

      System.out.println( "\n   Hello world, from the ClockSolver program!!\n\n" ) ;
      if( 0 == args.length ) {
         System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Usage: java ClockSolver [angle] [timeSlice] [angle window] \n" +
                             "   Please try again..........." );
         System.exit( 1 );
      } else if( 1 == args.length) {
        angle = Clock.validateAngleArg(args[0]);
      } else if( 2 == args.length) {
        angle = Clock.validateAngleArg(args[0]);
        timeSlice = Clock.validateTimeSliceArg(args[1]);
      }else if( 3 == args.length) {
        angle = Clock.validateAngleArg(args[0]);
        timeSlice = Clock.validateTimeSliceArg(args[1]);
        angleWindow = Clock.validateAngleArg(args[2]);
      }else if( args.length > 3) {
        System.out.println( "   Sorry you must enter between one and three arguments\n" +
                            "   Usage: java ClockSolver [angle] [timeSlice] [angle window] \n" +
                            "   Please try again..........." );
        System.exit( 1 );
      }
      if(angle  == -1 || timeSlice == -1 || angleWindow == -1 ) {
        System.out.println("  Sorry, Invalid arguments \n" +
                           "  Please try again . . . . . . . . . . .");
      }
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  @param  args  String array of the arguments from the command line
   *                args[0] is the angle for which we are looking
   *                args[1] is the time slice; this is optional and defaults to 60 seconds
   */
   public static void main( String args[] ) {
      handleInitialArguments( args );
      Clock clock    = new Clock(timeSlice);
      System.out.println("  Looking for target angle "+ angle+" degrees, with a time slice of "+ timeSlice+ " and an angle window of "+angleWindow);
      while( clock.getTotalSeconds() < 43200) {
        if (Math.abs(clock.getHandAngle() -angle) <= angleWindow || Math.abs(360 - clock.getHandAngle() - angle ) <= angleWindow) {
          System.out.println("  Found target angle at "+clock);
        }
        clock.tick();
      }
      System.exit( 0 );
   }
}
