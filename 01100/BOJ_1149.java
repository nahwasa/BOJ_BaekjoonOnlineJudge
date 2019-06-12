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
		int[] cost = new int[3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c0 = Integer.parseInt(st.nextToken()) + (cost[1]<cost[2]?cost[1]:cost[2]);
			int c1 = Integer.parseInt(st.nextToken()) + (cost[0]<cost[2]?cost[0]:cost[2]);
			int c2 = Integer.parseInt(st.nextToken()) + (cost[0]<cost[1]?cost[0]:cost[1]);		
			cost[0] = c0;
			cost[1] = c1;
			cost[2] = c2;			
		}
		bw.write((cost[0]<cost[1]?(cost[0]<cost[2]?cost[0]:cost[2]):(cost[1]<cost[2]?cost[1]:cost[2])) + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
