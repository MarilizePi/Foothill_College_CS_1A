//Marilize Pires
//section 2 - Assignment 1
//2017 Fall Quarter

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;

class RobotAroundTheBox extends Robot

{
	RobotAroundTheBox(City c, int st, int ave, Direction dir)
	{
		super(c, st, ave, dir);
	}
	public void turnRight()
	{
		this.turnLeft();
		this.turnLeft();
		this.turnLeft();
	}
	public void walkBox()
	{
		this.move();
		this.move();
		this.move();
	}
	
	}


public class Starting_Template extends Object
{
	public static void main(String[] args)
	{
		City seattle = new City();
		RobotAroundTheBox gretel = new RobotAroundTheBox(seattle, 1, 1,Direction.EAST);
		
		new Wall(seattle, 2, 1,Direction.WEST);
		new Wall(seattle, 2, 1,Direction.NORTH);
		new Wall(seattle, 2, 2,Direction.NORTH);
		new Wall(seattle, 2, 2,Direction.EAST);
		new Wall(seattle, 3, 2,Direction.SOUTH);
		new Wall(seattle, 3, 2,Direction.EAST);
		new Wall(seattle, 3, 1,Direction.SOUTH);
		new Wall(seattle, 3, 1,Direction.WEST);
		
		
		gretel.move();
		gretel.move();
		gretel.turnRight();
		gretel.walkBox();
		gretel.turnRight();
		gretel.walkBox();
		gretel.turnRight();
		gretel.walkBox();
		gretel.turnRight();
		gretel.move();
		
	} 
}