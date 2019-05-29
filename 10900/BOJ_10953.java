import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
				
		for(int i = 0; i < cnt; i++) {
			String str = sc.next();
			int a = Integer.parseInt(str.substring(0, str.indexOf(",")));
			int b = Integer.parseInt(str.substring(str.indexOf(",")+1));
			System.out.println(a+b);			
		}
	}
}
