package model;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Player implements IPlayer{

    private double x;
    private Score playerScore;
    private int leftHandY;
    private int rightHandY;
    // left stack
    private List<Shape> stack1;
    // right stack
    private List<Shape> stack2;
    public List<Shape> getStack1() {
        return stack1;
    }

    public List<Shape> getStack2() {
        return stack2;
    }
    
    public void addToStack1(Shape s) {
        stack1.add(s);
    }
    public void addToStack2(Shape s) {
        stack2.add(s);
    }
    public int getRightHandY() {
		return rightHandY;
	}

	public void incRightHandY() {
		this.rightHandY -= 10;
	}
	public void decRightHandY() {
		this.rightHandY += 30;
	}

	public int getLeftHandY() {
		return leftHandY;
	}

	public void incLeftHandY() {
		this.leftHandY -=10;
	}
	public void decLeftHandY() {
		this.leftHandY +=30;
	}

    public Player() {
    	rightHandY=leftHandY=300;
        stack1 = new ArrayList<Shape>();
        stack2 = new ArrayList<Shape>();
    }

    public void setxAxis(double x) {
        this.x = x;
    }

    public double getxAxis() {
        return x;
    }


    public Score deltaScore(int delta) {
        // to do
        return playerScore;
    }

    public Score getScore() {
        return playerScore;
    }

 // check color of successive shapes and increase score if 3 successive
    // similar are found
    boolean checkColor(List<Shape> stack, Player p,int handY) {
        if (stack.size() >= 3) {
            int index1 = stack.size() - 1;
            int index2 = index1 - 1;
            int index3 = index1 - 2;
            if (stack.get(index1).getColor() == stack.get(index2).getColor() && 
                    stack.get(index2).getColor() == stack.get(index3)
                    .getColor() ){
                    stack.remove(index1);
                    stack.remove(index2);
                    stack.remove(index3);
             if (handY==1){
            	 decLeftHandY();
             }else if(handY==2){
            	 decRightHandY();
             }
                    // increment score 
        }}
        return false;
    }
    
    boolean withinLeftRange(Shape s) {
        int x = (int) this.getxAxis();
        ValueRange range = ValueRange.of(x-100,x-50);
        //System.out.println(player.getLeftHandY()+"      "+s.getPosition().y);
        return range.isValidValue(s.getPosition().x)   &&    this.getLeftHandY()-s.getPosition().y==0;
        
    }

    boolean withinRightRange(Shape s) {
        int x = (int) this.getxAxis();
        ValueRange range = ValueRange.of(x+50,x+100);
       // System.out.println(player.getRightHandY()+"      "+s.getPosition().y);
        return range.isValidValue(s.getPosition().x)   &&    this.getRightHandY()-s.getPosition().y==0;
    }
    
    
    public void update() {

        for (int i = 0; i < ShapePool.getInstance().getUsedShapes()
                .size(); i++) {
            Shape s = ShapePool.getInstance().getUsedShapes().get(i);
                if (withinLeftRange(s)){
                    this.addToStack1(s);
                    System.out.println("left");
                ShapePool.getInstance().getUsedShapes().remove(i);
                this.incLeftHandY();
                }
                else if (withinRightRange(s)){
                    this.addToStack2(s);
                    ShapePool.getInstance().getUsedShapes().remove(i);
                    System.out.println("right");
                    this.incRightHandY();
                }
            }
        
        checkColor(this.getStack1(), this ,1);
        checkColor(this.getStack2(), this, 2);

    }
    
}
