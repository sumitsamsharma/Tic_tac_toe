package com.cg.tictactoe;

import java.util.Scanner;

public class TicTacToeGame 
{
	static Scanner scanner = new Scanner(System.in);
	public static final int Size = 10;
	public static char[] board = new char[Size];

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
	public static void selectPlace (char option)
	{
		System.out.println("Enter any position from 1-9");
		int index = scanner.nextInt();
		if(index>9 || index<1)
		{
			System.out.println("Invalid position");
			selectPlace(option);
		}
		 else
		 {
			 if(isFree(index))
			 {
			    board[index]=option;
			 }
			 else
				 selectPlace(option);
		 }	
	}	
	
	public static boolean isFree(int index)
	{
	 	return board[index] == ' '; 
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Tic Tac Toe game ");
		createBoard();
		char player = playerInputs();
		char computer = (player == 'X') ? 'O' : 'X';
		System.out.println("Player chose: " + player + " Computer chose: " + computer);
		showBoard();
		selectPlace(player);
		showBoard();
	}
}
