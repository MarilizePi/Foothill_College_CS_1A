
//Marilize Pires
//section 3 - Assignment 2
//2017 Fall Quarter

import becker.robots.*;
import java.util.Random;

class Mari extends Robot {
	// Constructor
	Mari(City c, int st, int ave, Direction dir, int numThings) {
		super(c, st, ave, dir, numThings);
	}

	public void turnAround() // method created in order to make the robot turn around.
	{
		this.turnLeft();
		this.turnLeft();
	}

	public void turnRight() // This method is to help the next lines of code, once it wont be need to type
							// turnLeft() three times again.
	{
		this.turnAround();
		this.turnLeft();
	}

	public void moveToWall() // This will allow the robot to move more than one street at once, until the
								// robot encounters a wall.
	{
		while (this.frontIsClear()) {
			move();
		}
	}

	public void goHome() {
		this.turnAround();
		this.moveToWall();
		this.turnRight();
		this.moveToWall();
		this.turnRight();
	}

	public void doEverything() // this will put all the commands together and move the robot, from the start to
								// the end point.
	{
		int counter = 0;
		while (counter < 4) {
			this.moveToWall();
			this.pickThing();
			this.turnAround();
			this.moveToWall();
			this.turnLeft();
			this.move();
			this.turnLeft();
			counter++;
		}

		while (!(this.countThingsInBackpack() == 0)) {
			this.move();
			this.putThing();
		}
		// this will have the robot move and drop a thing after every move until he has
		// 0 things in his backpack

		this.goHome();
		// here he will move back to his original position

	}

}

public class A2_Part_3 extends Object {
	public static void main(String[] args) {
		City wallville = new City(6, 12);
		Mari rob = new Mari(wallville, 1, 2, Direction.EAST, 0);

		A2_Part_3.BuildCity(wallville);

		rob.doEverything();

	}
	// this jumps down to the "BuildCity" routine, below

	// * * * --> Your code to race around the race track goes here <-- * * *

	// HINT: Several while loops would work well for this particular exercise.
	// One possible solution would be to start with a while loop (for checking the
	// count)
	// that contains two nested while loops used to check whether the front is clear
	// before performing some actions. Jumping through this initial while loop might
	// use additional while loops to continue checking whether the front is clear
	// before performing other actions in order to complete the tasks of the maze.

	/////////////////////////////////////////////////////////////////////////////////////////
	// No need to touch any of the code below. All it does is construct the maze in
	///////////////////////////////////////////////////////////////////////////////////////// the
	///////////////////////////////////////////////////////////////////////////////////////// city
	/////////////////////////////////////////////////////////////////////////////////////////
	public static void BuildCity(City wallville) {
		// Width and height must be at least 2 (each)
		// Feel free to change these numbers, and see how your racetrack changes

		Random r = new Random();
		int top = 1;
		int left = 2;
		int height = 4;
		int width = 7 + r.nextInt(4);

		int streetNumber = top;
		while (streetNumber <= height) {
			if (streetNumber == 1) {
				// the topmost line:
				new Wall(wallville, streetNumber, left, Direction.NORTH);
			} else if (streetNumber == height) {
				// generate the 'holding spot' thing at the bottom:

				// the corner:
				new Wall(wallville, streetNumber + 1, left, Direction.WEST);
				new Wall(wallville, streetNumber + 1, left, Direction.SOUTH);
				int spotNum = left + 1;
				int counter = 0;
				while (counter < height) {
					new Wall(wallville, streetNumber + 1, spotNum, Direction.NORTH);
					new Wall(wallville, streetNumber + 1, spotNum, Direction.SOUTH);
					// Uncomment the next line for a 'final state' picture (i.e., the second picture
					// in the assignment)
					// new Thing(wallville, streetNumber+1, spotNum);
					spotNum = spotNum + 1;
					counter = counter + 1;
				}
				new Wall(wallville, streetNumber + 1, spotNum, Direction.WEST);
			}

			// the west-most, vertical line:
			new Wall(wallville, streetNumber, left, Direction.WEST);
			// the east-most, vertical line:
			new Wall(wallville, streetNumber, width, Direction.EAST);
			// the Thing at the end of the tunnel
			new Thing(wallville, streetNumber, width);

			int aveNum = left + 1;
			while (aveNum <= width) {
				new Wall(wallville, streetNumber, aveNum, Direction.NORTH);
				new Wall(wallville, streetNumber, aveNum, Direction.SOUTH);
				aveNum = aveNum + 1;
			}

			streetNumber = streetNumber + 1;
		}
	}
}