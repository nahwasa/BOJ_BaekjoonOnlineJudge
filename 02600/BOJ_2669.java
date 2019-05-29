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
		
		StringTokenizer st;
		boolean[][] arr = new boolean[101][101];	//좌표가 1이상 100이하이므로.
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			for(int j = startX; j < endX; j++) {
				for (int k = startY; k < endY; k++) {
					arr[j][k] = true;
				}
			}
		}
		
		int cnt = 0;
		for(int j = 0; j < 101; j++) {
			for (int k = 0; k < 101; k++) {
				if (arr[j][k])
					cnt++;
			}
		}
		
		bw.write(cnt+"\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}
}
