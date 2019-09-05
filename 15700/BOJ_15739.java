import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int sum = N*(N*N+1)/2;
		int crossSum1 = 0;
		int crossSum2 = 0;
		int[] colSum = new int[N];
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sumTmp = 0;
			for (int j = 0; j < N; j++) {
				int numTmp = Integer.parseInt(st.nextToken());
				if (!hs.add(numTmp)) {
					bw.write("FALSE\n");
					bw.flush();
					return;
				}
				sumTmp += numTmp;
				colSum[j] += numTmp;
				if (i == j)
					crossSum1 += numTmp;
				if (i+j == N-1)
					crossSum2 += numTmp;
			}
			if (sum != sumTmp) {
				bw.write("FALSE\n");
				bw.flush();
				return;
			}			
		}
		if (crossSum1 != sum)
			bw.write("FALSE\n");
		else if (crossSum2 != sum)
			bw.write("FALSE\n");
		else {
			for (int i = 0; i < N; i++) {
				if (colSum[i] != sum) {
					bw.write("FALSE\n");
					bw.flush();
					return;
				}
			}
			bw.write("TRUE\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
