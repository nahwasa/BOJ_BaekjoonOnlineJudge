import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] arr = new int[9][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 9; i++)
			arr[i][0] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 9; i++)
			arr[i][1] = Integer.parseInt(st.nextToken());
		boolean isRev = false;
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 2; j++) {
				sum1+=arr[i][0];
				if (sum1>sum2) isRev=true;
				sum2+=arr[i][1];
			}
			if (sum1>sum2) isRev=true;
		}
		bw.write(isRev?"Yes\n":"No\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
