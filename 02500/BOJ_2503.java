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
		boolean[] arr = new boolean[1000];
		for (int i = 111; i < 1000; i++) {	// 옳은 형식 (1~9숫자, 모두 다른 숫자)만 true로 체크함.
			String tmp = String.valueOf(i);
			if (tmp.contains("0") || tmp.charAt(0) == tmp.charAt(1) || tmp.charAt(1) == tmp.charAt(2) || tmp.charAt(0) == tmp.charAt(2))
				continue;
			arr[i] = true;
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			for (int j = 111; j < 1000; j++) {
				if(!arr[j]) continue;
				String s1 = String.valueOf(num);
				String s2 = String.valueOf(j);
				int strikeCnt = 0;
				int ballCnt = 0;
				for (int k = 0; k < 3; k++) {
					int idx = s2.indexOf(s1.charAt(k));
					if (idx == k) strikeCnt++;
					else if (idx != -1) ballCnt++;
				}
				if (strikeCnt!=strike || ballCnt!=ball)
					arr[j] = false;
			}
		}
		
		int cnt = 0;
		for (int j = 111; j < 1000; j++)
			if (arr[j]) cnt++;
		bw.write(cnt + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
