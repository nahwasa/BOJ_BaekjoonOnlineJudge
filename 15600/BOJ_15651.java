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
		boolean[] v = new boolean[n+1];
		recursion(v, ll, m);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void recursion(boolean[] v, LinkedList<Integer> data, int cnt) throws IOException {
		if (data.size() == cnt) {
			for (int i : data)
				bw.write(i + " ");
			bw.newLine();
			return;
		}
		
		for (int i = 1; i < v.length; i++) {
			if (v[i])
				continue;
			data.addLast(i);
			v[i] = true;
			
			recursion(new boolean[v.length], data, cnt);
			data.removeLast();
		}
	}
}
