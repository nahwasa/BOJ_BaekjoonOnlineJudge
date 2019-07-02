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
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		while (N-->0) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp > max) max = tmp;
			if (tmp < min) min = tmp;
		}
		bw.write(String.format("%d %d\n", min, max));
		bw.flush();
		bw.close();
		br.close();
	}	
}
