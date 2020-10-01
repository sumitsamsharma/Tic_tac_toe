package com.cg.tictactoe;

import java.util.Scanner;

public class TicTacToeGame 
{
	public static final int Size=10;
	/**
	 * Initialised new board
	 */
	public static void CreateBoard() 
	{
	   char[] board = new char[Size];
	   for(int index=0;index<Size;index++)
	   {
		   board[index]=' ';
	   }
	   System.out.println("Board initialised");
	}
	
	public static char PlayerInputs()
	{
		System.out.println("Choose X or O");
		Scanner sc = new Scanner(System.in);
		char chosen = sc.next().charAt(0); 
		return chosen;
	}
	
	public static void main(String[] args)
	{
	   System.out.println("Welcome to Tic Tac Toe game ");
	   CreateBoard();
	   char option=PlayerInputs();
	   System.out.println("Player 1 choose: "+option);
	   System.out.println("Computer choose: O");   
	}
}
