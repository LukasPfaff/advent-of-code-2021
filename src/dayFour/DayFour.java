package dayFour;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class dayFour {

	private static String input;
	private static String[] inputSplitted;
	private static ArrayList<BingoBoard> boards = new ArrayList<>();
	private static int winningNumber;
	private static BingoBoard winningBoard;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("src/ressources/test.txt"));

		input = scanner.next();
		inputSplitted = input.split(",");
		while (scanner.hasNext()) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < 25; i++) {
				list.add(scanner.nextInt());
			}
			boards.add(new BingoBoard(list));
		}
		scanner.close();

		for(String s : inputSplitted){
			int asInt = Integer.parseInt(s);
			Boolean stop = false;
			
			for(BingoBoard board : boards){
				board.contains(asInt);
				stop = board.hasWon();
				if(stop){
					winningNumber = asInt;
					winningBoard = new BingoBoard(board);
				}
			}
			
			if(stop) break;
		}
		
		//int sum = winningBoard.sumOfUnmarked();
		
		System.out.println(winningNumber);
		//System.out.println(sum);
	}
}