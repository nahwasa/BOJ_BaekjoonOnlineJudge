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
		int tmp = N;
		int cnt = 0;
		while (true) {
			if (cnt++ > 100000) {
				bw.write("UNHAPPY\n");
				break;
			}			
			int sum = 0;
			while(tmp>9) {
				int mod = tmp%10;
				sum+=mod*mod;
				tmp/=10;
			}
			sum+=tmp*tmp;			
			if (sum == 1) {
				bw.write("HAPPY\n");
				break;
			}
			if (sum == N) {
				bw.write("UNHAPPY\n");
				break;
			}
			tmp=sum;
		}
		
		bw.flush();
		bw.close();
		br.close();
	}	
}
