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
		int tmp = Integer.parseInt(st.nextToken());
		bw.write(tmp + " ");
		for (int i = 2; i <= N; i++) {
			int cur = i * Integer.parseInt(st.nextToken());
			bw.write((cur-tmp) + " ");
			tmp = cur;
		}
		bw.newLine();
		bw.flush();
		br.close();
		bw.close();		
	}
}
