import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		boolean[] pn = new boolean[10001];
		pn[0] = pn[1] = true;
		for (int i = 2; i <= 100; i++) {
			int idx = 2;
			while (true) {
				int tmp = i*idx;
				if (tmp > 10000)
					break;
				pn[tmp] = true;
				idx++;
			}
		}
		int min = 0;
		int sum = 0;
		for (int i = M; i <= N; i++) {
			if (!pn[i]) {
				if (min == 0)
					min = i;
				sum+=i;
			}
		}
		if (sum == 0)
			bw.write("-1\n");
		else
			bw.write(String.format("%d\n%d\n", sum, min));
		bw.flush();
		br.close();
		bw.close();		
	}
}
