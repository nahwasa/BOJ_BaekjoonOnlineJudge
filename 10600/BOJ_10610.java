import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] s = br.readLine().toCharArray();
		Arrays.sort(s);		
		
		if (s[0] != '0') {
			System.out.println("-1");
			return;
		}
		int sum = 0;
		for (int i = 0; i < s.length; i++) {
			sum += (s[i]-'0');
		}
		if (sum%3!=0)
			bw.write("-1\n");
		else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length; i++) {
				sb.append(s[s.length-1-i]);
			}
			bw.write(sb.toString()+"\n");
		}
			
				
		bw.flush();
		bw.close();
		br.close();
	}
}
