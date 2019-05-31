import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int[] cnt = new int ['z'-'a'+1];
		
		while (sc.hasNext()) {
			String str = sc.next();
			for (int i = 0; i < str.length(); i++)
				cnt[str.charAt(i)-'a']++;
		}
		
		int max = 0;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] > max)
				max = cnt[i];
		}
		
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] == max)
				System.out.print((char)(i + 'a'));
		}
		System.out.println();
	}	
}
