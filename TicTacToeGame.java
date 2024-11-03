import java.util.Scanner;
public class TicTacToeGame {

	public static boolean play = true; // controls the running of the main game
	public static boolean tie = false;
	public static boolean win = false;
	public static boolean x = false;
	public static boolean o = false;
	public static void main(String[] args) {
		int userRow = 0; // defining user and computer rows/columns
		int compRow = 0;
		int userCol = 0;
		int compCol = 0;
		Scanner input = new Scanner(System.in);
		int[][] grid = { { 0, 200, 600, 200 }, { 0, 400, 600, 400 }, { 200, 0, 200, 600 }, { 400, 0, 400, 600 } }; // creating grid and array
		char[][] array = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
		TicTacToeBoard board = new TicTacToeBoard(620, 720); // setting up board and X/O images
		board.defineBoard(grid);
		board.setBoard(array);
		board.setFiles("x.png", "o.png");
		System.out.println("\t\t\t\t\t\tWELCOME TO TIC TAC TOE!\n"); // instructions
		System.out.println("\t\t\t\tThe rules are as follows: You will be asked to choose a row. \n\t     Type the row number you would like to place your turn. Then type the column number when prompted.");
		System.out.println("\t\tYou cannot place your move on a box that is already filled/not within the grid, which is 3x3.");
		System.out.println("\t\t    First to get their 3 characters in a row horizontally, vertically, or diagonally, wins!\n");
		System.out.print("Enter the number of players: 1 / 2: ");
		int mode = input.nextInt();

		if (mode == 1) {
		while (play == true) { // running game until someone wins/draws
			System.out.print("Enter a row number where you would like to place your X on (1/2/3): "); // ask for row and column
			userRow = input.nextInt();
			System.out.print("Enter a column number where you would like to place your X on (1/2/3): ");
			userCol = input.nextInt();
			compRow = (int) (Math.random() * 3); // computer generated row and columns
			compCol = (int) (Math.random() * 3);
			while ((userRow <= 0 || userRow >= 4) || (userCol <= 0 || userCol >= 4)) { // if the user enters a value outside the array,
				System.out.println("ENTER A VALID ROW OR COLUMN!\n"); // ask the user to enter new values
				System.out.print("Enter a row number where you would like to place your X on (1/2/3): ");
				userRow = input.nextInt();
				System.out.print("Enter a column number where you would like to place your X on (1/2/3): ");
				userCol = input.nextInt();
			}
			if (array[userRow - 1][userCol - 1] != '-') { // if the user enters a taken spot, ask the user to enter new values
				while (array[userRow - 1][userCol - 1] != '-') { // and repeat until the user enters correct values
					System.out.println("SPACE TAKEN!\n");
					System.out.print("Enter a row number where you would like to place your X on (1/2/3): ");
					userRow = input.nextInt();
					System.out.print("Enter a column number where you would like to place your X on (1/2/3): ");
					userCol = input.nextInt();
				}
			}
			if (array[userRow - 1][userCol - 1] == '-') { // if the user row and column is a space, put the X on the chosen spot
				array[userRow - 1][userCol - 1] = 'x';
				board.repaint();
				board.delay(2000);
			}
			if (array[compRow][compCol] != '-') { // if the computer row and column is not open, repeatedly
				for (int i = 0; i < array.length; i++) {
					for (int j = 0; j < array.length; j++) {
						if (array[i][j] == '-') {
							while ((array[compRow][compCol] == 'x' || array[compRow][compCol] == 'o')) { // generate random numbers until
								compRow = (int) (Math.random() * 3); // the numbers are not the same as a
								compCol = (int) (Math.random() * 3); //taken spot
							}
						} else if (array[i][j] == 'x' && array[i][j] == 'o') {
							compRow = (int) (Math.random() * 3); // taken spot
							compCol = (int) (Math.random() * 3);
						}
					}
				}
			}

			win(array); // method to determine the winner
			if (win == false) { // as long as the user has not won first, place the O on the chosen spot
				if (array[compRow][compCol] == '-') {
					array[compRow][compCol] = 'o';
					board.repaint();
				}
				win(array);
			}
			draw(array);
		}
		if (tie == true) {
			System.out.println("Tie!");
			if (win == false && tie == true) {
				board.setWinner("Tie!!!", 250, 650, 30);
				board.showText(true);
				board.repaint();
}
}
		if (win == true && x == true) {
			board.setWinner("X Wins!!!", 250, 650, 30);
			board.showText(true);
			board.repaint();
}
		if (win == true && o == true) {
			board.setWinner("O Wins!!!", 250, 650, 30);
			board.showText(true);
			board.repaint();
}
	}

	if (mode == 2) {
		int user1Row = 0; // defining user and computer rows/columns
		int user2Row = 0;
		int user1Col = 0;
		int user2Col = 0;
		while (play == true) { // running game until someone wins/draws
			System.out.print("P1: Enter a row number where you would like to place your X on (1/2/3): "); // ask for row and column
			user1Row = input.nextInt();
			System.out.print("P1: Enter a column number where you would like to place your X on (1/2/3): ");
			user1Col = input.nextInt();
			while ((user1Row <= 0 || user1Row >= 4) || (user1Col <= 0 || user1Col >= 4)) { // if the user enters a value outside the array,
				System.out.println("P1: ENTER A VALID ROW OR COLUMN!\n"); // ask the user to enter new values
				System.out.print("P1: Enter a row number where you would like to place your X on (1/2/3): ");
				user1Row = input.nextInt();
				System.out.print("P1: Enter a column number where you would like to place your X on (1/2/3): ");
				user1Col = input.nextInt();
			}
			if (array[user1Row - 1][user1Col - 1] != '-') { // if the user enters a taken spot, ask the user to enter new values
				while (array[user1Row - 1][user1Col - 1] != '-') { // and repeat until the user enters correct values
					System.out.println("P1: SPACE TAKEN!\n");
					System.out.print("P1: Enter a row number where you would like to place your X on (1/2/3): ");
					user1Row = input.nextInt();
					System.out.print("P1: Enter a column number where you would like to place your X on (1/2/3): ");
					user1Col = input.nextInt();
				}
			}

			System.out.print("P2: Enter a row number where you would like to place your O on (1/2/3): ");
			user2Row = input.nextInt();
			System.out.print("P2: Enter a column number where you would like to place your O on (1/2/3): ");
			user2Col = input.nextInt();

			while ((user2Row <= 0 || user2Row >= 4) || (user2Col <= 0 || user2Col >= 4)) { // if the user enters a value outside the array,
							System.out.println("P2: ENTER A VALID ROW OR COLUMN!\n"); // ask the user to enter new values
							System.out.print("P2: Enter a row number where you would like to place your O on (1/2/3): ");
							user2Row = input.nextInt();
							System.out.print("P2: Enter a column number where you would like to place your O on (1/2/3): ");
							user2Col = input.nextInt();
						}
						if (array[user2Row - 1][user2Col - 1] != '-' || (user2Row == user1Row && user2Col == user1Col)) { // if the user enters a taken spot, ask the user to enter new values
							while (array[user2Row - 1][user2Col - 1] != '-' || (user2Row == user1Row && user2Col == user1Col)) { // and repeat until the user enters correct values
								System.out.println("P2: SPACE TAKEN!\n");
								System.out.print("P2: Enter a row number where you would like to place your O on (1/2/3): ");
								user2Row = input.nextInt();
								System.out.print("P2: Enter a column number where you would like to place your O on (1/2/3): ");
								user2Col = input.nextInt();
							}
			}

			if (array[user1Row - 1][user1Col - 1] == '-') { // if the user row and column is a space, put the X on the chosen spot
				array[user1Row - 1][user1Col - 1] = 'x';
				board.repaint();
				board.delay(2000);
			}

			win(array); // method to determine the winner
			if (win == false) { // as long as X has not won first, place the O on the chosen spot
				if (array[user2Row - 1][user2Col - 1] == '-') {
					array[user2Row - 1][user2Col - 1] = 'o';
					board.repaint();
				}
				win(array);
			}
			draw(array);
		}
		if (tie == true) {
			System.out.println("Tie!");
				if (win == false && tie == true) {
					board.setWinner("Tie!!!", 250, 650, 30);
					board.showText(true);
					board.repaint();
			}
			}
				if (win == true && x == true) {
					board.setWinner("X Wins!!!", 250, 650, 30);
					board.showText(true);
					board.repaint();
			}
				if (win == true && o == true) {
					board.setWinner("O Wins!!!", 250, 650, 30);
					board.showText(true);
					board.repaint();
}
		}
}
	public static boolean win(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[0][i] == 'x' && array[1][i] == 'x' && array[2][i] == 'x') {
				System.out.println("X Wins!");
				win = true;
				play = false;
				x = true;
				break;
			} else if (array[0][i] == 'o' && array[1][i] == 'o' && array[2][i] == 'o') {
				System.out.println("O Wins!");
				win = true;
				play = false;
				o = true;
				break;
			} else if (array[i][0] == 'x' && array[i][1] == 'x' && array[i][2] == 'x') {
				System.out.println("X Wins!");
				win = true;
				play = false;
				x = true;
				break;
			} else if (array[i][0] == 'o' && array[i][1] == 'o' && array[i][2] == 'o') {
				System.out.println("O Wins!");
				win = true;
				play = false;
				o = true;
				break;
			} else if (array[2][0] == 'x' && array[1][1] == 'x' && array[0][2] == 'x') {
				System.out.println("X Wins!");
				win = true;
				play = false;
				x = true;
				break;
			} else if (array[2][0] == 'o' && array[1][1] == 'o' && array[0][2] == 'o') {
				System.out.println("O Wins!");
				win = true;
				play = false;
				o = true;
				break;
			} else if (array[2][2] == 'x' && array[1][1] == 'x' && array[0][0] == 'x') {
				System.out.println("X Wins!");
				win = true;
				play = false;
				x = true;
				break;
			} else if (array[2][2] == 'o' && array[1][1] == 'o' && array[0][0] == 'o') {
				System.out.println("O Wins!");
				win = true;
				play = false;
				o = true;
				break;
			}
		}
		return false;
	}
	public static boolean draw(char[][] array) {
		int places = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == 'x' || array[i][j] == 'o') {
					places += 1;
				}
			}
		}

		if (places == 9 && win == false) {
			play = false;
			tie = true;
		} else {
			places = 0;
		}
		return false;
	}
}