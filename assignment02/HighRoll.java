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

public class HighRoll {
  public static void main(String args[]) {
    int dice=0;
    int sides =0;
    int highScore = 0;
    int sum;

    if (args.length != 2) {
      System.out.println("Invalid Arguments");
      System.out.println("Please type in 'Java HighRoll {number of dice} {number of sides}''");
      System.exit(0);
    }else{
      try {
        dice = Integer.parseInt(args[0]);
        sides = Integer.parseInt(args[1]);
      } catch(NumberFormatException e) {
              System.out.println("Please enter Valid Integers");
              System.exit(0);
      }
    }
    if (sides < 4 || dice < 1) {
      System.out.println("Invalid Arguments");
      System.exit(0);
    }
    DiceSet ds = new DiceSet(dice, sides);
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("\n   Welcome to High Roll\n");
    while (true) {
        System.out.println("\n A: ROLL ALL THE DICE\n");
        System.out.println("\n B: ROLL A SINGLE DIE\n");
        System.out.println("\n C: CALCULATE THE SCORE FOR THIS SET\n");
        System.out.println("\n D: SAVE THIS SCORE AS HIGH SCORE\n");
        System.out.println("\n E: DISPLAY THE HIGH SCORE\n");
        System.out.println("\n Q: ENTER 'Q' TO QUIT THE PROGRAM\n" );

        System.out.print( ">>" );
        String inputLine = null;
        try {
            inputLine = input.readLine();
            if (0 == inputLine.length()) {
                System.out.println("PLEASE ENTER SOME TEXT");
            }
            if ('A' == inputLine.charAt(0)) {
                ds.roll();
                System.out.println(ds.toString());
            }
            if ('B' == inputLine.charAt(0)) {
                System.out.println("WHICH DICE DO YOU WANT TO ROLL?");
                inputLine = input.readLine();
                int inputLineInt = Integer.parseInt(inputLine);
                if ((int) inputLineInt>dice){
                  System.out.println("VALUE OUT OF RANGE. PLEASE ENTER A DICE IN LIST");
                }else{
                  ds.rollIndividual(inputLineInt - 1);
                  System.out.println(ds.toString());
                }
            }
            if ('C' == inputLine.charAt(0)) {
                sum = ds.sum();
                System.out.println("CURRENT SCORE:" + sum);
            }
            if ('D' == inputLine.charAt(0)) {
                sum = ds.sum();
                highScore = sum;
            }
            if ('E' == inputLine.charAt(0)) {
                System.out.println("HIGH SCORE:" + highScore);
            }
            if ('Q' == inputLine.charAt(0)) {
                break;
            }

        } catch (IOException ioe){
            System.out.println("Caught IOException");
        }
        }
    }
}
