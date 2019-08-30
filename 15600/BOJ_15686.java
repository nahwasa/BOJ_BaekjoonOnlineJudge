import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {	
	static int minCD = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// init
		LinkedList<Pos> h = new LinkedList<Pos>();
		LinkedList<Pos> c = new LinkedList<Pos>();
		// input
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				switch (st.nextToken()) {
				case "1" :
					h.add(new Pos(i,j));
					break;
				case "2" :
					c.add(new Pos(i,j));
					break;
				}
			}
		}
		Pos[] arr = new Pos[c.size()];
		int idx = 0;
		for (Pos cp : c)
			arr[idx++] = cp;
		c = new LinkedList<Pos>();
		recursion(h, c, arr, -1, M);
		bw.write(minCD + "\n");
		bw.flush();
		br.close();
		bw.close();	
	}
	
	private static void recursion(LinkedList<Pos> h, LinkedList<Pos> c, Pos[] arr, int idx, int M) {
		if (c.size()!=0)
			minCD = Math.min(minCD, getCD(h, c));
		if (c.size() == M)
			return;
		for (int i = idx+1; i<arr.length; i++) {
			c.addLast(arr[i]);
			recursion(h, c, arr, i, M);
			c.removeLast();
		}
	}

	private static int getCD(LinkedList<Pos> h , LinkedList<Pos> c) {
		int result = 0;
		for (Pos hp : h) {
			int min = Integer.MAX_VALUE;
			for (Pos cp : c) {
				int tmp = hp.getDistance(cp);
				min = Math.min(min, tmp);
			}
			result += min;
		}
		return result;
	}
}
class Pos {
	int x,y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getDistance(Pos p) {
		return Math.abs(x-p.x) + Math.abs(y-p.y);
	}
}
