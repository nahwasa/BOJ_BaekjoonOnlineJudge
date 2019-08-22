import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String s = br.readLine();
			if (s.equals("0")) break;
			StringTokenizer st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N+1];
			for (int i = 1; i <= N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			LinkedList<Integer> ll = new LinkedList<Integer>();
			recursion(arr, ll, 0, N);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void recursion(int[] arr, LinkedList<Integer> ll, int idx, int N) throws IOException {
		int size = ll.size();
		if (size == 6) {
			Iterator<Integer> it = ll.iterator();
			while (it.hasNext())
				bw.write(it.next() + " ");
			bw.newLine();
			return;
		}		
		for (int i = idx+1; i <= N-(6-size-1); i++) {
			ll.addLast(arr[i]);
			recursion(arr, ll, i, N);
			ll.removeLast();
		}
	}
}
