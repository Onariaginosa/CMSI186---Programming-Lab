/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  B.J. Johnson
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
import java.text.DecimalFormat;
public class Clock {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
   private double seconds, angle, timeSlice, hourHandAngle, minuteHandAngle;

  /**
   *  Constructor goes here
   *  @param  timeSlice double used in constructor to determine whether the time slice is valid
   */
   public Clock(double timeSlice) {
     if (timeSlice <= 0 || timeSlice > 1800 ){
       throw new IllegalArgumentException("Invalid time slice");
     }
     seconds = 0;
     this.timeSlice = timeSlice;
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick() {
     seconds += timeSlice;
     getMinuteHandAngle();
     getHourHandAngle();
     return seconds;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   */
   public static double validateAngleArg( String argValue ) {
     double angle = Double.parseDouble(argValue);
     if (angle < 0 || angle >= MAXIMUM_DEGREE_VALUE) {
       angle = INVALID_ARGUMENT_VALUE;
     }
     return angle;
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public static double validateTimeSliceArg( String argValue ) {
      double slice = Double.parseDouble(argValue);
      if (slice <= 0 || slice > 1800 ){
        slice = INVALID_ARGUMENT_VALUE;
      }
      return slice;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
      hourHandAngle = HOUR_HAND_DEGREES_PER_SECOND*(seconds%43200);
      return hourHandAngle;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
      minuteHandAngle = MINUTE_HAND_DEGREES_PER_SECOND*(seconds%3600);
      return minuteHandAngle;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
     return Math.abs(minuteHandAngle-hourHandAngle);
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return seconds;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
     return String.format("%02d : %02d : %4.2f", (int)seconds / 3600, (int)seconds % 3600 / 60, seconds % 3600 % 60);
    }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   *  @param args a list of the arguments used in the clock Tester. This is in string format
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock(DEFAULT_TIME_SLICE_IN_SECONDS);
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.println( "      sending '  0 degrees', expecting double value   0.0" );
      try {
        System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got 0.0" : " - fix this please" );
        System.out.println( "     sending '  60 degrees', expecting double value   60.0" );
        System.out.println((60.0 == clock.validateAngleArg( "60.0" )) ? " - got 60.0" : " - fix this please" );
        System.out.println( "     sending '  30 degrees', expecting double value   30.0" );
        System.out.println((30.0 == clock.validateAngleArg( "30.0" )) ? " - got 30.0" : " - fix this please" );
        System.out.println( "     sending '  -260 degrees', expecting double value   -1.0" );
        System.out.println((INVALID_ARGUMENT_VALUE == clock.validateAngleArg( "-260.0" )) ? " - got -1.0" : " - fix this please" );
        System.out.println( "     sending '  -360 degrees', expecting double value   -1.0" );
        System.out.println((INVALID_ARGUMENT_VALUE == clock.validateAngleArg( "-360.0" )) ? " - got -1.0" : " - fix this please" );
        System.out.println( "     sending '  361 degrees', expecting double value   -1.0" );
        System.out.println((INVALID_ARGUMENT_VALUE == clock.validateAngleArg( "361.0" )) ? " - got -1.0" : " - fix this please" );
        System.out.println( "     sending '  360.1 degrees', expecting double value   -1.0" );
        System.out.println((INVALID_ARGUMENT_VALUE == clock.validateAngleArg( "360.1" )) ? " - got -1.0" : " - fix this please" );
        System.out.println( "     sending '  -0.1 degrees', expecting double value   -1.0" );
        System.out.println((INVALID_ARGUMENT_VALUE == clock.validateAngleArg( "-0.1" )) ? " - got 360.0" : " - fix this please" );
        System.out.println( "     sending '  0.1 degrees', expecting double value   0.1" );
        System.out.println((0.1 == clock.validateAngleArg( "0.1" )) ? " - got 0.1" : " - fix this please" );
        System.out.println( "     sending '  187 degrees', expecting double value   187.0" );
        System.out.println((187.0 == clock.validateAngleArg( "187.0" )) ? " - got 187.0" : " - fix this please" );
        System.out.println( "     sending '  1870 degrees', expecting double value   -1.0" );
        System.out.println((INVALID_ARGUMENT_VALUE == clock.validateAngleArg( "1870.0" )) ? " - got -1.0" : " - fix this please" );
    }
    catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() );
  }
  System.out.println( "    Testing validateTimeSliceArg()....");
  try{
    System.out.println( "      sending '  0 seconds', expecting double value   -1.0" );
    System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateTimeSliceArg( "0.0" )) ? " - got -1.0" : " - fix this please" );
    System.out.println( "      sending '  -10 seconds', expecting double value   -1.0" );
    System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateTimeSliceArg( "-10.0" )) ? " - got -1.0" : " - fix this please" );
    System.out.println( "      sending '  1800 seconds', expecting double value   -1.0" );
    System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateTimeSliceArg( "1800.0" )) ? " - got -1.0" : " - fix this please" );
    System.out.println( "      sending '  1799 seconds', expecting double value   1799.0" );
    System.out.println( (1799.0 == clock.validateTimeSliceArg( "1799.0" )) ? " - got 1799.0" : " - fix this please" );
    System.out.println( "      sending '  1799.9 seconds', expecting double value   1799.9" );
    System.out.println( (1799.9 == clock.validateTimeSliceArg( "1799.9" )) ? " - got 1799.9" : " - fix this please" );
    System.out.println( "      sending '  1800.1 seconds', expecting double value   -1.0" );
    System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateTimeSliceArg( "1800.1" )) ? " - got -1.0" : " - fix this please" );
    System.out.println( "      sending '  60 seconds', expecting double value   60.0" );
    System.out.println( (60.0 == clock.validateTimeSliceArg( "60.0" )) ? " - got 60.0" : " - fix this please" );
    System.out.println( "      sending '  180 seconds', expecting double value   180.0" );
    System.out.println( (180.0 == clock.validateTimeSliceArg( "180.0" )) ? " - got 180.0" : " - fix this please" );
    System.out.println( "      sending '  -1800 seconds', expecting double value   -1.0" );
    System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateTimeSliceArg( "-1800.0" )) ? " - got -1.0" : " - fix this please" );
    System.out.println( "      sending '  -0.1 seconds', expecting double value   -1.0" );
    System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateTimeSliceArg( "0.0" )) ? " - got 0.0" : " - fix this please" );
    System.out.println( "      sending '  0.1 seconds', expecting double value   0.1" );
    System.out.println( (0.1 == clock.validateTimeSliceArg( "0.1" )) ? " - got 0.1" : " - fix this please" );
    }
    catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
  }
}
