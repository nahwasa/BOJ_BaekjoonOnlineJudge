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
		int L = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[1001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[Integer.parseInt(st.nextToken())] = true;
		int cnt = 0;
		for (int i = 1; i <= 1000; i++) {
			if (arr[i]) {
				cnt++;
				for (int j = 0; j < L; j++)
					if (i+j <= 1000)
						arr[i+j] = false;
			}
		}
		bw.write(cnt+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
