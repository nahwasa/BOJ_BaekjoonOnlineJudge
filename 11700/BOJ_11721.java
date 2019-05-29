import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		for (int i = 0; i <= str.length() / 10; i++) {
			if (i == str.length() / 10)
				System.out.println(str.substring(i * 10));
			else
				System.out.println(str.substring(i * 10, i * 10 +10));
		}
	}
}
