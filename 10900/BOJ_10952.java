import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = -1;
		int b = -1;
		
		while(a != 0 && b != 0) {
			a = sc.nextInt();
			b = sc.nextInt();			
			
			if(0 < a && a < 10 && b > 0 && b < 10) {
				System.out.println(a+b);				
			}
		}
	}
}
