import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static final String WIN_MSG = "I AM NOT IRONMAN!!\n";
	static final String LOSE_MSG = "I AM IRONMAN!!\n";
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int WIN_SCORE = Integer.parseInt(st.nextToken());
		int LOSE_SCORE = Integer.parseInt(st.nextToken());
		int DST_SCORE = Integer.parseInt(st.nextToken());
		
		HashSet<String> hs = new HashSet<String>();
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			if (st.nextToken().equals("W"))
				hs.add(tmp);
		}
		
		int score = 0;
		for (int i = 0; i < N; i++) {
			if (score >= DST_SCORE)
				break;
			
			if (hs.contains(br.readLine()))
				score += WIN_SCORE;
			else
				score -= LOSE_SCORE;
			
			if (score < 0)
				score = 0;
		}
		
		bw.write(score>=DST_SCORE?WIN_MSG:LOSE_MSG);
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
