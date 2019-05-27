import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

public class A4_Trace_Basic extends Object
{
    public static void main(String[] args)
    {
        	System.out.println("THE PROGRAM STARTS HERE!!");

			int counter = 0;

        	City seattle = new City();
        	Robot mary = new Robot(seattle, 1, 1, Direction.EAST, 200);
			
			int howManyThingsToDrop[] = new int[3];
			howManyThingsToDrop[0] = 1;
			howManyThingsToDrop[1] = 0;
			howManyThingsToDrop[counter + 2] = 3;
    
	 		// When tracing through a for loop, put each part in a separate
			// row of the trace (so it's clear when you're doing the 
			// initialization (int i = 0), or the check (i < howManyThingsToDrop.length)
			// or the update (++i)
	 		for(int i = 0;
				 i < howManyThingsToDrop.length;
				 ++i)
			{
				System.out.println("Element "+ i + " in howManyThingsToDrop is: " + howManyThingsToDrop[i] );
			}

	 		for(counter = 0
				; counter < howManyThingsToDrop.length
				;counter++)
			{
			   System.out.println("Step #:" + counter);
				
				if( howManyThingsToDrop[counter] == 0) 
				{
					System.out.println("\tDropping NO things at step #"+counter);
				}	// the special \t means "move in 1 tab stop"

				for( int thingsDroppedThisTime = 0; 
						thingsDroppedThisTime < howManyThingsToDrop[counter] ; 
						++thingsDroppedThisTime)
				{
					System.out.println("\tDropping thing #" + thingsDroppedThisTime + " at step #"+counter);
					mary.putThing();
					mary.move();
				}
				mary.move();
			}
	 				
        	System.out.println ("THE PROGRAM ENDS HERE!!");
    }
}
// 