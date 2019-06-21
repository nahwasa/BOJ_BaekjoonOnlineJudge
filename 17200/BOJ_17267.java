import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] arr;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new boolean[N][M];
		Pos start = null;
		cnt = 1;	// 시작지점 포함이므로 1
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < M; j++) {
				switch (in.charAt(j)) {
				case '0': arr[i][j]=true; break;
				case '2': start=new Pos(i, j, L, R); break;
				}
			}
		}
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(start);
		arr[start.x][start.y] = false;
		while (!q.isEmpty()) {
			Pos tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int l = tmp.l;
			int r = tmp.r;
			while(x-->0) if(!qProcess(q,x,y,l,r)) break;	// 위				
			x = tmp.x;
			while (x++<N-1) if(!qProcess(q,x,y,l,r)) break;	// 아래
			x = tmp.x;		
			if(y-1>=0 && l-1>=0) qProcess(q,x,y-1,l-1,r);	// 좌측
			if(y+1<M && r-1>=0) qProcess(q,x,y+1,l,r-1);	// 우측			
		}
		bw.write(cnt+"\n");		
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < M; j++) {
				bw.write(arr[i][j]?"0":"1");
			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();		
	}
	
	static boolean qProcess(Queue<Pos> q, int x, int y, int l, int r) {
		if (!arr[x][y])
			return false;
		q.add(new Pos(x,y,l,r));
		arr[x][y]=false;
		cnt++;
		return true;
	}
}

class Pos {
	int x;
	int y;
	int l;
	int r;
	public Pos(int x, int y, int l, int r) {
		this.x = x;
		this.y = y;
		this.l = l;
		this.r = r;
	}		
}
