package com.tictactoe.main;

import java.util.Scanner;

import com.tictactoe.game.Board;
import com.tictactoe.game.Player;

public class Runner {

	//Main method of the program
	public static void main(String[] args){
		Board board = new Board();
		String winner = playGame(board);
		printBoard(board);
		printWinner(winner);
	}
	
	/**
	 * The code that runs the game logic
	 * @param board
	 * 				the board to play one
	 * @return	name of the winner
	 */
	
	private static String playGame(Board board){
		
		//Creates the two player objects
		Player playerX = new Player('X', board);
		Player playerO = new Player('0', board);
		
		Scanner in = new Scanner(System.in);
		
		//Sets up the required variables to maintain game logic
		Player currPlayer;
		int turnCount = 0;
		int play;
		boolean hasWon = false;
		String winner = "Tie";
		
		boolean keepPlaying = true;
		//while keep playing is true, we continue to do a while loop
		//check for who the player is and asks for user input
		//calls on player's makeplay method to mark a cell
		//makeplay returns a boolean that states whether the move was a winning move
		while(keepPlaying){
			printBoard(board);
			turnCount++;
			
			if(turnCount % 2 == 0){
				currPlayer = playerO;
			} else {
				currPlayer = playerX;
			}
			
			System.out.print(currPlayer.getName() + ", make a move (1-9) ");
			play = in.nextInt();
			
			hasWon = currPlayer.makePlay(Player.cells[play-1]);
			
			if(hasWon){
				winner = currPlayer.getName();
				keepPlaying = false;
			}
			if(turnCount == 9){
				keepPlaying = false;
			}
		}
		
		return winner;
	}
	
	/**
	 *  Prints out the current state of the board
	 * @param board board we are playing on
	 * 
	 */
	private static void printBoard(Board board) {
		
		// These are for loops. They start at a designated number and keep looping
		// until  a condition is met. These loop through These loops go through each
		// row of the board, then  go through each cell in that row.
		for (int row = 0; row < board.getRowCount(); row++) {
			for (int col = 0; col < board.getColumnCount(); col++) {
				
				// Prints out the contents of the current cell
				System.out.print(" " + board.getCellContents(row, col));
				
				// If this is not the last cell, bring a divider
				if (col < board.getColumnCount() - 1) {
					System.out.print(" |");
				}
			}
			
			// If this is not the last row, print a divider
			if (row < board.getRowCount() - 1) {
				System.out.println();
				System.out.println("------------");
			}
		}
		
		// Prints a line break
		System.out.println();
	}	
	
	/**
	 *  Prints out who the winner is
	 * @param winner
	 * 			Name of the winning player. If game is a tie then Tie is printed
	 */
	public static void printWinner(String winner){
		if(winner.equals("Tie")){
			System.out.println("It's a tie!");
		} else {
			System.out.println(winner + "won!");
		}
	}
}
