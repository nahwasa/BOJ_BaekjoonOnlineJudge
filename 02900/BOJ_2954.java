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
		StringBuilder sb = new StringBuilder(br.readLine());

		String[] arr = new String[] {"apa", "epe", "ipi", "opo", "upu"};
		String[] arr2 = new String[] {"a,", "e,", "i,", "o,", "u,"};
		for (int i = 0; i < arr.length; i++) {
			while (true) {
				int idx = sb.indexOf(arr[i]);
				if (idx == -1) break;
				sb.replace(idx, idx+3, arr2[i]);
			}
		}
		StringTokenizer st = new StringTokenizer(sb.toString(), ",");
		while (st.hasMoreTokens())
			bw.write(st.nextToken());
		bw.newLine();
		bw.flush();
		bw.close();
		br.close();
	}
}
