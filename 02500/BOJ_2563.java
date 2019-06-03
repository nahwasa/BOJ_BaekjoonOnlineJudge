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

		boolean[][] arr = new boolean[100][100];
		int cnt = 0;
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j = x; j < (x + 10 < 100 ? x + 10 : 100); j++) {
				for (int k = y; k < (y + 10 < 100 ? y + 10 : 100); k++) {
					
					if (!arr[j][k])
						cnt++;
					arr[j][k] = true;
				}
			}
		
		}
		bw.write(cnt + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}	
