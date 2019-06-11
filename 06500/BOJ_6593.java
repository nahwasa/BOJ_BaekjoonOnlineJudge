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
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (H == 0 && N == 0 && M == 0)
				break;
			int[][][] arr = new int[N][M][H];
			Queue<Pos> q = new LinkedList<Pos>();
			Pos goal = null;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < N; j++) {
					String input = br.readLine();					
					for (int k = 0; k < M; k++) {
						switch(input.charAt(k)) {
						case 'S' :
							arr[j][k][i] = 1;
							q.add(new Pos(j,k,i));
							break;
						case '#' :
							arr[j][k][i] = -1;
							break;
						case 'E' :
							goal = new Pos(j,k,i);
							break;
						}												
					}
				}
				br.readLine();	// 빈줄 버림
			}
			int goalTime = -1;
			while (!q.isEmpty()) {
				Pos tmp = q.poll();
				int x = tmp.x;
				int y = tmp.y;
				int z = tmp.z;				
				if (tmp.equals(goal)) {
					goalTime = arr[x][y][z];
					break;
				}
				if (x>0&&arr[x-1][y][z]==0) { arr[x-1][y][z]=arr[x][y][z]+1; q.add(new Pos(x-1,y,z)); }
				if (y>0&&arr[x][y-1][z]==0) { arr[x][y-1][z]=arr[x][y][z]+1; q.add(new Pos(x,y-1,z)); }
				if (z>0&&arr[x][y][z-1]==0) { arr[x][y][z-1]=arr[x][y][z]+1; q.add(new Pos(x,y,z-1)); }
				if (x<N-1&&arr[x+1][y][z]==0) { arr[x+1][y][z]=arr[x][y][z]+1; q.add(new Pos(x+1,y,z)); }
				if (y<M-1&&arr[x][y+1][z]==0) { arr[x][y+1][z]=arr[x][y][z]+1; q.add(new Pos(x,y+1,z)); }
				if (z<H-1&&arr[x][y][z+1]==0) { arr[x][y][z+1]=arr[x][y][z]+1; q.add(new Pos(x,y,z+1)); }
			}
			if (goalTime == -1)
				bw.write("Trapped!\n");
			else
				bw.write(String.format("Escaped in %d minute(s).\n", goalTime-1));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Pos {
	int x;
	int y;
	int z;
	public Pos(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public boolean equals(Object obj) {
		Pos p = (Pos)obj;		
		return p.x==this.x&&p.y==this.y&&p.z==this.z;
	}
	
}
