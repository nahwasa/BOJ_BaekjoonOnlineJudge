import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());	
		while (TC-->0) {
			int N = Integer.parseInt(br.readLine());
			Pos[] data = new Pos[N];
			boolean[][] arr = new boolean[N][N];
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				data[i]=new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			for (int i=0; i<N; i++)
				for (int j=i+1; j<N; j++)
					if (Pos.includeChk(data[i],data[j])) arr[i][j]=arr[j][i]=true;
			data = new Pos[0];
			Queue<Integer> q = new LinkedList<Integer>();
			boolean[] visit = new boolean[N];
			int groupCnt = 0;
			for (int i=0; i<N; i++) {
				if(!visit[i]) { 
					groupCnt++; 
					visit[i]=true; 
					q.add(i);
					while (!q.isEmpty()) {
						for (int j=0; j<N; j++)
							if (!visit[j]&&arr[q.peek()][j]) { visit[j]=true; q.add(j); }
						q.poll();
					}
				} 
			}
			bw.write(String.format("%d\n", groupCnt));
		}
		bw.flush();
		br.close();
		bw.close();		
	}	
}

class Pos {
	int x,y,r;
	public Pos(int x, int y, int r) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
	}
	static boolean includeChk(Pos p1, Pos p2) {
		return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y)) <= (p1.r+p2.r);
	}
}
