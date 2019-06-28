import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int R = Integer.parseInt(br.readLine());
		int sum = 0;
		int tmp = N;
		int grt = 2;
		while (true) {
			tmp = (int)(tmp * ((double)R/100));
			if (tmp <= 5)
				break;
			sum += tmp * grt;
			grt *= 2;
		}
		bw.write(sum+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
