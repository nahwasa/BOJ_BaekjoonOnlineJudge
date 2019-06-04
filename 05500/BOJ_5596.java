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

		int sum1 = 0;		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			sum1 += Integer.parseInt(st.nextToken());
		}
		
		int sum2 = 0;		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			sum2 += Integer.parseInt(st.nextToken());
		}
		
		bw.write((sum1>sum2?sum1:sum2) + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
