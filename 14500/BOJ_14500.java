import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < M; j++) {
				LinkedList<Pos> ll = new LinkedList<Pos>();
				ll.addLast(new Pos(i, j, arr[i][j]));
				dfs(arr, ll);
			}
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	private static void dfs(int[][] arr, LinkedList<Pos> ll) {
		if (ll.size() == 4) {
			max = Math.max(max, ll.peekLast().sum);
			return;
		}
		if (ll.size() == 2) {
			if (ll.peekFirst().x < ll.peekLast().x && ll.peekLast().x < arr.length-1) {	// l 형태로 진행된 경우
				if (ll.peekLast().y > 0)
					max = Math.max(max, ll.peekLast().sum + arr[ll.peekLast().x+1][ll.peekLast().y] + arr[ll.peekLast().x][ll.peekLast().y-1]);
				if (ll.peekLast().y < arr[0].length-1)
					max = Math.max(max, ll.peekLast().sum + arr[ll.peekLast().x+1][ll.peekLast().y] + arr[ll.peekLast().x][ll.peekLast().y+1]);
			} else if (ll.peekFirst().y < ll.peekLast().y && ll.peekLast().y < arr[0].length-1) {	// ㅡ 형태로 진행된 경우
				if (ll.peekLast().x > 0)
					max = Math.max(max, ll.peekLast().sum + arr[ll.peekLast().x][ll.peekLast().y+1] + arr[ll.peekLast().x-1][ll.peekLast().y]);
				if (ll.peekLast().x < arr.length-1)
					max = Math.max(max, ll.peekLast().sum + arr[ll.peekLast().x][ll.peekLast().y+1] + arr[ll.peekLast().x+1][ll.peekLast().y]);
			}
		}
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {				
				if (i*j != 0 || (i==0 && j==0)) 
					continue;
				int rx = ll.peekLast().x+i;
				int ry = ll.peekLast().y+j;
				if (rx < 0 || rx >= arr.length || ry < 0 || ry >= arr[0].length)
					continue;
				Pos tmp = new Pos(rx, ry, ll.peekLast().sum + arr[rx][ry]);
				Iterator<Pos> it = ll.iterator();
				boolean flag = true;
				while (it.hasNext()) {
					if (tmp.compareTo(it.next()) == 0) {
						flag = false;
						break;
					}						
				}
				if (!flag)
					continue;
				ll.addLast(tmp);
				dfs(arr, ll);
				ll.removeLast();
			}
		}
	}	
}
class Pos implements Comparable<Pos>{
	int x,y,sum;
	public Pos(int x, int y, int sum) {
		this.x = x;
		this.y = y;
		this.sum = sum;
	}
	@Override
	public int compareTo(Pos o) {		
		return (x==o.x && y==o.y)?0:-1;
	}				
}
