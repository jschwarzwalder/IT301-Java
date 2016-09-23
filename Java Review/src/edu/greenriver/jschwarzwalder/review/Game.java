package edu.greenriver.jschwarzwalder.review;

public class Game {
    public void playGame() {
        //display a menu of options to the user
    	ConsoleHelper.print("1. Flip a coin!");
    	ConsoleHelper.print("2. View previous coin flips");
    	ConsoleHelper.print("3. exit");

        //get the user's choice
        int choice = ConsoleHelper.getInt("");
        ConsoleHelper.print("Your choice was "+ choice);

        //flip coins
        
        flipCoins();


    }

    public void flipCoins() {
        Randomness random = new Randomness();

        ConsoleHelper.print(Randomness.flipACoin());
    }

}
