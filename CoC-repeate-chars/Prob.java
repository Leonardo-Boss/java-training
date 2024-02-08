import java.util.Scanner;

public class Prob {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Solver solver = new Solver(input);
		System.out.println(solver.run());
		scanner.close();
	}
}

class Solver {
	private String digits;
	private String letters;
	private int number;
	private String input;
	private String result;

	public Solver(String str) {
		digits = "";
		letters = "";
		number = 1;
		input = str;
		result = "";
	} 

	public String run() {
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isDigit(c)) {
				digits = digits + c;
				isdigit();
			}
			else {
				letters = letters + c;
				isletter();
			}
		}
		isdigit();
		return result;
	}

	private void isdigit() {
		for (int j = 0; j < number; j++) {
			result += letters;
		}
		letters = "";
	}

	private void isletter() {
		if (digits.length()!=0) {
			number = Integer.parseInt(digits);
			digits = "";
		}
	}
}
