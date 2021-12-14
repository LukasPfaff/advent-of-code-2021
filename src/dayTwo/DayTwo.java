package dayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwo {
	private static int depth;
	private static int horizontalPos;
	private static int aim;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("src/dayTwo/resources/DayTwoInput.txt"));
		
		while(scanner.hasNext()){
			
			switch(scanner.next()){
				case "forward":
					int tmp = scanner.nextInt();
					horizontalPos += tmp;
					depth += aim * tmp;
					break;
				case "up":
					aim -= scanner.nextInt();
					break;
				case "down":
					aim += scanner.nextInt();
					break;
				default:
					System.out.println("Houston, wir haben ein Problem");
					break;
			}		
		}			
		scanner.close();
		
		System.out.println("Horizontal position: " + horizontalPos);
		System.out.println("Depth: " + depth);
		System.out.println("Result: " + depth * horizontalPos);
	}

}
