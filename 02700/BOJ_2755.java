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
		double sum = 0.0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int tmp = Integer.parseInt(st.nextToken());
			cnt += tmp;
			sum += tmp * getScore(st.nextToken());
				
		}
		bw.write(String.format("%.2f\n", sum/cnt));		
		bw.flush();
		bw.close();
		br.close();
	}

	static double getScore(String s) {
		switch (s) {
		case"A+":return 4.3;
		case"A0":return 4.0;
		case"A-":return 3.7;
		case"B+":return 3.3;
		case"B0":return 3.0;
		case"B-":return 2.7;
		case"C+":return 2.3;
		case"C0":return 2.0;
		case"C-":return 1.7;
		case"D+":return 1.3;
		case"D0":return 1.0;
		case"D-":return 0.7;
		default:return 0.0;
		}
	}	
}
