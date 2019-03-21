/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Creates an soccer simulation
 *  @author       :  Ona Igbinedion
 *  Date written  :  2019-03-15
 *  Description   :  This class creates a soccer simulation where balls are moving at different starting positions
 *
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are inapropriate
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.text.DecimalFormat;
public class SoccerSim {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_X_POSITION = 0;
   private static final double DEFAULT_Y_POSITION = 0;
   private static final double DEFAULT_X_SPEED = 60;
   private static final double DEFAULT_Y_SPEED = 80;
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60;
   private static double timeSlice;
   private static boolean state;
   private static Ball[] balls;
   private static Ball pole = new Ball(0, 0, 0, 0);
   private static String colliders = "No objects collided";

  /**
   *  Constructor goes here
   *  @param  xPosition double used in constructor to determine the current x position
   *  @param  yPosition double used in constructor to determine the current y position
   *  @param  xSpeed double used in constructor to determine the x component of the velocity
   *  @param  ySpeed double used in constructor to determine the y component of the velocity
   */
   public SoccerSim() {
     super();

   }
   public void handleInitialArguments( String args[] ) {
     // args[0] specifies the angle for which you are looking
     //  your simulation will find all the angles in the 12-hour day at which those angles occur
     // args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
     // you may want to consider using args[2] for an "angle window"

      System.out.println( "\n   Hello world, from the SoccerSim program!!\n\n  This is a collisions simulation with multiple balls on a soccer field of unlimited size." ) ;
      try {
        if( 4 > args.length) {
          throw new Exception();
        } else if( 0 == args.length%4) {
          state = false;
          balls = new Ball[args.length/4];
           for (int i = 0; i <args.length;i+=4){
             double x = Double.parseDouble(args[i]);
             double y = Double.parseDouble(args[i+1]);
             double xSpeed = Double.parseDouble(args[i+2]);
             double ySpeed = Double.parseDouble(args[i+3]);
             balls[i/4] = new Ball(x,y,xSpeed,ySpeed);
           }
           timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
        } else if( 1 == args.length%4) {
          state = false;
          balls = new Ball[args.length/4];
          for (int i = 0; i <(args.length-1);i+=4){
            double x = Double.parseDouble(args[i]);
            double y = Double.parseDouble(args[i+1]);
            double xSpeed = Double.parseDouble(args[i+2]);
            double ySpeed = Double.parseDouble(args[i+3]);
            balls[i/4] = new Ball(x,y,xSpeed,ySpeed);
          }
          timeSlice = Clock.validateTimeSliceArg(args[args.length -1]);
        }else if( 1 < args.length%4) {
          throw new Exception();
        }
        if(timeSlice == -1) {
          System.out.println("  Invalid timeSlice argument \n" );
          throw new Exception();
      }
    }catch (Exception e) {
      System.out.println(e);
      System.out.println( "   Sorry you must enter 4 arguments per ball, with an optional timeSlice after all of your ball variables\n" +
                          "   Usage: java SoccerSim [x Position Ball1] [y Position Ball1] [x speed Ball1] [y speed Ball1] ...  {time Slice} \n" +
                          "   Please try again..........." );
      System.exit( 1 );
    }
    state = false;
   }
  /**
   *  Method to determine whether there is a collison between the balls.
   *  @return boolean called state, which answers the question of whether a ball has collided
   */
   public boolean collision() {
     if (balls.length >1){
       for (int i = 0; i <balls.length-1;i++){
         if(((balls[i].xPosition -  pole.xPosition)<0.74166666663) && ((balls[i].yPosition -pole.yPosition)<0.74166666663) ) {
           state = true;
           colliders = "Ball "+i+" and the Pole collided.";
           return state;
         }
         for(int j = 1; j < balls.length - 2; j++){
          if(((balls[i].xPosition -  balls[j].xPosition)< 0.74166666663) && ((balls[i].yPosition -balls[j].yPosition)<0.74166666663) ) {
            state = true;
            colliders = "Ball "+i+" and Ball "+j+" collided.";
            return state;
          }
         }
        }
       } else {
         if(((balls[0].xPosition -  pole.xPosition)<(0.74166666663) && ((balls[0].yPosition -pole.yPosition)<0.74166666663)) ) {
           state = true;
           colliders = "Ball 0 and the Pole collided.";
           return state;
         }
       }
       return state;
     }
   /**
    *  Method to report the state of the balls.
    *  @return boolean called state, which answers the question of whether a ball has collided
    */
   public void report(boolean collisionState, Clock clocks) {
     System.out.println("\nTime = "+clocks.toString()+" \n  collision:"+collisionState);
     for (int i = 0; i < balls.length; i++){
       System.out.println("   Ball "+i+":"+balls[i].toString()+" Is Still Moving?: "+balls[i].isStillMoving());
     }
   }
   /**
    *  Method to update the speeds
    */
    public void update(Clock clocks) {
      clocks.tick();
      for (int i = 0; i < balls.length; i++){
        balls[i].updateSpeeds(timeSlice);
        balls[i].move(timeSlice);
      }
    }
     /**
      *  Method to check whether a ball is still moving
      *  @return true or false
      */
      public boolean isStillMovingAll() {
        int count = 0;
        for (int i = 0; i < balls.length; i++){
          if (balls[i].isStillMoving() == false){
            count ++;
          }
        }
        if (count != balls.length) {
          count = 0;
          return true;
        } else {
          return false;
        }
      }
  /**
   *  The main program starts here
   *  Test to see if the ball class works somewhat
   */
   public static void main(String[] args) {
     SoccerSim soccerSim = new SoccerSim();
     soccerSim.handleInitialArguments(args);
     Clock clock = new Clock(timeSlice);
     System.out.println("  Looking for collisions  with a time slice of "+ timeSlice+ " seconds and a pole at x ="+pole.xPosition+" and y="+pole.yPosition+" \n\n");
     while( state == false && soccerSim.isStillMovingAll() == true) {
       soccerSim.report(soccerSim.collision(), clock);
       soccerSim.update(clock);
       soccerSim.isStillMovingAll();
     }
     System.out.println("\n"+colliders);
     System.out.println("Final State of All Objects:");
     soccerSim.report(soccerSim.collision(), clock);
     System.out.println("   Pole: position = ("+pole.xPosition+","+pole.yPosition+")");
     System.exit( 0 );
 }
  }
