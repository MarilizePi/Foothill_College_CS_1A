// Assignment 4 ADVANCED: Guessing Game
// The 'MAIN' File

public class Game_Program extends Object
{    
    public static void main(String[] args)
    {  
		GuessingGame gg = new GuessingGame(); 	// feel free to add arguments to the constructor, if it helps...

		//int choice = 1;
		//while( choice == 1 )
		//{
			
			gg.Welcome();
			gg.getRandomNumber();
			gg.isGuessNum();
			// Do whatever else you need to in order to figure out if the game should be played again.
         // Example: you might have something being returned from the PlayGuessingGame() method in
         // the methods file, so you will have a variable capture that return (e.g., choice) and
         // do something with it (e.g., if choice == 0 then show a message and quit the game)
		//}
    }
}
