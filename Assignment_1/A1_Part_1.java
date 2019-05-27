//Marilize Pires
//section 2 - Assignment 1
//2017 Fall Quarter
import becker.robots.*;

class RobotPipeCleaning extends Robot

{
	RobotPipeCleaning(City c, int st, int ave, Direction dir, int num)
	{
		super(c, st, ave, dir, num);
	}
	public void SuperWalk()
	{
		this.move();
		this.move();
		this.move();
		this.move();
		this.move();
		this.move();
		this.move();
		this.move();
	}
	public void turnRIght()
	{
		this.turnLeft();
		this.turnLeft();
		this.turnLeft();
	}
	public void turnAround()
	{
		this.turnLeft();
		this.turnLeft();
	}
}


public class A1_Part_1 extends Object
{
    public static void main(String[] args)
    { 
        City theCity= new City( 11, 5); // 11 means "show me 11 streets - streets 0, 1, ..., 9, 10"
										// 5 means "show me 5 avenues - avenues 0, 1, 2, 3, 4
        RobotPipeCleaning karel = new RobotPipeCleaning(theCity, 9, 1, Direction.NORTH, 0);
        new Thing(theCity, 1, 1);
        new Thing(theCity, 9, 2);
        
		// the 'backstop' for the robot:
        new Wall(theCity, 9, 1, Direction.SOUTH);

		// First build the west-most pipe
        // The west edge of the west-most pipe:
        new Wall(theCity, 1, 1, Direction.WEST);
        new Wall(theCity, 2, 1, Direction.WEST);
        new Wall(theCity, 3, 1, Direction.WEST);
        new Wall(theCity, 4, 1, Direction.WEST);
        new Wall(theCity, 5, 1, Direction.WEST);
        new Wall(theCity, 6, 1, Direction.WEST);
        new Wall(theCity, 7, 1, Direction.WEST);
        new Wall(theCity, 8, 1, Direction.WEST);
        new Wall(theCity, 9, 1, Direction.WEST);

        // The east edge of the west-most pipe:
        new Wall(theCity, 2, 1, Direction.EAST);
        new Wall(theCity, 3, 1, Direction.EAST);
        new Wall(theCity, 4, 1, Direction.EAST);
        new Wall(theCity, 5, 1, Direction.EAST);
        new Wall(theCity, 6, 1, Direction.EAST);
        new Wall(theCity, 7, 1, Direction.EAST);
        new Wall(theCity, 8, 1, Direction.EAST);
        new Wall(theCity, 9, 1, Direction.EAST);
		
		// the 'cap' at the top
        new Wall(theCity, 1, 1, Direction.NORTH);
        new Wall(theCity, 1, 2, Direction.NORTH);
        new Wall(theCity, 1, 2, Direction.EAST);
		
        // The west edge of the east-most pipe
        new Wall(theCity, 2, 2, Direction.WEST);
        new Wall(theCity, 3, 2, Direction.WEST);
        new Wall(theCity, 4, 2, Direction.WEST);
        new Wall(theCity, 5, 2, Direction.WEST);
        new Wall(theCity, 6, 2, Direction.WEST);
        new Wall(theCity, 7, 2, Direction.WEST);
        new Wall(theCity, 8, 2, Direction.WEST);
        new Wall(theCity, 9, 2, Direction.WEST);

		// The east edge of the east-most pipe
        new Wall(theCity, 1, 2, Direction.EAST);
        new Wall(theCity, 2, 2, Direction.EAST);
        new Wall(theCity, 3, 2, Direction.EAST);
        new Wall(theCity, 4, 2, Direction.EAST);
        new Wall(theCity, 5, 2, Direction.EAST);
        new Wall(theCity, 6, 2, Direction.EAST);
        new Wall(theCity, 7, 2, Direction.EAST);
        new Wall(theCity, 8, 2, Direction.EAST);
        new Wall(theCity, 9, 2, Direction.EAST);


		// that final stopping wall
        new Wall(theCity, 9, 2, Direction.SOUTH);

        karel.SuperWalk();
        karel.pickThing();
        karel.turnRIght();
        karel.move();
        karel.turnRIght();
        karel.SuperWalk();
        karel.pickThing();
        karel.turnAround();
        karel.SuperWalk();
        karel.turnLeft();
        karel.move();
        karel.turnLeft();
        karel.SuperWalk();
        karel.turnAround();
        karel.putThing();
        karel.move();
        karel.putThing();
        karel.move();
        
        
        
    }
}
