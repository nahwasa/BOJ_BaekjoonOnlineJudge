import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		Deque<Integer> dq = new LinkedList<Integer>();
		
		for (int i = 1; i <= n; i++)
			dq.addLast(i);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			while(true) {
				int idx = 0;
				Iterator<Integer> it = dq.iterator();
				
				while(it.hasNext()) {				
					if (it.next().equals(target))
						break;
					idx++;				
				}
				
				if (idx == 0) {
					dq.pollFirst();
					break;
				} else if (dq.size() / 2 >= idx) {					
					cnt++;
					dq.addLast(dq.pollFirst());
				} else {					
					cnt++;
					dq.addFirst(dq.pollLast());					
				}		
			}
		}
		
		bw.write(cnt + "\n");
			
		bw.flush();
		bw.close();
		br.close();
	}	
}
