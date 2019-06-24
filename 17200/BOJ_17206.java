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
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (N-->0) {
			int n = Integer.parseInt(st.nextToken());
			int sum = 0;
			int tmp = n/3;
			sum += tmp*(tmp+1)/2*3;
			tmp = n/7;
			sum += tmp*(tmp+1)/2*7;
			tmp = n/21;
			sum -= tmp*(tmp+1)/2*21;
			bw.write(sum+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
