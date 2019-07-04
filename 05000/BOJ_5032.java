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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int sum = 0;
		while (e>=c) {
			int tmp = e/c;
			sum += tmp;
			e = tmp + e%c;
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
