import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// Input
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int SHARK_NUM = Integer.parseInt(st.nextToken());	
		// Initialize
		int[][] arr = new int[N][M];
		for (int i = 1; i <= SHARK_NUM; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			arr[n][m] = i;
			Shark.addShark(new Shark(i,n,m,s,d,z));
		}		
		// process
		int sum = 0;
		for (int i = 0; i < M; i++) {
			// catch shark
			for (int k = 0; k < N; k++) {
				if (arr[k][i] != 0) {
					sum += Shark.catched(arr[k][i]);
					break;
				}
			}
			// move shark
			arr = Shark.moveShark(N, M);
		}
		bw.write(sum + "\n");
		bw.flush();
		br.close();
		bw.close();	
	}
}

class Shark {
	static HashMap<Integer, Shark> cur = new HashMap<Integer, Shark>();
	int num,n,m,s,d,z;
	
	public Shark(int num, int n, int m, int s, int d, int z) {
		this.num = num;
		this.n = n;
		this.m = m;
		this.s = s;
		this.d = d;	//1:위 2:아래 3:오른쪽 4:왼쪽
		this.z = z;
	}
	
	static void addShark(Shark s) {
		cur.put(s.num, s);
	}
	
	static int getBiggestShark(LinkedList<Integer> colSet) {
		if (colSet.size() == 1)
			return colSet.get(0);

		Shark biggest = null;
		int max = 0;
		for (Integer num : colSet) {
			Shark tmp = cur.get(num);
			cur.remove(num);
			if (tmp.z > max) {
				max = tmp.z;
				biggest = tmp;
			}
		}
		addShark(biggest);
		return biggest.num;
	}
	
	static int catched(int num) {
		int result = cur.get(num).z;
		cur.remove(num);
		return result;
	}
	
	public static int[][] moveShark(int N, int M) {
		LinkedList<Integer>[][] colSet = new LinkedList[N][M];
		for (Integer k : cur.keySet()) {
			Shark tmp = cur.get(k);
			int x,y,div,mod;
			switch(tmp.d) {
			case 1 : //위
				y = N-1-tmp.n + tmp.s;	// 좌측일 경우 우측으로 방향을 바꿔서 생각함				
				div = y/(N-1);
				mod = y%(N-1);
				if ((div&1)==1) {
					tmp.n = N-1-mod;
					tmp.d = 2;	//change dir
				} else {
					tmp.n = mod;
				}				
				tmp.n = N-1-tmp.n;
				
				break;
			case 2 : //아래
				y = tmp.n + tmp.s;
				div = y/(N-1);
				mod = y%(N-1);
				if ((div&1)==1) {
					tmp.n = N-1-mod;
					tmp.d = 1;	//change dir
				} else {
					tmp.n = mod;
				}
				break;
			case 3 : //오른쪽
				x = tmp.m + tmp.s;
				div = x/(M-1);
				mod = x%(M-1);
				if ((div&1)==1) {
					tmp.m = M-1-mod;
					tmp.d = 4;	//change dir
				} else {
					tmp.m = mod;
				}
				break;
			case 4 : //왼쪽
				x = M-1-tmp.m + tmp.s;	// 좌측일 경우 우측으로 방향을 바꿔서 생각함				
				div = x/(M-1);
				mod = x%(M-1);
				if ((div&1)==1) {
					tmp.m = M-1-mod;
					tmp.d = 3;	//change dir
				} else {
					tmp.m = mod;
				}	
				tmp.m = M-1-tmp.m;
				break;
			}
			if (colSet[tmp.n][tmp.m] == null)
				colSet[tmp.n][tmp.m] = new LinkedList<Integer>();
			colSet[tmp.n][tmp.m].add(tmp.num);
		}
		// getBiggestSharks
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (colSet[i][j] != null)
					arr[i][j] = getBiggestShark(colSet[i][j]);
			}
		}
		return arr;
		
	}
}
