import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[M][N];
		while (K-->0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int i = x1; i < x2; i++)
				for (int j = y1; j < y2; j++)
					arr[i][j] = true;
		}
		Queue<Pos> q = new LinkedList<Pos>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!arr[i][j]) {
					q.add(new Pos(i,j));
					arr[i][j] = true;
				}
				int cnt = 0;
				while (!q.isEmpty()) {
					Pos tmp = q.poll();
					cnt++;
					int x = tmp.x;
					int y = tmp.y;
					if (x>0&&!arr[x-1][y]) {arr[x-1][y]=true; q.add(new Pos(x-1,y));}
					if (y>0&&!arr[x][y-1]) {arr[x][y-1]=true; q.add(new Pos(x,y-1));}
					if (x<M-1&&!arr[x+1][y]) {arr[x+1][y]=true; q.add(new Pos(x+1,y));}
					if (y<N-1&&!arr[x][y+1]) {arr[x][y+1]=true; q.add(new Pos(x,y+1));}
				}
				if (cnt!=0)
					ll.add(cnt);
			}
		}
		Collections.sort(ll);
		bw.write(ll.size() + "\n");
		for (Integer i : ll)
			bw.write(i + " ");
		bw.newLine();
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pos {
	int x;
	int y;
	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}	
}
