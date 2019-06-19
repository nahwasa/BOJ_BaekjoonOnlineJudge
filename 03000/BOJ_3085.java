import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static char[][] arr;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		int maxCnt = cntLongestColor(null, null);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				if (i!=N-1 && arr[i][j] != arr[i+1][j])
					cnt = cntLongestColor(new ColorInfo(arr[i+1][j], i, j), new ColorInfo(arr[i][j], i+1, j));
				maxCnt = cnt>maxCnt?cnt:maxCnt;
				if (j!=N-1 && arr[i][j] != arr[i][j+1])
					cnt = cntLongestColor(new ColorInfo(arr[i][j+1], i, j), new ColorInfo(arr[i][j], i, j+1));
				maxCnt = cnt>maxCnt?cnt:maxCnt;
			}
		}
		bw.write(maxCnt + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
	
	static int cntLongestColor(ColorInfo c1, ColorInfo c2) {
		int maxCnt = Integer.MIN_VALUE;
		// Horizontal		
		for (int i = 0; i < N; i++) {
			int maxLineCnt = Integer.MIN_VALUE;
			int cnt = 0;
			char tmp = '%';
			for (int j = 0; j < N; j++) {
				char cur = arr[i][j];
				if (c1!=null && i == c1.x && j == c1.y)	cur = c1.c;
				if (c2!=null && i == c2.x && j == c2.y)	cur = c2.c;				
				if (cur != tmp) {
					tmp = cur;
					maxLineCnt = cnt>maxLineCnt?cnt:maxLineCnt;
					cnt = 1;
				} else {
					cnt++;
				}
			}
			maxLineCnt = cnt>maxLineCnt?cnt:maxLineCnt;
			maxCnt = maxLineCnt>maxCnt?maxLineCnt:maxCnt;
		}
		// Vertical	
		for (int i = 0; i < N; i++) {
			int maxLineCnt = Integer.MIN_VALUE;
			int cnt = 0;
			char tmp = '%';
			for (int j = 0; j < N; j++) {
				char cur = arr[j][i];
				if (c1!=null && i == c1.y && j == c1.x)	cur = c1.c;
				if (c2!=null && i == c2.y && j == c2.x)	cur = c2.c;				
				if (cur != tmp) {
					tmp = cur;
					maxLineCnt = cnt>maxLineCnt?cnt:maxLineCnt;
					cnt = 1;
				} else {
					cnt++;
				}
			}
			maxLineCnt = cnt>maxLineCnt?cnt:maxLineCnt;
			maxCnt = maxLineCnt>maxCnt?maxLineCnt:maxCnt;
		}				
		return maxCnt;
	}
}

class ColorInfo {
	char c;
	int x;
	int y;
	public ColorInfo(char c, int x, int y) {
		super();
		this.c = c;
		this.x = x;
		this.y = y;
	}	
}
