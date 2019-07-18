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
		int S1 = Integer.parseInt(st.nextToken());
		int S2 = Integer.parseInt(st.nextToken());
		while (S1-->0) {
			st = new StringTokenizer(br.readLine());
			if (!st.nextToken().equals(st.nextToken())) {
				bw.write("Wrong Answer\n");
				bw.flush();
				return;
			}
		}
		while (S2-->0) {
			st = new StringTokenizer(br.readLine());
			if (!st.nextToken().equals(st.nextToken())) {
				bw.write("Why Wrong!!!\n");
				bw.flush();
				return;
			}
		}
		bw.write("Accepted\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
