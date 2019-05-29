import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		// 점수/M*100
		int M = 0;
		
		int[] score = new int[n];
		
		for (int i = 0; i < n; i++) {
			int in = sc.nextInt();
			if (in > M)
				M = in;
			score[i] = in;
		}		
		
		double result = 0;
		for (int i = 0; i < n; i++) {
			result += (double)score[i] / M * 100;
		}
		System.out.println(result / n);
	}
}
