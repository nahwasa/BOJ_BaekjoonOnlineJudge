import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] cnt = new int[101];
		int sum = 0;
		int max = 0;
		int maxCnt = 0;
		for (int i = 0; i < 10; i++) {
			int tmp = Integer.parseInt(br.readLine());
			cnt[tmp/10]++;
			sum += tmp;
			if (cnt[tmp/10] > maxCnt) {
				maxCnt = cnt[tmp/10];
				max = tmp;
			}
		}
		bw.write(sum/10 + "\n");
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
