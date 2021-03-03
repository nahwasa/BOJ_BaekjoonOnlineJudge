import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int n = 0;
	
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		for (int i = 2; i <= 9; i++) {
			backTracking(1, i);
		}
		br.close();
	}
	
	private static void backTracking(int digit, int num) {
		if (!isPn(num))
			return;
		if (digit == n) {
			System.out.println(num);
			return;
		}
		for (int i = 0; i <= 9; i++)
			backTracking(digit+1, num*10+i);
	}
	
	private static boolean isPn(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) { 
			if (n%i == 0)
				return false;
		}
		return true;
	}
}
