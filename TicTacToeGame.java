package com.cg.tictactoe;

public class TicTacToeGame 
{
	public static final int Size=10;
	/**
	 * Initialised new board
	 */
	public static void CreateBoard() 
	{
	   char[] board = new char[Size];
	   for(int i=0;i<Size;i++)
	   {
		   board[i]=' ';
	   }
	   System.out.println("Board initialised");
	}
	
	public static void main(String[] args)
	{
	   System.out.println("Welcome to Tic Tac Toe game ");
	   CreateBoard();	     
	}
}