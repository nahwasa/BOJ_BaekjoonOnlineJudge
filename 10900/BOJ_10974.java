import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> ll = new LinkedList<Integer>();
		boolean[] chk = new boolean[N+1];
		recursion(bw, N, chk, ll);
		bw.flush();
		br.close();
		bw.close();	
	}
	
	private static void recursion(BufferedWriter bw, int N, boolean[] chk, LinkedList<Integer> ll) throws IOException {
		if (ll.size() == N) {
			for (int a : ll)
				bw.write(a + " ");
			bw.newLine();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!chk[i]) {
				chk[i] = true;
				ll.addLast(i);
				recursion(bw, N, chk, ll);
				ll.removeLast();
				chk[i] = false;
			}
		}
	}
}
