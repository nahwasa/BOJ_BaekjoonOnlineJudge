import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " :");
		int H = -Integer.parseInt(st.nextToken().trim());
		int M = -Integer.parseInt(st.nextToken().trim());
		int S = -Integer.parseInt(st.nextToken().trim());
		st = new StringTokenizer(br.readLine(), " :");
		H += Integer.parseInt(st.nextToken().trim());
		M += Integer.parseInt(st.nextToken().trim());
		S += Integer.parseInt(st.nextToken().trim());
		if (S < 0) {
			M--;
			S += 60;
		}
		if (M < 0) {
			H--;
			M += 60;
		}
		if (H < 0) {
			H += 24;
		}
		int sec = S + M*60 + H*3600;
		bw.write(sec + "\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
