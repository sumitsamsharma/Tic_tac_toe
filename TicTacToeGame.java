package com.cg.tictactoe;

import java.util.Scanner;

public class TicTacToeGame 
{
	static Scanner scanner = new Scanner(System.in);
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
	
	/**
	 * Choosing option
	 */
	public static char PlayerInputs()
	{
		System.out.println("Choose X or O");
		char chosen = scanner.next().charAt(0); 
		return Character.toUpperCase(chosen);
	}
	
	public static void main(String[] args)
	{
	   System.out.println("Welcome to Tic Tac Toe game ");
	   CreateBoard();
	   char PlayerOption=PlayerInputs();
	   char ComputerOption= (PlayerOption=='X')?'O':'X';
	   System.out.println("Player chose: "+PlayerOption+" Computer chose: "+ComputerOption);
	}
}
