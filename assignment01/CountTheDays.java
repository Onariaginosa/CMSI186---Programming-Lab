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
 public class CountTheDays  {
     public static void main(String args[]) {
         try {
           if(args.length <6 ) {
             System.out.println("Please pass in the correct arguments. Less than 6 arguments just wont do.");
             System.exit(-1);
           }else if (args.length >6) {
             System.out.println("Please pass in the correct arguments. More than 6 arguments just wont do.");
             System.exit(-1);
           }

             long month1 = Long.parseLong(args[0]);
             long day1   = Long.parseLong(args[1]);
             long year1  = Long.parseLong(args[2]);
             long month2 = Long.parseLong(args[3]);
             long day2   = Long.parseLong(args[4]);
             long year2  = Long.parseLong(args[5]);
             long days = 0;

             if(!(CalendarStuff.isValidDate(month1, day1, year1)) || !(CalendarStuff.isValidDate(month2, day2, year2))) {
                 System.out.println("Choose a valid set of dates please.");
                 System.exit(1);

             }else {
               days = CalendarStuff.daysBetween(month1,day1,year1,month2,day2,year2);
               System.out.println("The days between "+month1+"/"+day1+"/"+year1+" and "+month2+"/"+day2+"/"+year2+" is "+days+".");
               System.exit(0);
             }
         }
         catch(NumberFormatException e) {
             System.out.println("Error, please input valid dates.");
         }
     }
 }
