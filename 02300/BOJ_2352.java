import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(0);
		for (int i : arr) {
			if (ts.last() > i)
				ts.remove(ts.ceiling(i));
			ts.add(i);
		}
		bw.write((ts.size()-1) + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}	
}
