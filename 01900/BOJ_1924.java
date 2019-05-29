import java.util.Scanner;

public class Main{
	
	private static int day(int d) {
		int result = 0;
		
		switch (d) {
		case 4 : 
		case 6 :
		case 9 :
		case 11 :
			result += 30; 
			break;
		case 2 :
			result += 28;
			break;
		default :
			result += 31;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int n = 0;
		
		x -= 1;
		
		for (int i = 1; i <= x; i++) {
			n+= day(i);
		}
		
		n += y;
		
		switch(n % 7) {
		case 1 : System.out.println("MON"); break;
		case 2 : System.out.println("TUE"); break;
		case 3 : System.out.println("WED"); break;
		case 4 : System.out.println("THU"); break;
		case 5 : System.out.println("FRI"); break;
		case 6 : System.out.println("SAT"); break;
		case 0 : System.out.println("SUN"); break;
		}
		
		
	}
}
