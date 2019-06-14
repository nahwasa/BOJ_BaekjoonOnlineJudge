import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double sum = 0.0;
			sum += 350.34 * Integer.parseInt(st.nextToken());
			sum += 230.90 * Integer.parseInt(st.nextToken());
			sum += 190.55 * Integer.parseInt(st.nextToken());
			sum += 125.30 * Integer.parseInt(st.nextToken());
			sum += 180.90 * Integer.parseInt(st.nextToken());
			bw.write(String.format("$%.2f\n", sum));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
