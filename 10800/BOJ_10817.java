import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] n = new int[3];
		n[0] = sc.nextInt();
		n[1] = sc.nextInt();
		n[2] = sc.nextInt();
		
		int bigger = 0;
		int smaller = 1;
		
		if (n[0] < n[1]) {
			bigger = 1;
			smaller = 0;
		}
		
		if (n[bigger] < n[2])
			System.out.println(n[bigger]);
		else {
			if (n[smaller] < n[2])
				System.out.println(n[2]);
			else
				System.out.println(n[smaller]);
		}
			
	}
}
