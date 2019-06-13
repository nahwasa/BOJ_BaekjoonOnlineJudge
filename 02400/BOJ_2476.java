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
		int max = -1;
		while (N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int result = 0;
			
			if (a==b && b==c && c==a) {
				result = 10000 + a * 1000;
			} else if (a==b) {
				result = 1000 + a * 100;
			} else if (b==c) {
				result = 1000 + b * 100;
			} else if (c==a) {
				result = 1000 + c * 100;
			} else {
				result = (a>b?(a>c?a:c):(b>c?b:c)) * 100;
			}
			
			if (result > max)
				max = result;
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
