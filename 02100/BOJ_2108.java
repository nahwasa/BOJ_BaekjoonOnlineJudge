import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		int n = Integer.parseInt(br.readLine());		
	
		int sum = 0;
		int max = -4001;
		int min = 4001;
		int[] arr = new int[n];
		int[] cnt = new int[8001];	// -4000~4000까지 빈도수 측정
		for (int i = 0; i < n; i++) {
			int in = Integer.parseInt(br.readLine());
			sum += in;
			arr[i] = in;
			
			if (in > max)
				max = in;
			if (in < min)
				min = in;
			
			cnt[in + 4000]++;
		}
		
		int maxCnt = 0;
		int maxCntNum = 0;
		boolean chk = false;
		for (int i = 0; i < 8001; i++) {
			if (cnt[i] > maxCnt) {
				maxCnt = cnt[i];
				maxCntNum = i - 4000;
				chk = false;
			} else if (!chk && cnt[i] == maxCnt) {
				maxCntNum = i - 4000;
				chk = true;				
			}
		}
	
		Arrays.sort(arr);
		bw.write(Math.round((double)sum / n) + "\n");	// 산술평균
		bw.write(arr[n/2] + "\n");	//중앙값
		bw.write(maxCntNum + "\n");	//최빈값
		bw.write((max - min) + "\n");// 범위
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
