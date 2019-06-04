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
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] pos = {-1,-1};
		
		for (int i = 0; i < a; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < b; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1 && pos[0] == -1) {
					pos[0] = i;
					pos[1] = j;
				} else if (input == 1) {
					bw.write( Math.abs(i - pos[0]) + Math.abs(j - pos[1]) + "\n");
					break;
				}
				
			}
		}
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
