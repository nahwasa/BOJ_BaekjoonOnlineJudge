import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String s = br.readLine();
			if (s==null) break;
			int[] cnt = new int[4];
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i)==' ') cnt[3]++;
				else if (s.charAt(i) <= '9') cnt[2]++;
				else if (s.charAt(i) >= 'a') cnt[0]++;
				else cnt[1]++;
			}
			for (int i = 0; i < cnt.length; i++)
				bw.write(cnt[i] + " ");
			bw.newLine();
		}
		bw.close();
		br.close();
	}
}
