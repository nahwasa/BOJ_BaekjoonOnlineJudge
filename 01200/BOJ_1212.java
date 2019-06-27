import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		boolean first1Chk = false;
		for (int i = 0; i < input.length(); i++) {		
			int tmp = input.charAt(i)-'0';
			for (int j = 4; j >= 1; j/=2) {
				int t = tmp / j;
				tmp %= j;
				if (!first1Chk) 
					first1Chk=(t==1?true:false);
				if (first1Chk)
					sb.append(t);
			}
		}
		if (!first1Chk)
			bw.write("0\n");
		else
			bw.write(sb.toString()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
