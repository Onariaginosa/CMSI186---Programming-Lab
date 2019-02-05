/**
 *  File name     :  CountTheDays.java
 *  Purpose       :  Program to count the days between 2 dates.
 *  Author        :  Ona Igbinedion
 *  Date          :  2019-01-31
 *  Description   :  This program displays and calculates the number of days.
 *                   The order of the dates is not important, but the order of
 *                     the "month, day, year". Inputs are parsed from the "args"
 *                   command line arguments array and validated. Use the helper class
 *                   CalendarStuff.java to accomplish most of the calculations.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 */
public class CountTheDays {

  /**
   * Define fields so that the main method can access and get filled by constructor
   */

    private static long month1 = 0;
    private static long day1 = 0;
    private static long year1 = 0;
    private static long month2 = 0;
    private static long day2 = 0;
    private static long year2 = 0;

  /**
   * The constructor for the class
   */
   public CountTheDays() {
      month1 = Long.parseLong( args[0] );
      day1 = Long.parseLong( args[1] );
      year1 = Long.parseLong( args[2] );
      month2 = Long.parseLong( args[3] );
      day2 = Long.parseLong( args[4] );
      year2 = Long.parseLong( args[5] );

   }



// public swapDateOrder();

  /**
   * Verify that the correct number of arguments are passed
   * make a new instance of class
   * make a new instance of CalendarStuff class
   * check that the dates are in order, swap them if they arent
   * call the daysBetween method to calculate the days
   * output the results to the display
   */
   public static void main( String args[] ) {
      // check for 6 arguments
      /*CountTheDays ctd = new  CounthTheDays(args);
      CalendarStuff cs = new CalendarStuff();*/
   }

   if ( cs.compareDate(month1, day1, year1, month2, day2, year2); == 1 ) {
      ctd.swapDateOrder();
   }


}
