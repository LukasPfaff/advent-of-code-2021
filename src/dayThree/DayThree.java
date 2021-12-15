package dayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayThree {

	private static ArrayList<String> input = new ArrayList<>();
	private static int[] oxybin;
	private static int[] cobin;
	private static int length;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("src/dayThree/resources/DayThreeInput.txt"));

		while (scanner.hasNext()) {
			input.add(scanner.next());
		}

		scanner.close();
		length = input.get(0).length();
		oxybin = new int[length];
		cobin = new int[length];

		ArrayList<String> oxygen = new ArrayList<String>(input);
		ArrayList<String> coTwo = new ArrayList<String>(input);

		for (int i = 0; i < length; i++) {
			int zero = 0;
			int one = 0;
			for (String s : oxygen) {
				switch (Character.getNumericValue(s.charAt(i))) {
				case 0:
					zero++;
					break;
				case 1:
					one++;
					break;
				default:
					System.out.println("Sucks");
				}
			}
			if(oxygen.size() > 1) {
				if (zero > one) {
					for (int l = 0; l < oxygen.size(); l++) {
						if (Character.getNumericValue(oxygen.get(l).charAt(i)) == 1) {
							oxygen.remove(l);
							l--;
						}
					}
				} else {
					for (int l = 0; l < oxygen.size(); l++) {
						if (Character.getNumericValue(oxygen.get(l).charAt(i)) == 0) {
							oxygen.remove(l);
							l--;
						}
					}
				}
			}
			//----------------------------------------------------------
			
			int zeroCO = 0;
			int oneCO = 0;
			for (String s : coTwo) {
				switch (Character.getNumericValue(s.charAt(i))) {
				case 0:
					zeroCO++;
					break;
				case 1:
					oneCO++;
					break;
				default:
					System.out.println("Sucks");
				}
			}
			
			if(coTwo.size() > 1) {
				if (oneCO >= zeroCO) {
					for (int l = 0; l < coTwo.size(); l++) {
						if (Character.getNumericValue(coTwo.get(l).charAt(i)) == 1) {
							coTwo.remove(l);
							l--;
						}
					}
				} else {
					for (int l = 0; l < coTwo.size(); l++) {
						if (Character.getNumericValue(coTwo.get(l).charAt(i)) == 0) {
							coTwo.remove(l);
							l--;
						}
					}
				}
			}
		}

		for(int i = 0; i < length; i++) {
			oxybin[i] = Character.getNumericValue(oxygen.get(0).charAt(i));
			cobin[i] = Character.getNumericValue(coTwo.get(0).charAt(i));
		}
		System.out.println(toDecimal(oxybin));
		System.out.println(toDecimal(cobin));
		System.out.println("Task 2: " + toDecimal(oxybin) * toDecimal(cobin));

	}

	private static int toDecimal(int[] binary) {
		int decimal = 0;
		int j = 0;
		for (int i = binary.length - 1; i >= 0; i--) {
			decimal += binary[i] * Math.pow(2, j);
			j++;
		}

		return decimal;
	}
}
