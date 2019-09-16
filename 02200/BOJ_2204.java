import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	static int M = 0;
	static int[] arr = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N==0) break;
			HashMap<String, String> hm = new HashMap<String, String>();
			String[] arr = new String[N];
			while (N-->0) {
				String s = br.readLine();
				String tmp = s.toLowerCase();
				hm.put(tmp, s);
				arr[N] = tmp;
			}
			Arrays.sort(arr);
			bw.write(hm.get(arr[0]) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
