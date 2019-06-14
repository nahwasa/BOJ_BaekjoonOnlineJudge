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
			String s1 = br.readLine();
			String s2 = br.readLine();
			int cnt = 0;
			for (int i = 0; i < s1.length(); i++)
				if (s1.charAt(i)!=s2.charAt(i))
					cnt++;
			bw.write(String.format("Hamming distance is %d.\n", cnt));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}	
}
