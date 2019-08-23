import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int total = 0;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				total += arr[i][j];
			}
		}
		LinkedList<Integer> ll = new LinkedList<Integer>();
		recursion(N, ll, 0);
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void recursion(int N, LinkedList<Integer> ll, int idx) {
		if (ll.size() == N/2) {
			min = Math.min(min,	calc(N, ll));
			return;
		}
		for (int i = idx+1; i <= N; i++) {
			ll.addLast(i);
			recursion(N, ll, i);
			ll.removeLast();
		}
	}
	private static int calc(int N, LinkedList<Integer> ll) {
		int[] tmp = new int[N/2];
		int[] tmp2 = new int[N/2];
		int idx = 0;
		
		for (int j = 1; j < ll.get(0); j++) {
			tmp2[idx++]=j;
		}
		
		Iterator<Integer> it = ll.iterator();
		for (int i = 0; i < N/2; i++) {
			tmp[i] = it.next();
			
			if (i!=0) {
				for (int j = tmp[i-1]+1; j < tmp[i]; j++) {
					tmp2[idx++]=j;
				}
			}
		}
		for (int j = tmp[N/2-1]+1; j <= N; j++) {
			tmp2[idx++]=j;
		}
		
		int sum = 0;
		for (int i = 0; i < tmp.length-1; i++) {
			for (int j = i+1; j < tmp.length; j++) {
				sum += arr[tmp[i]][tmp[j]] + arr[tmp[j]][tmp[i]];
			}
		}
		tmp = tmp2;
		for (int i = 0; i < tmp.length-1; i++) {
			for (int j = i+1; j < tmp.length; j++) {
				sum -= arr[tmp[i]][tmp[j]] + arr[tmp[j]][tmp[i]];
			}
		}
		
		return Math.abs(sum);
	}
}
