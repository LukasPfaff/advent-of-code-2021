package dayOne;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayOne {
	
	private static ArrayList<Integer> depths = new ArrayList<>(); 
	private static int count = 0;
	
	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(new File("src/dayOne/resources/DayOneInput.txt"));
		
		while(scanner.hasNext()) {
			String depth = scanner.next();
			Integer depthInt = Integer.valueOf(depth);
			depths.add(depthInt);
		}
		
		scanner.close();
		
		System.out.println("Task 1");
		for(int i = 1; i < depths.size(); i++) {
			if(depths.get(i) > depths.get(i-1)) {
				//System.out.println(depths.get(i) + " increased");
				count++;
			}
			else {
				//System.out.println(depths.get(i) + " decreased");
			}
		}
		
		System.out.println();
		System.out.println(count);
		System.out.println();
		
		System.out.println("Task 2");
		count = 0;
		for(int i = 2; i < depths.size()-1; i++) {
			if(depths.get(i+1) > depths.get(i-2)) {
				//System.out.println(depths.get(i) + " increased");
				count++;
			}
			else {
				//System.out.println(depths.get(i) + " decreased");
			}
		}
		
		System.out.println();
		System.out.println(count);
		
	}
}
