import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		br.readLine();
		String s = br.readLine();
		int cnt2 = 0;
		int cntE = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '2') cnt2++;
			else	cntE++;
		}
		if (cnt2>cntE)
			 bw.write("2\n");
		else if (cnt2<cntE)
			bw.write("e\n");
		else
			bw.write("yee\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
