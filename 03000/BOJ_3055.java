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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];	// 물은 -1~음수 / 빈공간0 / 고슴도치는 1~양수 / 돌은 Integer.MAX_VALUE
		Queue<Pos> qPpl = new LinkedList<Pos>();
		Queue<Pos> qFire = new LinkedList<Pos>();
		Pos dst = null;
		for (int i = 0; i < N; i++) {	// 1.맵 입력받음
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				switch(input.charAt(j)) {
				case 'S' :
					arr[i][j] = 0;	// 어차피 큐에 넣어서 위치는 잃어버리지않고, 물 번지는거 봐야하니 일단 빈공간으로 둠.
					qPpl.add(new Pos(i,j));
					break;
				case '.' :
					arr[i][j] = 0;
					break;
				case 'X' :
					arr[i][j] = Integer.MAX_VALUE;
					break;
				case '*' :
					arr[i][j] = -1;
					qFire.add(new Pos(i,j));
					break;
				case 'D' :
					arr[i][j] = 0;
					dst = new Pos(i,j);
				}					
			}				
		}		
		while (!qFire.isEmpty()) {	// 2. 물을 음수로 내려가며 퍼지는 시간을 구함
			Pos tmp = qFire.poll();
			int x = tmp.x;
			int y = tmp.y;
			if (x == dst.x && y == dst.y) {	// 목적지점엔 물이 안차야 함
				arr[x][y] = 0;
				continue;
			}
			if (x>0&&arr[x-1][y]==0) {arr[x-1][y]=arr[x][y]-1; qFire.add(new Pos(x-1,y));}
			if (y>0&&arr[x][y-1]==0) {arr[x][y-1]=arr[x][y]-1; qFire.add(new Pos(x,y-1));}
			if (x<N-1&&arr[x+1][y]==0) {arr[x+1][y]=arr[x][y]-1; qFire.add(new Pos(x+1,y));}
			if (y<M-1&&arr[x][y+1]==0) {arr[x][y+1]=arr[x][y]-1; qFire.add(new Pos(x,y+1));}
		}	
		arr[qPpl.peek().x][qPpl.peek().y] = 1;	// 처음 시작시 물과 겹쳐있을 수는 없으니 물이던말던 바꿔도 됨.
		int escapeTime = -1;
		while (!qPpl.isEmpty()) {	// 3. 고슴도치를 양수로 증가하며 밖으로 나가는 시간을 구함
			Pos tmp = qPpl.poll();
			int x = tmp.x;
			int y = tmp.y;
			if (x == dst.x && y == dst.y) {
				escapeTime = arr[x][y];
				break;
			}
			if (x>0&&(arr[x-1][y]==0||-arr[x-1][y]>arr[x][y]+1)) {arr[x-1][y]=arr[x][y]+1; qPpl.add(new Pos(x-1,y));}
			if (y>0&&(arr[x][y-1]==0||-arr[x][y-1]>arr[x][y]+1)) {arr[x][y-1]=arr[x][y]+1; qPpl.add(new Pos(x,y-1));}
			if (x<N-1&&(arr[x+1][y]==0||-arr[x+1][y]>arr[x][y]+1)) {arr[x+1][y]=arr[x][y]+1; qPpl.add(new Pos(x+1,y));}
			if (y<M-1&&(arr[x][y+1]==0||-arr[x][y+1]>arr[x][y]+1)) {arr[x][y+1]=arr[x][y]+1; qPpl.add(new Pos(x,y+1));}
		}			
		if (escapeTime == -1)
			bw.write("KAKTUS\n");
		else
			bw.write((escapeTime-1) + "\n");

	
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
