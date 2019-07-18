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
		char[] str = br.readLine().toCharArray();
		int N = Integer.parseInt(br.readLine());
		while (N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			char tmp = str[a];
			str[a]=str[b];
			str[b]=tmp;
		}
		for (char c : str)
			bw.write(c);
		bw.newLine();
		bw.flush();
		bw.close();
		br.close();
	}
}
