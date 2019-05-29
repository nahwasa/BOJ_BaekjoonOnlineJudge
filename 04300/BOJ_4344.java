import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {			
			int in = sc.nextInt();
			int[] score = new int[in];
			int sum = 0;
			
			for (int j = 0; j < in; j++) {
				score[j] = sc.nextInt();
				sum += score[j];
			}
			
			double avg = (double)sum / in;
			int cnt = 0;
			
			for (int j = 0; j < in; j++) {
				if (score[j] > avg)
					cnt++;
			}
			
			System.out.printf("%.3f%%\n", ((double)cnt / in) * 100);
		}
		
		sc.close();
	}
}
