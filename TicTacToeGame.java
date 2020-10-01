package com.cg.tictactoe;

import java.util.Scanner;

public class TicTacToeGame 
{
	static Scanner scanner = new Scanner(System.in);
	public static final int Size = 10;
	public static char[] board = new char[Size];
	public static final int heads=0;
	public static final int tails=1;
	public static final int won=1;
	public static final int tie=0;
	/**
	 * Initialised new board
	 */
	public static void createBoard() 
	{
		for (int index = 0; index < Size; index++) 
		{
			board[index] = ' ';
		}
		System.out.println("Board initialised");
	}

	/**
	 * Choosing option
	 */
	public static char playerInputs() 
	{
		System.out.println("Choose X or O");
		return Character.toUpperCase(scanner.next().charAt(0));
	}

	/**
	 * Printing board
	 */
	public static void showBoard()
	{
		System.out.println(board[1] + "|" +board[2]+"|"+board[3]);
		System.out.println(board[4] + "|" +board[5]+"|"+board[6]);
		System.out.println(board[7] + "|" +board[8]+"|"+board[9]);
	}
	
	/**
	 * selecting option to place X or O
	 */
	public static void selectPlace (char option,String check)
	{
		System.out.println("Enter any position from 1-9");
		int index;
		if(check=="computer")
		{
			index=(int)Math.floor(Math.random()*10);
		}
		else
		{
			index = scanner.nextInt();	
		}
		if(isFree(index) && (index<=9 || index>0))
		{
			board[index]=option;
			System.out.println("Added");	
		}
		else if(index > 9 || index < 1)
		{
			System.out.println("Invalid index");
		    selectPlace(option,check);
		}
		else
		{	
			System.out.println("Position already filled, Choose another option");
		    selectPlace(option,check);
		}   
	}	
	
	/**
	 * checking if the index is free or not
	 */
	public static boolean isFree(int index)
	{
	 	return board[index] == ' '; 
	}
	
	/**
	 * tossing to start
	 */
	public static int toss()
	{
		int toss=(int)Math.floor(Math.random()*2);
		return toss;
	}
	
	/**
	 * conditions for winning or tie
	 */
	public static int hasWon()
	{
		if(board[1] == board[5] && board[5]==board[9])
		{
			return 1;
		}
		else if (board[1] == board[4] && board[4]==board[7])
		{
			return 1;
		}
		else if (board[3] == board[6] && board[6]==board[9])
		{
			return 1;
		}
		else if (board[3] == board[5] && board[5]==board[7])
		{
			return 1;
		}
		else if (board[4] == board[5] && board[5]==board[6])
		{
			return 1;
		}
		else if (board[1] == board[2] && board[2]==board[3])
		{
			return 1;
		}
		else if (board[7] == board[8] && board[8]==board[9])
		{
			return 1;
		}
		else if (board[2] == board[5] && board[5]==board[8])
		{
			return 1;
		}
		else 	
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
		int toss=toss();
		if(toss==heads)
		{
			System.out.println("Player won the toss, starting the game");
			selectPlace(player,"player");
		}
		else
		{	
			System.out.println("Computer won the toss, starting the game");
		    selectPlace(computer,"computer");
		}   
		showBoard();			
	}
}
