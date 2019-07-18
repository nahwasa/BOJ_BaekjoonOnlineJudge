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
			double n = Double.parseDouble(st.nextToken());
			while(st.hasMoreTokens()) {
				switch (st.nextToken()) {
				case "@" : n*=3; break;
				case "%" : n+=5; break;
				case "#" : n-=7; break;
				}
			}
			bw.write(String.format("%.2f\n", n));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
