import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[][] tmp = new String[3][];
		//initialize
		tmp[0] = new String[] {"1"};
		tmp[1] = new String[] {"1+1", "2"};
		tmp[2] = new String[] {"1+1+1", "1+2", "2+1", "3"};		
		//input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		//exception
		if (N<=3) {
			if (K<=tmp[N-1].length) bw.write(tmp[N-1][K-1] + "\n");
			else bw.write("-1\n");
			bw.flush();
			return;
		}
		//dp
		for (int i = 4; i <= N; i++) {
			String[] dummy = new String[tmp[0].length+tmp[1].length+tmp[2].length];
			int idx = 0;
			for (int k = 0; k < 3; k++)
				for (int j = 0; j < tmp[k].length; j++)
					dummy[idx++] = tmp[k][j] + "+" + String.valueOf(3-k);
			tmp[0]=tmp[1];
			tmp[1]=tmp[2];
			tmp[2]=dummy;
		}
		//output
		if (tmp[2].length < K)
			bw.write("-1\n");
		else {			
			Arrays.sort(tmp[2]);			
			bw.write(tmp[2][K-1]);
			bw.newLine();
		}		
		bw.flush();
		br.close();
		bw.close();		
	}
}
