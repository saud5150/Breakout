/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		setUp();
		
	}
	
private void setUp() {
	AddBricks();
	Paddle();
	addMouseListeners();
	Ball();
	
}
	private GRect Bricks;
private void AddBricks() {
	double x=WIDTH/NBRICK_ROWS;
	double y=BRICK_Y_OFFSET;
	
	for(int j=1; j<NBRICK_ROWS+1; j++) {
		x=WIDTH/NBRICK_ROWS;
		
		
		for(int i=0; i<NBRICKS_PER_ROW; i++) {
			GRect Bricks= new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
			add(Bricks);
			Bricks.setFilled(true);
			x=x+BRICK_WIDTH+BRICK_SEP;
			if (j==1 || j==2) {
				Bricks.setColor(Color.RED);
				
			}
			if (j==3 || j==4) {
				Bricks.setColor(Color.ORANGE);
				
			}
			if (j==5 || j==6) {
				Bricks.setColor(Color.YELLOW);
				
			}
			if (j==7 || j==8) {
				Bricks.setColor(Color.GREEN);
				
			}
			if (j==9 || j==10) {
				Bricks.setColor(Color.CYAN);
				
			}
		}
		
		y=y+BRICK_HEIGHT+BRICK_SEP;
	}
}
int Paddlex=WIDTH/2+PADDLE_WIDTH/2-4*BRICK_SEP;
int Paddley=HEIGHT-PADDLE_Y_OFFSET;
GRect Paddle= new GRect(Paddlex, Paddley, PADDLE_WIDTH, PADDLE_HEIGHT);
public void Paddle() {
	
	
	Paddle.setFilled(true);
	add(Paddle);
}
//private GRect Paddle;
public void mouseMoved(MouseEvent e) {
	
	if(e.getX()>WIDTH/NBRICK_ROWS+PADDLE_WIDTH/2 && e.getX()< WIDTH+PADDLE_WIDTH/2) {
		
	Paddle.setLocation(e.getX()-PADDLE_WIDTH/2,Paddley);
	}
	
}
double x=WIDTH/2+BALL_RADIUS/2;
//Both ball and Paddle are centered initially

private void Ball() {
	double y=HEIGHT/2;
	GOval Ball= new GOval(x, y, BALL_RADIUS, BALL_RADIUS);
	add(Ball);
	Ball.setFilled(true);
	vy=3.0;
	vx = rgen.nextDouble(1.0, 3.0); if (rgen.nextBoolean(0.5)) vx = -vx; 
	while (true) {
		Ball.move(vx,  vy);
		if (Ball.getX()>WIDTH || Ball.getX()<WIDTH/NBRICK_ROWS) {
			vx=-vx;
		}
		if (Ball.getY()>HEIGHT || Ball.getY()<BALL_RADIUS/2) {
			vy=-vy;
		}
		
		pause(10);
	}
}
private double vx, vy;
////////////SETUP COMPLETE///////////////////
private RandomGenerator rgen=RandomGenerator.getInstance();
}
