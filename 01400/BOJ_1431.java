import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int N = Integer.parseInt(br.readLine());
		LinkedList<String> ll = new LinkedList<String>();
		while (N-->0) {
			ll.add(br.readLine());
		}
		Collections.sort(ll, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length())
					return -1;
				else if (s1.length() > s2.length())
					return 1;
				
				// 길이 동일
				int sum1 = 0;
				for (int i = 0; i < s1.length(); i++)	// 숫자만 더함
					if (s1.charAt(i) >= '0' && s1.charAt(i) <= '9')
						sum1 += (s1.charAt(i) - '0');
				int sum2 = 0;
				for (int i = 0; i < s2.length(); i++)	// 숫자만 더함
					if (s2.charAt(i) >= '0' && s2.charAt(i) <= '9')
						sum2 += (s2.charAt(i) - '0');
				if (sum1 != sum2)
					return sum1-sum2;
				
				// 내부의 숫자 합도 같음 -> 사전순으로 비교
				return s1.compareTo(s2);
			}
		});
		for (String s : ll)
			bw.write(s + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
