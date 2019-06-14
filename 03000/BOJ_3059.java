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
		while(TC-->0) {
			String s = br.readLine();
			boolean[] alph = new boolean['Z'-'A'+1];
			for (int i = 0; i<s.length(); i++)
				alph[s.charAt(i)-'A'] = true;
			int sum = 0;
			for (int i = 0; i<alph.length; i++)
				if (!alph[i])
					sum+=i+'A';
			bw.write(sum+"\n");
		}		
		bw.flush();
		bw.close();
		br.close();
	}	
}
