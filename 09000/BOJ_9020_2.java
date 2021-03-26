import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[10001];
		for (int i = 2; i <= Math.sqrt((double)10001); i++) {
			int tmp = i;
			while (true) {
				tmp += i;
				if (tmp > 10000)	break;
				arr[tmp] = true;
			}
		}
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (tc-->0) {
			int n = Integer.parseInt(br.readLine());
			for (int i = n/2; i < n; i++) {
				if (!arr[i] && !arr[n-i]) {
					sb.append(n-i).append(" ").append(i).append("\n");
					break;
				}					
			}
		}
		System.out.println(sb);
	}
}
