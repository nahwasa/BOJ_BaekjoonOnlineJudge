import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int startX;
	static int startY;
	static int endX;
	static int endY;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			int m = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				cnt += isNeedPass(Integer.parseInt(st.nextToken())
						, Integer.parseInt(st.nextToken())
						, Integer.parseInt(st.nextToken()));
			}
			bw.write(cnt+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int isNeedPass(int x, int y, int r) {
		int swt = 0;
		
		// for start point.
		int xGap = startX > x ? startX - x : x - startX;
		int yGap = startY > y ? startY - y : y - startY;
		double distance = Math.sqrt(xGap * xGap + yGap * yGap);
		if (r > distance)
			swt++;
		
		// for end point.
		xGap = endX > x ? endX - x : x - endX;
		yGap = endY > y ? endY - y : y - endY;
		distance = Math.sqrt(xGap * xGap + yGap * yGap);
		if (r > distance)
			swt++;
		
		return swt % 2;
	}

}
