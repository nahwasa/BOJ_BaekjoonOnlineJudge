import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int in = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < in; i++) {
			String ox = br.readLine();
			
			bw.write(calcScore(ox));
		}		
		
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static String calcScore(String ox) {
		int score = 0;
		int tmp = 0;
				
		for (int i = 0; i < ox.length(); i++) {
			if (ox.charAt(i) == 'O')
				tmp++;
			else
				tmp = 0;
			
			score += tmp;
		}
		
		return score + "\n";
	}
	
}
