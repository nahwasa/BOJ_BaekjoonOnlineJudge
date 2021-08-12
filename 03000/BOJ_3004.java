import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		System.out.print((n/2+1) * (n-(n/2+1)+2));
	}
}
