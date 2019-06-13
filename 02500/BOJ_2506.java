import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = 0;
		while (st.hasMoreTokens()) {
			if (st.nextToken().charAt(0) == '1')
				s++;
			else
				s = 0;			
			sum+=s;
		}
		bw.write(sum+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
