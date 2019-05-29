import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		String str = a * b * c + "";
		
		for (int i = 0; i < 10; i++) {
			int result = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) - '0' == i)
					result++;
			}
			System.out.println(result);
		}
		
		sc.close();
	}	
}
