/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Provides a class defining methods for the Ball class
 *  @author       :  Ona Igbinedion
 *  Date written  :  2019-03-15
 *  Description   :  This class provides a bunch of methods which may be useful for the SoccerSim class
 *                   for Homework 4.
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are inapropriate
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.text.DecimalFormat;
public class Ball {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_X_POSITION = 0;
   private static final double DEFAULT_Y_POSITION = 0;
   private static final double DEFAULT_X_SPEED = 60;
   private static final double DEFAULT_Y_SPEED = 80;
   public double xPosition, yPosition, xSpeed, ySpeed;

  /**
   *  Constructor goes here
   *  @param  xPosition double used in constructor to determine the current x position
   *  @param  yPosition double used in constructor to determine the current y position
   *  @param  xSpeed double used in constructor to determine the x component of the velocity
   *  @param  ySpeed double used in constructor to determine the y component of the velocity
   */
   public Ball(double xPosition, double yPosition, double xSpeed, double ySpeed) {
     this.xPosition = xPosition;
     this.yPosition = yPosition;
     this.xSpeed = xSpeed;
     this.ySpeed = ySpeed;
   }

  /**
   *  Method to get the current speed of the ball
   *  @return double-precision value of the current x speed
   */

   public Double getCurrentSpeed() {
     double speed = Math.hypot(this.xSpeed,this.ySpeed);
     return speed;
   }
   /**
    *  Method to get the current position value of the ball
    *  @return double-precision value of the current position in array format
    */
    public double[] getCurrentPosition() {
      double[] position = new double[2];
      position[0] = this.xPosition;
      position[1] = this.xPosition;
      return position;
    }
     /**
      *  Method to check whether a ball is still moving
      *  @return true or false
      */
      public boolean isStillMoving() {
        if(getCurrentSpeed() <=  0.08333333333){
          return false;
        } else {
          return true;
        }
      }
      /**
       *  Method to update the speeds
       * @param  timeSlice double used to determine the updated speed
       */
      public void updateSpeeds(double timeSlice) {
        this.xSpeed = this.xSpeed *Math.pow(0.99,timeSlice);
        this.ySpeed = this.ySpeed *Math.pow(0.99,timeSlice);
      }
      /**
       *  Method to change the ball's position
       * @param  timeSlice double used to determine the updated position
       */
      public void move(double timeSlice) {
        this.xPosition = this.xPosition + this.xSpeed*timeSlice;
        this.yPosition = this.yPosition + this.ySpeed*timeSlice;
      }
      /**
       *  Method to change the ball's position
       */
       public String toString() {


         return "position = ("+this.xPosition+","+this.yPosition+")  speed = "+getCurrentSpeed();
       }

  /**
   *  The main program starts here
   *  Test to see if the ball class works somewhat
   *  @param  args String array gathered from user input
   */
   public static void main(String[] args) {

      System.out.println( "\nBALL CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new ball: " );
      Ball ball = new Ball(DEFAULT_X_POSITION, DEFAULT_Y_POSITION, DEFAULT_X_SPEED, DEFAULT_Y_SPEED);
      System.out.println( "    New ball created: " + ball.toString() );
      System.out.println( "    Testing updateSpeeds....");
      try {
        System.out.println( "    time is 1 second in, expecting a speed value of 99.0");
        ball.updateSpeeds(1);
        System.out.println( "    Updated ball: " + ball.toString() );

        Ball balla = new Ball(DEFAULT_X_POSITION, DEFAULT_Y_POSITION, DEFAULT_X_SPEED, DEFAULT_Y_SPEED);
        System.out.println( "    New ball created: " + balla.toString() );
        System.out.println( "    time is 30 second in, expecting a speed value of 73.97");
        balla.updateSpeeds(30);
        System.out.println( "    Updated ball: " + balla.toString() );
        System.out.println( "    time is 60 second in, expecting a speed value of 40.47");
        balla.updateSpeeds(30);
        System.out.println( "    Updated ball: " + balla.toString() );

        System.out.println( "    Testing move....");
        Ball ball2 = new Ball(DEFAULT_X_POSITION, DEFAULT_Y_POSITION, DEFAULT_X_SPEED, DEFAULT_Y_SPEED);
        System.out.println( "    New ball created: " + ball2.toString() );
        System.out.println( "    time is 1 second in, expecting a position value of (59.4,79.2)");
        ball2.updateSpeeds(1);
        ball2.move(1);
        System.out.println( "    Updated ball: " + ball2.toString() );
        Ball ballb = new Ball(DEFAULT_X_POSITION, DEFAULT_Y_POSITION, DEFAULT_X_SPEED, DEFAULT_Y_SPEED);
        System.out.println( "    New ball created: " + ballb.toString() );
        System.out.println( "    time is 30 second in, expecting a position value of (1331.5,1775.3)");
        ballb.updateSpeeds(30);
        ballb.move(30);
        System.out.println( "    Updated ball: " + ballb.toString() );
        Ball ballz = new Ball(DEFAULT_X_POSITION, DEFAULT_Y_POSITION, DEFAULT_X_SPEED, DEFAULT_Y_SPEED);
        System.out.println( "    New ball created: " + ballz.toString() );
        System.out.println( "    time is 200 second in, expecting a position value of (1607.8,2143.7)");
        ballz.updateSpeeds(200);
        ballz.move(200);
        System.out.println( "    Updated ball: " + ballz.toString() );

        System.out.println( "    Testing isStillMoving....");
        Ball ball3 = new Ball(20, 20, 5, 5);
        System.out.println( "    New ball created: " + ball3.toString() );
        System.out.println( "    time is 60 second in, expecting is still moving value of true");
        ball3.move(60);
        ball3.updateSpeeds(60);
        System.out.println( ball3.isStillMoving());
        System.out.println( "    Updated ball: " + ball3.toString() );
        System.out.println( "    time is 120 second in, expecting a is still moving value of true");
        ball3.move(60);
        ball3.updateSpeeds(60);
        System.out.println( ball3.isStillMoving());
        System.out.println( "    Updated ball: " + ball3.toString() );
        System.out.println( "    time is 120 second in, expecting a is still moving value of true");
        balla.move(60);
        System.out.println( balla.isStillMoving());
        System.out.println( "    Updated ball: " + balla.toString() );
        System.out.println( "    time is 200 second in, expecting a is still moving value of true");
        System.out.println( balla.isStillMoving());
        balla.move(80);
      }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() );
    }
  }
}
