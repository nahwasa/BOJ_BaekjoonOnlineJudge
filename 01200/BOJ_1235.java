import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		for (int i = arr[0].length()-1; i >= 0; i--) {
			HashSet<String> hs = new HashSet<String>();
			boolean chk = true;
			for (int j = 0; j < N; j++) {
				if (!hs.add(arr[j].substring(i))) {
					chk = false;
					break;
				}
			}
			if (chk) {
				bw.write((arr[0].length() - i) + "\n");
				break;
			}
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
