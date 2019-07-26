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
		while (TC-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int leg = Integer.parseInt(st.nextToken());
			int chi = Integer.parseInt(st.nextToken());
			int tmp = chi*2-leg;
			bw.write(tmp + " " + (chi-tmp) + "\n");
		}
		bw.close();
		br.close();
	}
}
