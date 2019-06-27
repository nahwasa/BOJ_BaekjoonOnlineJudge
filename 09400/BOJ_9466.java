import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
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
			int total = N;
			int[] select = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				select[i] = Integer.parseInt(st.nextToken());
			boolean[] chk = new boolean[N+1];	// 방문 확인
			for (int i = 1; i <= N; i++) {
				if (!chk[i]) {	// 아직 방문 안한곳이면 ㄱㄱ
					int idx = 0;
					HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();	// 루프가 몇번째이후로 생기는지 체크
					hm.put(i, idx++);
					chk[i] = true;
					int tmp = i;
					while (true) {
						int next = select[tmp];
						if (hm.containsKey(next)) {total-=(idx-hm.get(next)); break;}	// 루프가 생긴 인원수만큼 전체인원수에서 빼줌
						if (chk[next]) break;	// 진행 안됨.
						tmp = next;
						chk[next]=true; 
						hm.put(next, idx++);
					}
				}
			}
			bw.write(total + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
