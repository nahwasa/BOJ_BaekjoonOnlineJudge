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
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];			
			boolean[] priorityExist = new boolean[10];
			int tp = 0;	// target priority
			for (int i = 0; i < N; i++) {	// get tp and chk priority existed
				arr[i] = Integer.parseInt(st.nextToken());
				priorityExist[arr[i]] = true;
				if (i == M)	tp=arr[i];
			}
			int cnt = 1;
			for (int i = 0; i < N; i++)	// cnt # of priorities bigger then tp
				if (arr[i] > tp) cnt++;			
			int lastIdx = getLastIdx(arr, priorityExist, tp);
			if (M < lastIdx) {
				for (int i = 0; i < M; i++)
					if(arr[i]==tp) cnt++;
				for (int i = lastIdx; i < N; i++)
					if (arr[i]==tp) cnt++;
			} else {
				for (int i = lastIdx; i < M; i++)
					if(arr[i]==tp) cnt++;
			}
			bw.write(cnt+"\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
	
	static int getLastIdx(int[] arr, boolean[] priorityExist, int tp) {
		int idx = 0;
		for (int i = 9; i > tp; i--) {
			if (priorityExist[i]) {
				boolean chk = false;
				for (int j = idx-1; j >= 0; j--)
					if (arr[j]==i) { chk = true; idx = j; break; }
				if (chk) continue;
				for (int j = idx+1; j < arr.length; j++)
					if (arr[j]==i) idx = j;
			}
		}
		return idx;
	}
}
