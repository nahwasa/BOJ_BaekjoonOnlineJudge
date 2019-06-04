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

		int maxNum = 0;
		int maxScore = 0;
		
		for (int i = 1; i <= 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int j = 0; j < 4; j++)
				sum += Integer.parseInt(st.nextToken());
			if (maxScore < sum) {
				maxScore = sum;
				maxNum = i;
			}
		}
		
		bw.write(maxNum + " " + maxScore + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
