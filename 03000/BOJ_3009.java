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
		int x1 = 0;
		int x2 = 0;
		int y1 = 0;
		int y2 = 0;
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (x1 == 0)
				x1 = x;			
			else if (x1 == x)
				x1 = -1;
			else if (x2 == 0)
				x2 = x;
			else if (x2 == x)
				x2 = -1;
			
			if (y1 == 0)
				y1 = y;			
			else if (y1 == y)
				y1 = -1;
			else if (y2 == 0)
				y2 = y;
			else if (y2 == y)
				y2 = -1;
		}		
		bw.write(String.format("%d %d\n", x1==-1?x2:x1, y1==-1?y2:y1));		
				
		bw.flush();
		bw.close();
		br.close();
	}	
}
