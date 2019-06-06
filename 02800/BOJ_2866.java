import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());		
		char[][] arr = new char[M][N];
	
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[j][i] = tmp.charAt(j);				
			}
		}
		
		int cnt = 0;
		for (int i = 1; i < N; i++) {
			HashSet<String> hs = new HashSet<String>();
			for (int k = 0; k < M; k++) {
				String tmp = String.copyValueOf(arr[k], i, N-i);
				if (hs.contains(tmp)) {
					bw.write(cnt + "\n");
					bw.flush();		
					bw.close();
					br.close();
					return;
				}
				hs.add(tmp);
			}			
			cnt++;
		}
		
		bw.write(cnt + "\n");
		
		
		bw.flush();		
		bw.close();
		br.close();
	} 
}
