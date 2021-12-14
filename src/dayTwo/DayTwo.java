package dayTwo;

public class DayTwo {
	private static String inputLine;
	private static int depth;
	private static int horizontalPos;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner("file.txt");
		
		while(scanner.hasNext()){
			inputLine = Scanner.next();
			
			String[] parts = inputLine.split(" ");
			
			switch(parts[0]){
				case "forward":
					horizontalPos += Integer.valueOf(parts[1]);
					break;
				case "up":
					depth -= Integer.valueOf(parts[1]);
					break;
				case "down":
					depth += Integer.valueOf(parts[1]);
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
