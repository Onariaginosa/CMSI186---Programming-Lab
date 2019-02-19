/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  MainProgLoopDemo.java
 *  Purpose       :  Demonstrates the use of input from a command line for use with Yahtzee
 *  Author        :  B.J. Johnson
 *  Date          :  2017-02-14
 *  Description   :
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-14  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll{

   public static void main( String args[] ) {
      System.out.println( "\n   Welcome to High Roll\n" );
      System.out.println("\n A: ROLL ALL THE DICE\n");
      System.out.println("\n B: ROLL A SINGLE DIE\n");
      System.out.println("\n C: CALCULATE THE SCORE FOR THIS SET\n");
      System.out.println("\n D: SAVE THIS SCORE AS HIGH SCORE\n");
      System.out.println("\n E: DISPLAY THE HIGH SCORE\n");
      System.out.println("\n Q: ENTER 'Q' TO QUIT THE PROGRAM\n" );

     // This line uses the two classes to assemble an "input stream" for the user to type
     // text into the program
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
         System.out.print( ">>" );
         String inputLine = null;
         try {
            inputLine = input.readLine();
            if( 0 == inputLine.length() ) {
               System.out.println("enter some text!:");
            }else if ('A' == inputLine.charAt(0)){
              System.out.println("HOW MANY SIDES DO YOU WANT FOR YOUR DIE");
            }
            if( 'Q' == inputLine.charAt(0) ) {
               break;
            }         }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      }
   }
}
