import java.util.Scanner;
import java.util.regex.*;

public class MoreString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Solver solver = new Solver(input);
		System.out.println(solver.run());
		scanner.close();
	}
}

class Solver {
	private String input;
	private Matcher m;
	private String result;
	public Solver(String str) {
		input = str;
		Pattern p = Pattern.compile("\\D");
		m = p.matcher(input);
		result = "";
	}

	public String run() {
		int e = 0;
		int n;
		while (m.find()) {
			n = 1;
			if (e != m.start()) {
				n = Integer.parseInt(input.substring(e, m.start()));
			}
			result += new String(new char[n]).replace("\0", m.group());
			e = m.end();
		}
		return result;
	}
}
