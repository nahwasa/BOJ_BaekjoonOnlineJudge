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
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] cnt = new int[4];
		for (int i = 0; i < 4; i++)
			cnt[i] = Integer.parseInt(st.nextToken());
		LinkedList<Integer> ll = new LinkedList<Integer>();
		recursion(arr, cnt, ll);
		bw.write(max + "\n" + min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	private static void recursion(int[] arr, int[] cnt, LinkedList<Integer> ll) {
		if (ll.size() == arr.length-1) {
			int result = calc(arr, ll);
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (cnt[i]!=0) {
				int[] cntTmp = cnt.clone();
				cntTmp[i]--;
				ll.addLast(i);
				recursion(arr, cntTmp, ll);
				ll.removeLast();
			}
		}
	}
	private static int calc(int[] arr, LinkedList<Integer> ll) {
		int result = arr[0];
		Iterator<Integer> it = ll.iterator();
		for (int i = 1; i < arr.length; i++) {
			switch (it.next()) {
			case 0 : result += arr[i]; break;
			case 1 : result -= arr[i]; break;
			case 2 : result *= arr[i]; break;
			case 3 : result /= arr[i]; break;			
			}
		}
		return result;
	}

}
