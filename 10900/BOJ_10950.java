import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int[] result = new int[cnt];
		
		for (int i = 0; i < cnt; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			result[i] = a + b;
		}
		
		
		for (int i = 0; i < cnt; i++) {
			System.out.println(result[i]);
		}
		
	}
}
