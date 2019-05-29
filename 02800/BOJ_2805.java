import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	static long[] tree;
	static int n;
	static long dst;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		dst = Long.parseLong(st.nextToken());
		
		tree = new long[n];
		
		st = new StringTokenizer(br.readLine());
		long max = 0;
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if (max < tree[i])
				max = tree[i];
		}
		
		if (dst == 0) {
			bw.write(max+"\n");
			bw.flush();
			br.close();
			bw.close();
			return;
		}
		
		long under = 1;
		long upper = max;
		while (under <= upper) {
			long height = (under + upper) / 2;
			long m = getCuttedTree(height);
			
			if (m == dst) {
				upper = height;
				break;
			} else if (m > dst) {
				under = height + 1;
			} else {
				upper = height - 1;
			}
		}
		bw.write(upper + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}

	private static long getCuttedTree(long h) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			if (tree[i] - h > 0)
				sum += (tree[i] - h);
			if (sum > dst)
				return sum;
		}
		
		return sum;
	}


}
