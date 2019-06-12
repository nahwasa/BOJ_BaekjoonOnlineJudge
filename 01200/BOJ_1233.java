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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cnt = new int[81];
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int maxCnt = -1;
		int maxNum = 81;
		for (int i = 1; i <= a; i++)
			for (int j = 1; j <= b; j++)
				for (int k = 1; k <= c; k++) {
					int mul = i+j+k;
					cnt[mul]++;
					if (cnt[mul] > maxCnt) {
						maxCnt = cnt[mul];
						maxNum = mul;
					} else if (cnt[mul] == maxCnt && mul < maxNum) {
						maxNum = mul;
					}						
				}
					
		bw.write(maxNum + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
