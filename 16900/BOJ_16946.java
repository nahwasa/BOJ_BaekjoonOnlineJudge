import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {1, -1, 0, 0};
	private static int n, m, cnt, seq = 0;
	static boolean[][] free;
	static Pos[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		free = new boolean[n][m];
		map = new Pos[n][m];
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				free[i][j] = tmp.charAt(j) == '0' ? true : false;
			}
		}
		br.close();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (free[i][j]) {
					cnt = 0;
					List<Pos> list = new LinkedList<Pos>();
					fillFreeMap(list, i, j);
					for (Pos tmp : list) {
						tmp.freeSpace = cnt;
					}
					seq++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j]==null ? sumAdjacentMap(i, j) : 0);
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	private static int sumAdjacentMap(int i, int j) {
		int res = 1;
		Set<Integer> hs = new HashSet<Integer>();
		for (int z = 0; z < 4; z++) {
			int nx = i+dx[z];
			int ny = j+dy[z];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;
			Pos tmp = map[nx][ny];
			if (tmp == null || hs.contains(tmp.spaceSeq)) 
				continue;
			res += tmp.freeSpace;
			hs.add(tmp.spaceSeq);
		}
		return res % 10;
	}

	private static void fillFreeMap(List<Pos> list, int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= m || !free[i][j])
			return;
		
		cnt++;
		free[i][j] = false;
		Pos tmp = new Pos(seq);
		map[i][j] = tmp;
		list.add(tmp);
		
		for (int z = 0; z < 4; z++) {
			fillFreeMap(list, i+dx[z], j+dy[z]);
		}
	}
}

class Pos {
	int spaceSeq;
	int freeSpace;
	
	public Pos(int spaceNum) {
		freeSpace = 0;
		this.spaceSeq = spaceNum;
	}
	@Override
	public String toString() {
		return String.valueOf(freeSpace);
	}
	
}
