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
		int max = -1;
		int x = 0;
		int y = 0;
		for (int i = 1; i <= 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp > max) {
					max = tmp;
					x = i;
					y = j;
				}
			}
		}
		bw.write(String.format("%d\n%d %d\n", max, x, y));
		bw.flush();
		bw.close();
		br.close();
	}
}
