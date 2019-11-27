import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] arr = new boolean[10001];
		for (int i = 2; i <= 5000; i++) {
			int tmp = i;
			while ((tmp+=i) <= 10000) {
				arr[tmp] = true;
			}
		}
		
		int tc = Integer.parseInt(br.readLine());
		while (tc-->0) {
			int n = Integer.parseInt(br.readLine());
			for (int i = n/2; i < n; i++) {
				if (!arr[i] && !arr[n-i]) {
					bw.write(String.format("%d %d\n", n-i, i));
					break;
				}					
			}
		}		
		bw.flush();		
	}
}
