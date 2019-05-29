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
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			int xTmp = 0;
			int yTmp = 0;
			while(true) {
				xTmp++;
				yTmp++;
				
				x += xTmp;
				cnt++;
				if (x >= y)
					break;
				
				y -= yTmp;
				cnt++;
				if (x >= y)
					break;	
				
			}
			bw.write(cnt + "\n");
			
		}
		
		
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
