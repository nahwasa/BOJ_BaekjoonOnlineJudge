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
		int[] arr = new int[N];
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int k = 0; k < N; k++) {
				if (i == 0)		arr[k] = Integer.parseInt(st.nextToken());
				else			arr[k] -= Integer.parseInt(st.nextToken());
			}
		}		
		int sIdx = 0;
		int eIdx = 0;
		int cnt = 0;
		for (int i = 0; i < N;) {	// 구간 찾기
			if (arr[i] == 0) {	// 이미 0인건 제외
				i++;
				continue;
			}
			if (arr[i] > 0) {	// 차이가 +인 구간에 대한 연산
				sIdx = i;
				eIdx = i;
				int min = arr[i];
				while(true) {
					eIdx++;
					if (eIdx == N || arr[eIdx]<=0)
						break;
					min = Math.min(min, arr[eIdx]);
				}
				cnt += min;
				for (int k = sIdx; k < eIdx; k++)
					arr[k]-=min;
			} else {	// 차이가 -인 구간에 대한 연산
				sIdx = i;
				eIdx = i;
				int max = arr[i];
				while(true) {
					eIdx++;
					if (eIdx == N || arr[eIdx]>=0)
						break;
					max = Math.max(max, arr[eIdx]);
				}
				cnt -= max;
				for (int k = sIdx; k < eIdx; k++)
					arr[k]-=max;
			}
		}
		bw.write(cnt + "\n");		
		bw.flush();
		bw.close();
		br.close();
	}
}
