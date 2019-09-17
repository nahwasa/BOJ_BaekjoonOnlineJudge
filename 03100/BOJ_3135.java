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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int min = Math.abs(A-B);
		while (N-->0)
			min = Math.min(min, Math.abs(Integer.parseInt(br.readLine()) - B) + 1);
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
