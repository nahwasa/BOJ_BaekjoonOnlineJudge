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
			int[][] arr = new int[N][N];
			Queue<Pos> q = new LinkedList<Pos>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			q.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			arr[q.peek().x][q.peek().y] = 1;
			st = new StringTokenizer(br.readLine());
			Pos dst = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			while (!q.isEmpty()) {
				Pos tmp = q.poll();
				if (tmp.equals(dst))
					break;
				int x = tmp.x;
				int y = tmp.y;				
				if (x-2>=0&&y-1>=0&&arr[x-2][y-1]==0) {arr[x-2][y-1]=arr[x][y]+1; q.add(new Pos(x-2,y-1));}
				if (x-1>=0&&y-2>=0&&arr[x-1][y-2]==0) {arr[x-1][y-2]=arr[x][y]+1; q.add(new Pos(x-1,y-2));}
				if (x-2>=0&&y+1<=N-1&&arr[x-2][y+1]==0) {arr[x-2][y+1]=arr[x][y]+1; q.add(new Pos(x-2,y+1));}
				if (x-1>=0&&y+2<=N-1&&arr[x-1][y+2]==0) {arr[x-1][y+2]=arr[x][y]+1; q.add(new Pos(x-1,y+2));}
				if (x+2<=N-1&&y-1>=0&&arr[x+2][y-1]==0) {arr[x+2][y-1]=arr[x][y]+1; q.add(new Pos(x+2,y-1));}
				if (x+1<=N-1&&y-2>=0&&arr[x+1][y-2]==0) {arr[x+1][y-2]=arr[x][y]+1; q.add(new Pos(x+1,y-2));}
				if (x+2<=N-1&&y+1<=N-1&&arr[x+2][y+1]==0) {arr[x+2][y+1]=arr[x][y]+1; q.add(new Pos(x+2,y+1));}
				if (x+1<=N-1&&y+2<=N-1&&arr[x+1][y+2]==0) {arr[x+1][y+2]=arr[x][y]+1; q.add(new Pos(x+1,y+2));}
			}
			bw.write((arr[dst.x][dst.y]-1) + "\n");
		}
		
		
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
	@Override
	public boolean equals(Object arg0) {
		if (this.x == ((Pos)arg0).x && this.y == ((Pos)arg0).y)
			return true;
		return false;
	}
	
}
