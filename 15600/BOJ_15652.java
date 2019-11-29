import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> ll = new LinkedList<Integer>();
		recursion(1, n, ll, m);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void recursion(int s, int e, LinkedList<Integer> data, int cnt) throws IOException {
		if (data.size() == cnt) {
			for (int i : data)
				bw.write(i + " ");
			bw.newLine();
			return;
		}
		
		for (int i = s; i <= e; i++) {		
			data.addLast(i);
			recursion(i, e, data, cnt);
			data.removeLast();
		}
	}
}
