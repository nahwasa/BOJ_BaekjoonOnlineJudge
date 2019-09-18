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
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= 100000000; i++) {
			boolean chk = true;
			for (int j = 0; j < N; j++) {
				if (arr[j] % i != 0) {
					chk = false;
					break;
				}
			}
			if (chk)
				bw.write(i + "\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
