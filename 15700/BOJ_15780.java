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
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		while (K-->0) {
			int hole = Integer.parseInt(st.nextToken());
			cnt += hole/2;
			if (hole%2==1)
				cnt += 1;
		}
		if (cnt >= N)
			bw.write("YES\n");
		else
			bw.write("NO\n");
		bw.flush();
		br.close();
		bw.close();	
	}
}
