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
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		int maxNum = 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[5];
			for (int j = 0; j < 5; j++)
				arr[j] = Integer.parseInt(st.nextToken());
			int segMax = 0;
			for (int x = 0; x < 3; x++) {
				for (int y = x+1; y < 4; y++) {
					for (int z = y+1; z < 5; z++) {
						segMax = Math.max(segMax, (arr[x]+arr[y]+arr[z]) % 10);
					}
				}
			}
			if (segMax >= max) {
				max = segMax;
				maxNum = i;
			}
		}
		bw.write(maxNum + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}	
}
