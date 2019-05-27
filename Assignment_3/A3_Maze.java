//CS1A - Assignment 3 - "The Maze"
//2017 Fall Quarter

import becker.robots.*;

//some default comments were removed in order to make the program more comprehensible. 
class MazeBot extends RobotSE {
	public MazeBot(City theCity, int str, int ave, Direction dir, int numThings, int numMoves) {
		super(theCity, str, ave, dir, numThings);
	}

	private int totalMoves;
	private int moveNorth;
	private int moveSouth;
	private int moveEast;
	private int moveWest;
	private int putthings;

	public void moveRobot() { // robot will move by turning right and left.
		if (frontIsClear()) {
			turnRight();
			turnLeft();
		}
		while (!frontIsClear()) { // if the front is not clear, robot will turn right.
			turnRight();
		}
		if (countThingsInBackpack() > 0) { // if robot has more than zero things in his backpack, he will drop a thing.
			if (!canPickThing()) {// check if there is no thing in that intersection before dropping. Otherwise it
									// won't drop the thing.
				putThing();
				putthings++;
			}
		}
		move();
	}

	public void checkClear() { // check for turning.
		while (getDirection() != getDirection()) {
			turnLeft();
		}
		turnLeft();
	}

	private boolean isAtEndSpot() { // when the robot reaches the end spot (9,10), it will stop moving.
		return getAvenue() == 9 && getStreet() == 10;
	}

	public void navigateMaze() {

		while (!isAtEndSpot()) { // this method keeps the count of total moves plus each direction.
			totalMoves++;
			Direction face = getDirection();
			switch (face) {
			case EAST:
				moveEast++;
				break;
			case WEST:
				moveWest++;
				break;
			case SOUTH:
				moveSouth++;
				break;
			case NORTH:
				moveNorth++;
			}

			moveRobot();
			checkClear();
		}
	}

	public void printEverything() { // it will print the total number of moves according the robot's direction.
		System.out.println("The total number of spaces moved is: " + totalMoves);
		System.out.println("The total number of spaces moved East is: " + moveNorth);
		System.out.println("The total number of spaces moved South is: " + moveSouth);
		System.out.println("The total number of spaces moved West is: " + moveEast);
		System.out.println("The total number of spaces moved North is: " + moveWest);
	}

}

public class Maze extends Object {
	private static void makeMaze(City theCity) {
		for (int i = 1; i < 11; i++) {
			// north wall
			new Wall(theCity, 1, i, Direction.NORTH);

			// Second to north wall
			if (i <= 9)
				new Wall(theCity, 1, i, Direction.SOUTH);

			// Third to north wall
			if (i >= 4)
				new Wall(theCity, 4, i, Direction.SOUTH);

			// south wall
			if (i != 9) // (9, 10, SOUTH), is where the 'exit' is
				new Wall(theCity, 10, i, Direction.SOUTH);

			// west wall
			if (i != 1) // (1,1, WEST) is where the 'entrance' is
				new Wall(theCity, i, 1, Direction.WEST);

			// second to west-most wall
			if (i >= 3 && i < 6)
				new Wall(theCity, i, 6, Direction.WEST);

			// east wall
			new Wall(theCity, i, 10, Direction.EAST);
		}

		// cul-de-sac
		new Wall(theCity, 3, 10, Direction.WEST);
		new Wall(theCity, 3, 10, Direction.SOUTH);
		new Wall(theCity, 3, 3, Direction.EAST);
		new Wall(theCity, 4, 3, Direction.EAST);
		new Wall(theCity, 4, 3, Direction.SOUTH);
		new Wall(theCity, 2, 8, Direction.WEST);
		new Wall(theCity, 2, 8, Direction.SOUTH);

		new Wall(theCity, 10, 8, Direction.NORTH);
		new Wall(theCity, 10, 9, Direction.EAST);
		new Wall(theCity, 10, 9, Direction.NORTH);
		makeSpiral(theCity, 8, 9, 3);
		new Wall(theCity, 8, 10, Direction.SOUTH);

		makeSpiral(theCity, 10, 5, 4);
	}

	public static void makeSpiral(City theCity, int st, int ave, int size) {
		// We start out building the wall northward
		// the walls will be built on the east face of the current
		// intersection
		Direction facing = Direction.EAST;

		while (size > 0) {
			int spacesLeft = size;
			int aveChange = 0;
			int stChange = 0;
			switch (facing) {
			case EAST:
				stChange = -1;
				break;
			case NORTH:
				aveChange = -1;
				break;
			case WEST:
				stChange = 1;
				break;
			case SOUTH:
				aveChange = 1;
				break;
			}

			while (spacesLeft > 0) {
				new Wall(theCity, st, ave, facing);
				ave += aveChange;
				st += stChange;
				--spacesLeft;
			}
			// back up one space
			ave -= aveChange;
			st -= stChange;

			switch (facing) {
			case EAST:
				facing = Direction.NORTH;
				break;
			case NORTH:
				facing = Direction.WEST;
				size--;
				break;
			case WEST:
				facing = Direction.SOUTH;
				break;
			case SOUTH:
				facing = Direction.EAST;
				size--;
				break;
			}
		}
	}

	public static void main(String[] args) {
		City calgary = new City(12, 12);
		MazeBot Fofo = new MazeBot(calgary, 1, 1, Direction.EAST, 1000, 0);

		Maze.makeMaze(calgary);

		int RobotStreet;
		int RobotAvenue;
		RobotStreet = Fofo.getStreet();
		RobotAvenue = Fofo.getAvenue();

		for (RobotStreet = 1; RobotStreet <= 10; RobotStreet++) { // for every street, move to 10 avenues.
			for (RobotAvenue = 1; RobotAvenue <= 10; RobotAvenue++) {
				Fofo.navigateMaze();
			}
		}

		Fofo.printEverything(); // finally printing on the system count of moves.

	}
}
