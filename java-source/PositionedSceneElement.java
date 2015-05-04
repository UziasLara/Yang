/**
 * Class that represents a positioned scene element
 * @author Mark Guzdial
 * @author Barb Ericson
 */
public class PositionedSceneElement {
  
  /** the picture that this element holds */
  private Picture myPic;
  
  /** the next element in the list */
  private PositionedSceneElement next;
  
  /**
   * Make a new element with a picture as input, and
   * next as null.
   * @param heldPic Picture for element to hold
   */
  public PositionedSceneElement(Picture heldPic) {
    myPic = heldPic;
    next = null;
  }
  
  /**
   * Method to set the next element
   * @param nextOne next element in list
   */
  public void setNext(PositionedSceneElement nextOne) {
    this.next = nextOne;
  }
  
  /**
   * Method to get the next element
   * @return the next element in the list
   */
  public PositionedSceneElement getNext() {
    return this.next;
  }
  
  /**
   * Returns the picture in the node.
   * @return the picture in the node
   */
  public Picture getPicture() {
    return this.myPic;
  }
  
  /**
   * Method to draw from this node on in the list, using blueScreen.
   * Each new element has it's lower-left corner at the lower-right 
   * of the previous node. Starts drawing from left-bottom
   * @param bg Picture to draw drawing on
   */
  public void drawFromMeOn(Picture bg) {
    PositionedSceneElement current;
    int currentX=0, currentY = bg.getHeight()-1;
    
    current = this;
    while (current != null) {
      current.drawMeOn(bg,currentX, currentY);
      currentX = currentX + current.getPicture().getWidth();
      current = current.getNext();
    }
  }
  
  /**
   * Method to draw from this picture, using blueScreen.
   * @param bg Picture to draw drawing on
   * @param left x position to draw from
   * @param bottom y position to draw from
   */
  private void drawMeOn(Picture bg, int left, int bottom) {
    // Bluescreen takes an upper left corner
    this.getPicture().blueScreen(bg,left,
                                 bottom-this.getPicture().getHeight());
  }
  
  /** 
   * Method to remove a node from a list, fixing links 
   * appropriately.
   * @param node element to remove from list.
   */
  public void remove(PositionedSceneElement node) {
    if (node==this) {
      System.out.println("I can't remove the " +
                         "first node from the list.");
      return;
    }
    
    PositionedSceneElement current = this;
    
    // While there are more nodes to consider
    while (current.getNext() != null) {
      
      if (current.getNext() == node) {
        // Simply make node's next be this next
        current.setNext(node.getNext());
        // Make this node point to nothing
        node.setNext(null);
        return;
      }
      current = current.getNext();
    }
  }
  
  /**
   * Insert the input node after this node.
   * @param node element to insert after this.
   */
  public void insertAfter(PositionedSceneElement node) {
    
    // Save what "this" currently points at
    PositionedSceneElement oldNext = this.getNext();
    this.setNext(node);
    node.setNext(oldNext);
  }
  
  /* 
   * Returns a copy of this PositionedSceneElement 
   * @return a copy of this element 
   */
  public PositionedSceneElement copy() {
    return new PositionedSceneElement(this.getPicture());
  }
  
  /**
   * Replace the one picture with the other picture
   * in all the elements from me on.
   * Decide two pictures are equal if come from same filename
   * @param oldPic Picture to be replaced
   * @param newPic Picture to put in its place
   */
  public void replace(Picture oldPic, Picture newPic) {
    if (this.myPic.getFileName() != null) {
      if (this.myPic.getFileName().equals(oldPic.getFileName())) {
        this.myPic = newPic;
      }
    }
    
    if (this.next != null) {
      next.replace(oldPic,newPic);
    }
  }
  
  /**
   * Method to get the last element
   * @return the last element in the list
   */
  public PositionedSceneElement last() {
    PositionedSceneElement current;
    
    current = this;
    while (current.getNext() != null) {
      current = current.getNext();
    }
    return current;
  }
  
  public void replaceNext(PositionedSceneElement newNode) 
  {  PositionedSceneElement oldNext= this.getNext(); 
     PositionedSceneElement third = oldNext.getNext();
      
      this.setNext(newNode); //replaces the old next
      newNode.setNext(third); //points to the third
  
  
  }
  
  
  //*************************//
  //Method below//
  public void swapNodes(/*PositionedSceneElement next*/) {
	  PositionedSceneElement next = this.getNext();
	  next.next = next.getNext();
	  next.next.next = next.getNext();
	  
	  this.setNext(next);
  }
//***************************//
  
  
  public static void main(String[] args) {
  //  replaceNext(PositionedSceneElement newNode);
    FileChooser.setMediaPath("D:/Workspace/Yang/media-source/");
    PositionedSceneElement tree1 = new PositionedSceneElement(new Picture(FileChooser.getMediaPath("tree-blue.jpg")));
    PositionedSceneElement tree2 = new PositionedSceneElement(new Picture(FileChooser.getMediaPath("tree-blue.jpg")));
    PositionedSceneElement tree3 = new PositionedSceneElement(new Picture(FileChooser.getMediaPath("tree-blue.jpg")));
    PositionedSceneElement doggy = new PositionedSceneElement(new Picture(FileChooser.getMediaPath("dog-blue.jpg")));
    PositionedSceneElement house = new PositionedSceneElement(new Picture(FileChooser.getMediaPath("house-blue.jpg")));
    Picture bg = new Picture(FileChooser.getMediaPath("jungle.jpg"));
    tree1.setNext(tree2); tree2.setNext(tree3); tree3.setNext(doggy); doggy.setNext(house);
    tree1.drawFromMeOn(bg);
    bg.show();

    
    Picture bg2 = new Picture(FileChooser.getMediaPath("jungle2.jpg"));
    PositionedSceneElement turtle = new PositionedSceneElement(new Picture(FileChooser.getMediaPath("turtle.jpg")));
    
    tree1.setNext(turtle);turtle.setNext(tree3); tree3.setNext(doggy); doggy.setNext(house);
    tree1.drawFromMeOn(bg2);
    bg2.show();
  }
}
