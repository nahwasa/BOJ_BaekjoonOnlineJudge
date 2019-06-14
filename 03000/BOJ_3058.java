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
		int TC = Integer.parseInt(br.readLine());
		while(TC-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			int sum = 0;
			int min = Integer.MAX_VALUE;
			while (st.hasMoreTokens()) {	
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp%2 == 0) {
					sum += tmp;
					if (tmp < min)
						min = tmp;
				}
			}
			bw.write(sum + " " + min + "\n");
		}		
		bw.flush();
		bw.close();
		br.close();
	}	
}
