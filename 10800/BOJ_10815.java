import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<String> hs = new HashSet<String>();
		while (st.hasMoreTokens()) hs.add(st.nextToken());
		br.readLine();
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens())
			if (hs.contains(st.nextToken())) bw.write("1 ");
			else bw.write("0 ");
		bw.newLine();
		bw.close();
		br.close();
	}
}
