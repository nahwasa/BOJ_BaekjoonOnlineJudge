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
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] arr = new int[F+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S);
		arr[S] = 1;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			if (tmp == G) {
				arr[0] = -1;	// 출력했는지 체크용으로 사용
				bw.write((arr[G]-1) + "\n");
				break;
			}
			if (tmp+U<=F&&arr[tmp+U]==0) {arr[tmp+U]=arr[tmp]+1; q.add(tmp+U);}
			if (tmp-D>=1&&arr[tmp-D]==0) {arr[tmp-D]=arr[tmp]+1; q.add(tmp-D);}
		}
		if (arr[0] != -1)
			bw.write("use the stairs\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
