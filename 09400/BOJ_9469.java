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
			int idx = Integer.parseInt(st.nextToken());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());
			double d = Double.parseDouble(st.nextToken());
			bw.write(String.format("%d %.6f\n", idx, (a/(b+c))*d));	
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
