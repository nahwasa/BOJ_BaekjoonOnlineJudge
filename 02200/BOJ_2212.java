import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < N; i++)
			hs.add(Integer.parseInt(st.nextToken()));	// 중복 없앰
		N = hs.size();	// 처음 N은 의미없음
		int[] arr = new int[N];
		Iterator<Integer> it = hs.iterator();
		int idx = 0;
		while (it.hasNext())
			arr[idx++] = it.next();		
		Arrays.sort(arr);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();		
		for (int i = 1; i < N; i++)
			pq.add(arr[i]-arr[i-1]);
		int sum = 0;
		for (int i = 0; i < N-K; i++) {
			sum+=pq.poll();
		}
		bw.write(sum+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}	
}
