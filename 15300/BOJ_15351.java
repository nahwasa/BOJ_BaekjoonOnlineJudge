import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			String s = br.readLine();
			int sum = 0;
			for (int i = 0; i < s.length(); i++)
				if (s.charAt(i)!=' ') sum+=s.charAt(i)-'A'+1;
			if(sum==100) bw.write("PERFECT LIFE\n");
			else	 bw.write(sum+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
