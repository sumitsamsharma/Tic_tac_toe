package com.cg.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	static Scanner scanner = new Scanner(System.in);
	public static final int Size = 10;
	public static char[] board = new char[Size];
	public static final int heads = 0;
	public static final int tails = 1;
	public static int won = 0;
	public static final int tie = 0;

	/**
	 * Initialised new board
	 */
	public static void createBoard() {
		for (int index = 0; index < Size; index++) {
			board[index] = ' ';
		}
		System.out.println("Board initialised");
	}

	/**
	 * Choosing option
	 */
	public static char playerInputs() {
		System.out.println("Choose X or O");
		return Character.toUpperCase(scanner.next().charAt(0));
	}

	/**
	 * Printing board
	 */
	public static void showBoard() {
		System.out.println(board[1] + "|" + board[2] + "|" + board[3]);
		System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
		System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
	}

	/**
	 * selecting option to place X or O
	 */
	public static void selectPlace(char option, String check) {
		System.out.println("Enter any position from 1-9");
		int index;
		if (check == "computer") {
			index = (int) Math.floor(Math.random() * 10);
			System.out.println("Computer chose " + index);
		} 
		else 
		{
			index = scanner.nextInt();
		}
		if (isFree(index) && (index <= 9 && index > 0)) {
			board[index] = option;
			System.out.println("Added");
		} else if (index > 9 || index < 1) {
			System.out.println("Invalid index");
			selectPlace(option, check);
		} else {
			System.out.println("Position already filled, Choose another option");
			selectPlace(option, check);
		}
	}

	/**
	 * checking if the index is free or not
	 */
	public static boolean isFree(int index) {
		return board[index] == ' ';
	}

	/**
	 * tossing to start
	 */
	public static int toss() {
		int toss = (int) Math.floor(Math.random() * 2);
		return toss;
	}

	/**
	 * conditions for winning or tie
	 */
	public static int hasWon(char place) {
		if (board[1] == place && board[5] == place && board[9] == place) {
			return 1;
		} else if (board[1] == place && board[7] == place && board[4] == place) {
			return 1;
		} else if (board[3] == place && board[6] == place && board[9] == place) {
			return 1;
		} else if (board[3] == place && board[5] == place && board[7] == place) {
			return 1;
		} else if (board[4] == place && board[5] == place && board[6] == place) {
			return 1;
		} else if (board[1] == place && board[2] == place && board[3] == place) {
			return 1;
		} else if (board[7] == place && board[8] == place && board[9] == place) {
			return 1;
		} else if (board[2] == place && board[5] == place && board[8] == place) {
			return 1;
		} else
			return 0;
	}

	/**
	 * checking winning moves
	 */
	public static int suggestMove(char computer) {
		if ((board[1] == computer && board[5] == computer) || (board[3] == computer && board[6] == computer)
				|| (board[7] == computer && board[8] == computer)) {
			if (isFree(9)) {
				return 9;
			}
		} else if ((board[2] == computer && board[5] == computer) || (board[7] == computer && board[9] == computer)) {
			if (isFree(8)) {
				return 8;
			}
		} else if ((board[1] == computer && board[4] == computer) || (board[3] == computer && board[5] == computer)
				|| (board[8] == computer && board[9] == computer)) {
			if (isFree(7)) {
				return 7;
			}
		} else if ((board[3] == computer && board[9] == computer) || (board[4] == computer && board[5] == computer)) {
			if (isFree(6)) {
				return 6;
			}
		} else if ((board[2] == computer && board[8] == computer) || (board[4] == computer && board[6] == computer)
				|| (board[1] == computer && board[9] == computer)) {
			if (isFree(5)) {
				return 5;
			}
		} else if ((board[1] == computer && board[7] == computer) || (board[5] == computer && board[6] == computer)) {
			if (isFree(4)) {
				return 4;
			}
		} else if ((board[6] == computer && board[9] == computer) || (board[1] == computer && board[2] == computer)
				|| (board[5] == computer && board[7] == computer)) {
			if (isFree(3)) {
				return 3;
			}
		} else if ((board[5] == computer && board[8] == computer) || (board[1] == computer && board[3] == computer)) {
			if (isFree(2)) {
				return 2;
			}
		} else if ((board[2] == computer && board[3] == computer) || (board[4] == computer && board[7] == computer)
				|| (board[5] == computer && board[9] == computer)) {
			if (isFree(1)) {
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) 
	{
		System.out.println("Welcome to Tic Tac Toe game ");
		createBoard();
		char player = playerInputs();
		char computer = (player == 'X') ? 'O' : 'X';
		System.out.println("Player chose: " + player + " Computer chose: " + computer);
		showBoard();
		int playerCount=0;
		int computerCount=0;
		int toss=toss();
	    if(toss==heads)
	    {
	    	System.out.println("Player won the toss, starting the game");
	    	while(won!=1)
		    {
		       if(playerCount<2)
		       {
		    	  selectPlace(player,"player");
		          playerCount++;
		          showBoard();
		       }
		       else
		       {
		    	   selectPlace(player,"player");
		    	   won=hasWon(player);
		    	   showBoard();
		    	   if(won==1)
		    	   {
		    		   System.out.println("Player Won the game");
		    		   showBoard();
		    		   break;
		    	   }
		       }
		       if(computerCount<2)
		       {
		          selectPlace(computer,"computer");
		          computerCount++;
		          showBoard();
		       }
		       else
		       {
		    	   int pos=suggestMove(computer);
		    	   board[pos]=computer;
		    	   won=hasWon(computer);
		    	   System.out.println("Checking if computer can win move");
		    	   if(won==1)
		    	   {
		    		   System.out.println("Computer Won");
		    		   board[pos]=computer;
		    		   showBoard();
		    	   }
		    	   else
		    	   {   
		    		  pos=suggestMove(player);
		    		  board[pos]=player;
		    	      won=hasWon(player);
		    	      if(won==1)
		    	      {
		    		      System.out.println("Player is winning");
		    		      board[pos]=computer;
		    		      showBoard();
		    		      break;
		    	      }
		    	      board[pos]=player;
		    	      showBoard();
		    	   }  
		       }
		    }
	    }	
		       
	      else
	    {	
	    	  System.out.println("Computer won the toss, starting the game");
	    	  while(won!=1)
			    {
		            if(computerCount<2)
		           {
		              selectPlace(computer,"computer");
		              computerCount++;
		              showBoard();
		           }
		           else
		          {   
		        	  int pos=suggestMove(computer);
		    	      board[pos]=computer;
		    	      won=hasWon(computer);
		    	      System.out.println("Checking if computer can win move");
		    	      if(won==1)
		    	     {
		    		   System.out.println("Computer Won");
		    		   board[pos]=computer;
		    		   showBoard();
		    		   break;
		    	     }
		    	     else
		    	     {   
		    		   pos=suggestMove(player);
		    		   board[pos]=player;
		    	       won=hasWon(player);
		    	       if(won==1)
		    	       {
		    		      System.out.println("Player is winning");
		    		      board[pos]=computer;
		    		      showBoard();
		    	       }
		    	       board[pos]=computer;
		    	       showBoard();
		    	     }  
		           }
		           if(playerCount<2)
		          {
		    	     selectPlace(player,"player");
		             playerCount++;
		             showBoard();
		          }
		          else
		          {
		    	    selectPlace(player,"player");
		    	    won=hasWon(player);
		    	    showBoard();
		    	    if(won==1)
		    	    {
		    		   System.out.println("Player Won the game");
		    		   showBoard();
		    		   break;
		    	    }
		          }
	            }   
	       }					
	}
}
