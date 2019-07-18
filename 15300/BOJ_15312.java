import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] alp = new int[] {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
		String tmp = br.readLine();
		String tmp2 = br.readLine();
		int[] arr = new int[tmp.length()*2];
		int idx = 0;
		int n = tmp.length()*2;
		for (int i = 0; i < tmp.length(); i++) {
			arr[idx++] = alp[tmp.charAt(i)-'A'];
			arr[idx++] = alp[tmp2.charAt(i)-'A'];			
		}		
		for (int i = 1; i<=n-2; i++) {
			for (int j = 0; j < n-i; j++) {
				arr[j] = (arr[j] + arr[j+1]) % 10;
			}
		}
		bw.write(String.format("%d%d\n", arr[0], arr[1]));		
		bw.flush();
		bw.close();
		br.close();
	}
}
