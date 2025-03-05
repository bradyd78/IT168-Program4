/*
 * Created on: Mar 28, 2023
 *
 * ULID: badavi4
 * Class: IT 168 
 */
package edu.ilstu;

import java.util.Scanner;

/**
 * <IT179 Chutes and Ladders>
 *
 * @author <Brady Davidson>
 *
 */
public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to Brady's Shoots and Ladders game! ");
		System.out.println("Enter the number of players:");
		int players = input.nextInt();

		Game g1 = new Game(players);
		// for loop used to get through all the players
		for (int i = 0; i < players; i++)
		{
			g1.play(i);

		}

	}

}
