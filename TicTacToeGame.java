package com.cg.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	static Scanner scanner = new Scanner(System.in);
	public static final int Size = 10;

	/**
	 * Initialised new board
	 */
	public static void createBoard() {
		char[] board = new char[Size];
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

	public static void main(String[] args) 
	{
		System.out.println("Welcome to Tic Tac Toe game ");
		createBoard();
		char player = playerInputs();
		char computer = (player == 'X') ? 'O' : 'X';
		System.out.println("Player chose: " + player + " Computer chose: " + computer);
	}
}
