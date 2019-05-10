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
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			bw.write(calcResult(x1, y1, r1, x2, y2, r2) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	private static int calcResult(int x1, int y1, int r1, int x2, int y2, int r2) {
		int xDistance = (x1 >= x2)? x1-x2 : x2-x1;
		int yDistance = (y1 >= y2)? y1-y2 : y2-y1;
		double distance = 0;
		
		if (xDistance == 0 && yDistance == 0) {
			if (r1 == r2)
				return -1;
			else
				return 0;			
		}
		
		if (xDistance == 0)
			distance = yDistance;
		else if (yDistance == 0)
			distance = xDistance;
		else
			distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
				// 피타고라스 정리
		
		if (distance == r1 + r2) {
			return 1;
		} else if (distance > r1 + r2) {
			return 0;
		} else {
			if (r1 == r2)
				return 2;
			
			int bigger = (r1 > r2)?r1 : r2;
			int smaller = (r1 < r2)?r1 : r2;
						
			if (bigger - distance > smaller)
				return 0;
			else if (bigger - distance == smaller)
				return 1;
			else
				return 2;
				
		}		
	}
}
