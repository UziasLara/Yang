
/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Turtle extends SimpleTurtle
{
  ////////////////// constructors ///////////////////////
  
  /** Constructor that takes the x and y and a picture to
   * draw on
   * @param x the starting x position
   * @param y the starting y position
   * @param picture the picture to draw on
   */
  public Turtle (int x, int y, Picture picture) 
  {
    // let the parent constructor handle it
    super(x,y,picture);
  }
  
  /** Constructor that takes the x and y and a model
   * display to draw it on
   * @param x the starting x position
   * @param y the starting y position
   * @param modelDisplayer the thing that displays the model
   */
  public Turtle (int x, int y, ModelDisplay modelDisplayer) 
  {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
  }
  
  /** Constructor that takes the model display
   * @param modelDisplay the thing that displays the model
   */
  public Turtle (ModelDisplay modelDisplay) 
  {
    // let the parent constructor handle it
    super(modelDisplay);
  }
  
  /**
   * Constructor that takes a picture to draw on
   * @param p the picture to draw on
   */
  public Turtle (Picture p)
  {
    // let the parent constructor handle it
    super(p);
  }
  
  /////////////////// methods ///////////////////////
  public static void Question1() {
	    World myWorld = new World(800,800);
	    Turtle kappa = new Turtle(myWorld);
	    //Turtle tortuga = new Turtle(myWorld);
	    //tortuga.forward(-200);
	    for (int sides = 1; sides <=4; sides++) {
	      kappa.forward(100);
	      kappa.turn(-90);
	      kappa.forward(220);
	      kappa.turn(-90);
	     
	    }
	  }
	  
	  public static void Question2() {
	    //Picture t = new Picture("D:/Workspace/Yang/src/media-source/greenTurtle.jpg");
	    FileChooser.setMediaPath("D:/Workspace/Yang/media-source/");
	    Picture canvas = new Picture(800,800);
	    Turtle tortuga = new Turtle(canvas);
	    Picture greenT = new Picture(FileChooser.getMediaPath("greenTurtle.jpg"));
	    for (int i = 1; i <=18;i++) {
	      tortuga.turn(-20);
	      tortuga.forward(40);
	      
	      tortuga.drop(greenT.scale(0.5));
	    }  //end for loop
	    Turtle tortuga2 = new Turtle(canvas);
	    tortuga2.turn(90);
	    tortuga2.forward(80);
	    for (int j=0; j<5; j++) {
	     
	     tortuga2.forward(40);
	     tortuga2.drop(greenT.scale(0.5));
	      
	    }  //end for loop
	    canvas.show();
	                                
	  } //end Question2
	  
	  public static void h2_1() {
		  FileChooser.setMediaPath("D:/Workspace/Yang/media-source/");
		  Picture paint = new Picture(600,600);
		  Turtle tortuga3 = new Turtle(paint);
		  Picture torpic = new Picture(FileChooser.getMediaPath("greenTurtle.jpg"));
		  for (int i =1;i<=4; i++) {
			  tortuga3.turn(90);
			  for (int j=1; j<=5;j++){
			 // tortuga3.turn(40);
			  tortuga3.forward(40);
			  tortuga3.drop(torpic.scale(0.5));
			  }
			  //tortuga3.turn(90);
			  
		  }
		  paint.show();
		  
		  
	  }
	  
	  
	  
	  
	  public static void main(String[] args){
	    //Question1();
	    //Question2();
		//h2_1();
	  
	    
	    
	    
	    
	  
	  
	  
	  
	  
	  }

} // end of class Turtle, put all new methods before this