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
		int Q = Integer.parseInt(st.nextToken());
		int[] arr = new int [10000];	// 악보의수 100이하 * 시간 100이하 = 최대 10000개
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			int time = Integer.parseInt(br.readLine());
			for (int j = 0; j < time; j++)
				arr[idx++] = i;
		}
		for (int i = 0; i < Q; i++) {
			bw.write(arr[Integer.parseInt(br.readLine())] + "\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
