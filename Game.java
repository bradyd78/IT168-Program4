/*
 * Created on: Mar 13, 2023
 *
 * ULID: badavi4
 * Class: IT 168 
 */
package edu.ilstu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * IT179 Chutes and Ladders
 *
 * @author <Brady Davidson>
 *
 */
public class Game
{
	// Create Variables
	private Square start;
	private ArrayList<Square> board;
	private Integer currentPlayer;
	private Random ranNum = new Random();;
	private Square position;

	// Game Constructor Generates board
	public Game(int players)
	{
		// Board length and Jump Value for each square
		int jumpVal;
		start = new Square(1, 0, null);
		Square prev = start;
		ArrayList<Integer> list = new ArrayList<Integer>(players);
		board = new ArrayList<Square>(100);

		// for loop that will create the board
		for (int i = 2; i < 100; i++)
		{
			int zeroChance = ranNum.nextInt(4);
			if (zeroChance == 0)
			{
				jumpVal = ranNum.nextInt(201 - i) - 100;
			} else
			{
				jumpVal = 0;
			}
			Square square = new Square(i, jumpVal, prev);
			prev.setNext(square);
			prev = square;
			board.add(square);
		}
		for (int i = 0; i < players; i++)
		{
			board.add(i, start);
		}
		currentPlayer = 0;

	}

	// move method that moves the player along the board
	public boolean move(int currentPlayer, int moveNum)
	{

		if (moveNum - position.getSquareNumber() < 100 - position.getSquareNumber())
		{
			if (position.next == null)
			{
				return true;
			}
			for (int i = 0; i < moveNum; i++)
			{
				if (position.getNext() != null)
					position = position.getNext();

			}
			moveNum += position.getJumpVal();
			// System.out.println(moveNum);
			System.out
					.println("Jump Value: " + position.getJumpVal() + "\nSquare Number: " + position.getSquareNumber());
		} else
		{
			return true;
		}
		return false;
	}

	// play method that calls the move method
	public void play(int player)
	{
		currentPlayer = player;
		Random random = new Random();
		Scanner input = new Scanner(System.in);
		int dice;
		System.out.println("Press any key to roll dice");
		input.next();
		position = start;
		dice = random.nextInt(6) + 1;
		while (!move(currentPlayer, dice + position.getSquareNumber()))
		{
			System.out.println("You rolled a " + dice + ", move " + dice + " spaces.");
			System.out.println("Press any key to roll dice");
			input.next();
			dice = random.nextInt(6) + 1;
		}
		if (move(currentPlayer, dice + position.getSquareNumber()) == true)
		{
			System.out.println("We have a winner!");
			currentPlayer++;
		}

	}

	// Square class that is used for linked list
	private static class Square
	{
		// References and Square number and jump value
		private Square prev;
		private Square next;
		private int squareNumber;
		private int jumpVal;

		public Square(int squareNumber, int jumpVal, Square prev)
		{
			this.squareNumber = squareNumber;
			this.jumpVal = jumpVal;
			this.prev = prev;

		}
		// Below are the getters and Setters

		public Square getPrev()
		{
			return prev;
		}

		public void setPrev(Square prev)
		{
			this.prev = prev;
		}

		public Square getNext()
		{
			return next;
		}

		public void setNext(Square next)
		{
			this.next = next;
		}

		public int getSquareNumber()
		{
			return squareNumber;
		}

		public void setSquareNumber(int squareNumber)
		{
			this.squareNumber = squareNumber;
		}

		public int getJumpVal()
		{
			return jumpVal;
		}

		public void setJumpVal(int jumpVal)
		{
			this.jumpVal = jumpVal;
		}

	}

}
