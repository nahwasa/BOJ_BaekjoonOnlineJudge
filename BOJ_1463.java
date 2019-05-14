import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// Exception
		if (n == 1) {
			System.out.println(0);
			sc.close();
			return;
		} else if (n == 2) {
			System.out.println(1);
			sc.close();
			return;
		} else if (n == 3) {
			System.out.println(1);
			sc.close();
			return;
		}		

		// initialize
		int[] num = new int[n + 1];

		num[1] = 0;
		num[2] = 1;
		num[3] = 1;

		for (int i = 4; i <= n; i++) {
			num[i] = Integer.MAX_VALUE;
		}		


		// DP
		for (int i = 4; i <= n; i++) {
			if (i % 3 == 0 && num[i] > num[i / 3] + 1) {
				num[i] = num[i / 3] + 1;
			} 

			if (i % 2 == 0 && num[i] > num[i / 2] + 1) {
				num[i] = num[i / 2] + 1;
			} 

			if (num[i] > num[i - 1] + 1) {
				num[i] = num[i - 1] + 1;
			}		
		}

		System.out.println(num[n]);

		sc.close();
	}
}
