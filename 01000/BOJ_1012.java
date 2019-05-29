import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {	// # of tc
			StringTokenizer st = new StringTokenizer(br.readLine());
						
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			boolean[][] map = new boolean[x][y];
			for (int j = 0; j < c; j++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			
			bw.write(getNumOfBugs(x, y, map) + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}

	private static int getNumOfBugs(int x, int y, boolean[][] map) {
		int cnt = 0;
		Stack<Integer[]> st = new Stack<Integer[]>();
		
		for (int i = 0; i < x; i++) {			
			for (int j = 0; j < y; j++) {
				if (map[i][j]) {
					cnt++;
					st.push(new Integer[] {i, j});
					
					while (!st.isEmpty()) {
						Integer[] data = st.pop();
						map[data[0]][data[1]] = false;
						
						if (data[0] != 0 && map[data[0] - 1][data[1]]) {	// left
							st.push(new Integer[] {data[0] - 1, data[1]});
						}
						
						if (data[0] != x-1 && map[data[0] + 1][data[1]]) {	// right
							st.push(new Integer[] {data[0] + 1, data[1]});
						}
						
						if (data[1] != 0 && map[data[0]][data[1] - 1]) {
							st.push(new Integer[] {data[0], data[1] - 1});	// upper
						}
						
						if (data[1] != y-1 && map[data[0]][data[1] + 1]) {	// under
							st.push(new Integer[] {data[0], data[1] + 1});
						}
					}
				}
			}			
		}		
		
		return cnt;
	}	

}
