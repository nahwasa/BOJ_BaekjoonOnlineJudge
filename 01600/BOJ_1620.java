import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] arr = new String[N+1];
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 1; i <= N; i++) {
			arr[i] = br.readLine();
			hm.put(arr[i], i);
		}
		while (M-->0) {
			String input = br.readLine();
			if (input.charAt(0) >= '0' && input.charAt(0) <= '9')
				bw.write(arr[Integer.parseInt(input)] + "\n");
			else
				bw.write(hm.get(input) + "\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
