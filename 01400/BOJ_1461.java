import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		LinkedList<Integer> ll1 = new LinkedList<Integer>();	// 음수
		LinkedList<Integer> ll2 = new LinkedList<Integer>();	// 양수
		while(N-->0) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp<0)	// 음수면 ll1에, 아니면 ll2에
				ll1.add(-tmp);
			else
				ll2.add(tmp);
		}
		
		int sum = 0;
		Collections.sort(ll1, Collections.reverseOrder());
		Collections.sort(ll2, Collections.reverseOrder());
		LinkedList<Integer> tmp = null;
		if (ll1.isEmpty())
			tmp = ll2;
		else if (ll2.isEmpty())
			tmp = ll1;
		else {
			if (ll1.get(0) >= ll2.get(0))
				tmp = ll1;
			else
				tmp = ll2;
		}		
		sum += tmp.poll();
		for (int i = 0; i < M-1; i++)
			tmp.poll();
		
		for(int z = 0; z < 2; z++) {	// ll1과 ll2에 대해 각각 M개씩 끊어서 가장 큰 숫자의 2배만큼 sum에 더함. 
			if (z==0) tmp = ll1;
			else tmp = ll2;
			int idx = 0;
			while (!tmp.isEmpty()) {
				if (idx==0) sum += tmp.poll()*2;
				else tmp.poll();
				idx++;
				idx%=M;
			}
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
